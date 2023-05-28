package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fp.utiles.Checkers;

public class TrayectoTrenImpl2 implements TrayectoTren {

	private String codigoTren;
	private String nombreTrayecto;
	private TipoTren tipo;
	private List<ElementoTrayecto> elementos;

	public TrayectoTrenImpl2(String codigoTren, String nombreTrayecto, TipoTren tipo, String origen, String destino,
			LocalTime horaSalida, LocalTime horaLlegada) {

		Checkers.check("El código del tren no está formado por 5 dígitos", 
				esCodigoTrenOK(codigoTren));
		Checkers.checkNoNull(horaSalida, horaLlegada);
		Checkers.check("La hora salida no es anterior a la de llegada", 
				horaSalida.isBefore(horaLlegada));

		this.codigoTren = codigoTren;
		this.nombreTrayecto = nombreTrayecto;
		this.tipo = tipo;
		this.elementos = new LinkedList<>();
		this.elementos.add(new ElementoTrayecto(origen,null,horaSalida));
		this.elementos.add(new ElementoTrayecto(destino,horaLlegada,null));
	}

	private Boolean esCodigoTrenOK(String codigo) {
		return codigo.length() == 5 && sonDigitos(codigo);
	}

	private Boolean sonDigitos(String codigo) {
		Boolean res = true;
		for (int i = 0; i < codigo.length(); i++) {
			res = res && Character.isDigit(codigo.charAt(i));
			if (!res) {
				break;
			}
		}
		return res;
	}

	public String getCodigoTren() {
		return codigoTren;
	}

	public String getNombre() {
		return nombreTrayecto;
	}

	public TipoTren getTipoTren() {
		return tipo;
	}

	public List<String> getEstaciones() {
		List<String> r = new LinkedList<>();
		for(ElementoTrayecto e:this.elementos)
			r.add(e.nombre());
		return r;
	}

	public List<LocalTime> getHorasLlegada() {
		List<LocalTime> r = new LinkedList<>();
		for(ElementoTrayecto e:this.elementos)
			r.add(e.horaLlegada());
		return r;
	}

	public List<LocalTime> getHorasSalida() {
		List<LocalTime> r = new LinkedList<>();
		for(ElementoTrayecto e:this.elementos)
			r.add(e.horaSalida());
		return r;
	}

	public LocalTime getHoraSalida() {
		return elementos.get(0).horaSalida();
	}

	public LocalTime getHoraLlegada() {
		return elementos.get(elementos.size()-1).horaLlegada();
	}

	public Duration getDuracionTrayecto() {
		return Duration.between(getHoraSalida(), getHoraLlegada());
	}
	
	private int buscarElementoTrayecto(String estacion) {
		int pos = 0;
		boolean encontrado = false;
		while (!encontrado && pos<elementos.size()) {
			if (elementos.get(pos).nombre().equals(estacion)) 
				encontrado = true;
			else
				pos++;
		}
		return pos;
	}

	public LocalTime getHoraSalida(String estacion) {
		LocalTime res = null;
		int pos = buscarElementoTrayecto(estacion);
		if (pos<elementos.size())
			res = elementos.get(pos).horaSalida();
		return res;
	}

	public LocalTime getHoraLlegada(String estacion) {
		LocalTime res = null;
		int pos = buscarElementoTrayecto(estacion);
		if (pos<elementos.size())
			res = elementos.get(pos).horaLlegada();
		return res;
	}

	public void anadirEstacionIntermedia(int posicion, String nombre, 
			LocalTime horaLlegada, LocalTime horaSalida) {
		Checkers.check("La posicion intermedia no está entre 1 y n", 
				posicion > 0 && posicion <= elementos.size() - 1);
		Checkers.check("La hora salida no es posterior a la de llegada", 
				horaSalida.isAfter(horaLlegada));
		
		elementos.add(posicion, 
				new ElementoTrayecto(nombre, horaLlegada, horaSalida));
	}

	public void eliminarEstacionIntermedia(String estacion) {
		int pos = buscarElementoTrayecto(estacion);
		Checkers.check("La estación a eliminar no puede ser la primera", pos != 0);
		Checkers.check("La estación a eliminar no puede ser la última", pos != elementos.size() - 1);
		Checkers.check("La estación no está en el trayecto",pos<elementos.size());
		elementos.remove(pos);
	}

	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof TrayectoTren) {
			TrayectoTren tt = (TrayectoTren) obj;
			res = getCodigoTren().equals(tt.getCodigoTren()) && getNombre().equals(tt.getNombre())
					&& getHoraSalida().equals(tt.getHoraSalida());

		}
		return res;
	}

	public int hashCode() {
		return getCodigoTren().hashCode() + 31 * getNombre().hashCode();
	}

	public int compareTo(TrayectoTren tt) {
		int res = getNombre().compareTo(tt.getNombre());
		if (res == 0) {
			res = getHoraSalida().compareTo(tt.getHoraSalida());
			if (res == 0) {
				res = getCodigoTren().compareTo(tt.getCodigoTren());
			}
		}
		return res;
	}

	public String toString() {
		String res = getNombre() + "-" + getTipoTren() + " (" + getCodigoTren() + ")\n";
		for (int i = 0; i < elementos.size(); i++) {
			res += "\t" + elementos.get(i).nombre() + "\t" + 
		           formateaHora(elementos.get(i).horaLlegada()) + "\t"
					+ formateaHora(elementos.get(i).horaSalida()) + "\n";
		}

		return res;
	}

	private String formateaHora(LocalTime hora) {
		String res = "     ";
		if (hora != null) {
			res = hora.format(DateTimeFormatter.ofPattern("hh:mm"));
		}
		return res;
	}
}
