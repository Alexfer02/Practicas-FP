package fp.avistamientos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.coordenadas.Coordenadas;

public class Avistamientos {

	// Atributos

	private Set<Avistamiento> avistamientos;

	// Constructores

	public Avistamientos() {
		this.avistamientos = new HashSet<>();
	}
	
	public Avistamientos(Set<Avistamiento> s) {
		this.avistamientos.addAll(s);
	}
	
	// Otras operaciones
	
	public void añadirAvistamiento(Avistamiento av) {
		avistamientos.add(av);
	}

	// Método toString

	public String toString() {
		return "Avistamientos [avistamientos=" + avistamientos + "]";
	}
	
	// Método hashCode

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avistamientos == null) ? 0 : avistamientos.hashCode());
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
		Avistamientos other = (Avistamientos) obj;
		if (avistamientos == null) {
			if (other.avistamientos != null)
				return false;
		} else if (!avistamientos.equals(other.avistamientos))
			return false;
		return true;
	}
	
	// Tratamientos secuenciales
	
	// Número total de avistamientos en una fecha dada
	public Integer getNumeroAvistamientosFecha(LocalDate f) {
		int cont = 0;
		for (Avistamiento av:avistamientos)
			if (av.getFecha().isEqual(f))
				cont++;
		return cont;
	}

	// Avistamientos cercanos a una ubicación dada
	public Set<Avistamiento> getAvistamientosCercanosUbicacion(Coordenadas c,
			Double d) {
		Set<Avistamiento>r = new HashSet<>();
		for(Avistamiento av:avistamientos)
			if (av.getUbicacion().getDistancia(c) < d)
				r.add(av);
		return r;
	}
	
	// ¿Algún avistamiento en un lugar dado en un año dado?
	public Boolean existeAvistamientoLugarAño(String l, Integer a) {
		for (Avistamiento av:avistamientos)
			if (av.getLugar().equals(l) && av.getAño().equals(a))
				return true;
		return false;
	}

	// Avistamiento más largo
	public Avistamiento getAvistamientoMayorDuracion() {
		Integer duracion = -1;
		Avistamiento r = null;
		for(Avistamiento av:avistamientos)
			if (av.getDuracion()>duracion) {
				duracion=av.getDuracion();
				r=av;
			}
		return r;
	}
	
	// Avistamientos por fecha
	public Map<LocalDate, Set<Avistamiento>> getAvistamientosPorFecha() {
		Map<LocalDate, Set<Avistamiento>>r = new HashMap<>();
		for(Avistamiento av:avistamientos)
			if (r.containsKey(av.getFecha()))
				r.get(av.getFecha()).add(av);
			else {
				Set<Avistamiento>s=new HashSet<>();
				s.add(av);
				r.put(av.getFecha(), s);
			}
		return r;
	}

	// Número de avistamientos por año
	public Map<Integer, Long> getNumeroAvistamientosPorAño() {
		Map<Integer, Long>r = new HashMap<>();
		for(Avistamiento av:avistamientos)
			if (r.containsKey(av.getAño())) {
				Long n = r.get(av.getAño());
				r.put(av.getAño(),n+1);
			}
			else 
				r.put(av.getAño(), 1L);
			
		return r;
	}

}
