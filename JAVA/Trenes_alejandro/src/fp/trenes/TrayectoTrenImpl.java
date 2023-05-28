package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TrayectoTrenImpl implements TrayectoTren, Comparable<TrayectoTren>{
	private String codigo;
	private String nombre;
	private TipoTren tipo;
	private List<String> estaciones = new LinkedList<String>();
	private List<LocalTime> horas_salida = new LinkedList<LocalTime>();
	private List<LocalTime> horas_llegada = new LinkedList<LocalTime>();
	
	private boolean check_codigo(String codigo) {
		boolean r = true;
		if(codigo.length()==5)
			for (int i=0;i<5;i++)
				r = r && codigo.charAt(i)>='0' && codigo.charAt(i)<='9';
		
				else r=false;
		return r;
	}
	
	public TrayectoTrenImpl(String codigo,String nombre,TipoTren tipo,
			String estacion_salida,
			String estacion_llegada,
			LocalTime hora_salida,
			LocalTime hora_llegada) {
		super();
		try {
			if (check_codigo(codigo)==false)
				throw new IllegalArgumentException("Código incorrecto.");
			if (hora_salida==null)
				throw new IllegalArgumentException("Hora de salida incorrectia.");
			if (hora_llegada==null)
				throw new IllegalArgumentException("Hora de llegada incorrecta.");
			if (hora_llegada.isBefore(hora_salida))
				throw new IllegalArgumentException("Hora de salida anterior");
			this.codigo= codigo;
			this.nombre=nombre;
			this.tipo=tipo;
			this.estaciones.add(estacion_salida);
			this.horas_llegada.add(null);
			this.horas_salida.add(hora_salida);
			this.estaciones.add(estacion_llegada);
			this.horas_llegada.add(hora_llegada);
			this.horas_salida.add(null);
		}catch(IllegalArgumentException e ) {System.out.println(e.getMessage());}
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoTren getTipo() {
		return tipo;
	}

	public List<String> getEstaciones() {
		return estaciones;
	}

	public List<LocalTime> getHoras_salida() {
		return horas_salida;
	}

	public List<LocalTime> getHoras_llegada() {
		return horas_llegada;
	}
	
	public LocalTime getHoraSalida() {
		return horas_salida.get(0);
	}
	
	public LocalTime getHoraLlegada() {
		return horas_salida.get(horas_llegada.size()-1);
	}
	
	public LocalTime getHoraSalida(String estacion) {
		LocalTime r = null;
		if(estaciones.contains(estacion)) {
			int pos=0;
			boolean enc=false;
			while(!enc) {
				if (estaciones.get(pos).equals(estacion)) enc=true;
				else pos++;
			}
			r=horas_salida.get(pos);
		}
		else 
			System.out.println("Estacion no encontrada: "+ estacion);
		
		return r;
	}
	
	public LocalTime getHoraLlegada(String estacion) {
		LocalTime r = null;
		if (estaciones.contains(estacion)) {
			int pos=0;
			boolean enc=false;
			while (!enc) {
				if (estaciones.get(pos).equals(estacion)) enc=true;
				else pos++;
			}
			r=horas_llegada.get(pos);
		}
		else
			System.out.println("Estación no encontrada: "+estacion);
		
		return r;
	}
	
	public Duration getDuracionTrayecto() {
		LocalTime inicio = horas_salida.get(0);
		LocalTime fin = horas_llegada.get(estaciones.size()-1);
		int duracion_segundos=fin.toSecondOfDay()-inicio.toSecondOfDay();
		return Duration.ofSeconds(duracion_segundos);
	}
	
	public void anadirEstacionIntermedia(int posicion, String estacion,
			LocalTime horaLlegada,LocalTime horaSalida) {
		try {
			if (posicion>=1 || posicion<estaciones.size()) {
				estaciones.add(posicion,estacion);
				horas_llegada.add(posicion,horaLlegada);
				horas_salida.add(posicion,horaSalida);
			}
			else {
				throw new IllegalArgumentException("Posicion no intermedia.");
			}
		}catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
	}
	
	public void eliminarEstacionIntermedia(String estacion) {
			try {
				if(!estaciones.contains(estacion) || 
				estaciones.get(0).equals(estacion)||
				estaciones.get(estaciones.size()-1).equals(estacion))
					throw new IllegalArgumentException("Estacion incorrecta. ");
			}catch(IllegalArgumentException e) {System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		String texto =  nombre + "-" + tipo + " (" + codigo + ")\n";
		for(int i=0;i<estaciones.size();i++){
		   if (i==0)
	          texto+="   "+estaciones.get(i)+"\t     "+horas_salida.get(i)+"\n";
		   else
		      if (i==(estaciones.size()-1))
	             texto+="   "+estaciones.get(i)+"     "+horas_llegada.get(i)+"\t\n";
		      else
		    	  texto+="   "+estaciones.get(i)+"\t     "+horas_llegada.get(i)+"     "+horas_salida.get(i)+"\t\n";
		}
		return texto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, estaciones, horas_llegada, horas_salida, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrayectoTrenImpl other = (TrayectoTrenImpl) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(estaciones, other.estaciones)
				&& Objects.equals(horas_llegada, other.horas_llegada)
				&& Objects.equals(horas_salida, other.horas_salida) && Objects.equals(nombre, other.nombre)
				&& tipo == other.tipo;
	}
	
	public int compareTo(TrayectoTren t) {
		int r = this.nombre.compareTo(t.getNombre());
		if (r==0) {
			r = this.getHoraSalida().compareTo(t.getHoraSalida());
		    if (r==0)
		       r = this.getCodigo().compareTo(t.getCodigo());
		}
		return r;
	}
}