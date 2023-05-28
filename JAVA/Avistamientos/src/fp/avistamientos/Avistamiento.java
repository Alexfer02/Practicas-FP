package fp.avistamientos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.coordenadas.Coordenadas;

public class Avistamiento implements Comparable<Avistamiento> {

	// Atributos
	
	private LocalDate fecha;
	private String lugar;
	private Integer duracion;
	private Forma forma;
	private Coordenadas ubicacion;
	
	// Constructores
	
	public Avistamiento(LocalDate f, String l, Integer d, Forma fo,
			Coordenadas u) {
		
		if (d <= 0) {
			throw new IllegalArgumentException(
					"La duración debe ser mayor que 0");
		}
		if (f.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException(
					"La fecha debe ser igual o anterior a la de hoy");
		}
		
		this.fecha = f;
		this.lugar = l;
		this.duracion = d;
		this.forma = fo;
		this.ubicacion = u;
	}
	
	public Avistamiento(String l, Integer d, Forma fo, Coordenadas u) {
		//this.fecha = LocalDate.now();
		//this.lugar = l;
		//this.duracion = d;
		//this.forma = fo;
		//this.ubicacion = u;
		
		// También:
		this(LocalDate.now(), l, d, fo, u);
		// El primer constructor chequea las restricciones
	}
	
	// Representación (ejemplo): "21/01/2019; Sevilla; 30; CIRCULAR; (37.38, -5.97)"
	public Avistamiento(String s) {
		
		// Trocear cadena y chequear número de trozos
		String[] sp = s.split(";");
		if (sp.length != 5) {
			throw new IllegalArgumentException("Cadena con formato no válido");
		}
		
		// Convertir trozos al tipo correspondiente
		LocalDate f = LocalDate.parse(sp[0].trim(),
				DateTimeFormatter.ofPattern("d/M/y"));
		String l = sp[1].trim();
		Integer d = Integer.valueOf(sp[2].trim());
		Forma fo = Forma.valueOf(sp[3].trim());
		Coordenadas u = new Coordenadas(sp[4].trim());

		// Chequear restricciones
		if (d <= 0) {
			throw new IllegalArgumentException(
					"La duración debe ser mayor que 0");
		}
		if (f.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException(
					"La fecha debe ser igual o anterior a la de hoy");
		}
		
		// Almacenar valores en los atributos
		this.fecha = f;
		this.lugar = l;
		this.duracion = d;
		this.forma = fo;
		this.ubicacion = u;
	}

	// Métodos getters y setters
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	
	public Forma getForma() {
		return forma;
	}
	
	public Coordenadas getUbicacion() {
		return ubicacion;
	}
	
	public void setLugar(String l) {
		this.lugar = l;
	}
	
	public void setDuracion(Integer d) {
		
		if (d <= 0) {
			throw new IllegalArgumentException(
					"La duración debe ser mayor que 0");
		}

		this.duracion = d;
	}
	
	// Propiedad derivada
	
	public Integer getAño() {
		return fecha.getYear();
	}
	
	// Otras operaciones
	
	public Double getDistancia(Avistamiento av) {
		return ubicacion.getDistancia(av.getUbicacion());
	}
	
	// Método toString
	
	public String toString() {
		return "Avistamiento [fecha=" + fecha + ", lugar=" + lugar + ", duracion=" + duracion + ", forma=" + forma
				+ ", coordenadas=" + ubicacion + "]";
	}

	// Método hashCode
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((lugar == null) ? 0 : lugar.hashCode());
		return result;
	}

	// Método equals
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avistamiento other = (Avistamiento) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (lugar == null) {
			if (other.lugar != null)
				return false;
		} else if (!lugar.equals(other.lugar))
			return false;
		return true;
	}

	// Método compareTo

	public int compareTo(Avistamiento c) {
		int res = fecha.compareTo(c.getFecha());
		if (res == 0) {
			res = lugar.compareTo(c.getLugar());
		}
		return res;
	}
	
}
