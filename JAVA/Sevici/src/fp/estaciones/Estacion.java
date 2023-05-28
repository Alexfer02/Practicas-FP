package fp.estaciones;

import java.util.Comparator;
import java.util.Objects;

import fp.coordenadas.*;

public class Estacion implements Comparable<Estacion> {
	
	//Atributos
	private String nombre;
	private Integer puestos;
	private Integer bicis_disponibles;
	private Coordenadas ubicacion;
	private Integer puestos_vacios;
	private Boolean tiene_bicis_disponibles;
	
	//Constructor con parametros
	public Estacion(String nombre, Integer puestos, Integer bicis_disponibles, Coordenadas ubicacion, Boolean tiene_bicis_disponibles) {
		if(puestos<=0) {
			throw new IllegalArgumentException(
					"Los puestos tienen que ser mayor que 0");
		}
		if(bicis_disponibles<0||bicis_disponibles>puestos) {
			throw new IllegalArgumentException(
					"El número de bicicletas disponibles debe ser mayor o igual que 0 y menor o igual que el número de puestos");
		}
		this.nombre = nombre;
		this.puestos = puestos;
		this.bicis_disponibles = bicis_disponibles;
		this.ubicacion = ubicacion;
		this.puestos_vacios = puestos-bicis_disponibles; //propiedad derivada
		this.tiene_bicis_disponibles = tiene_bicis_disponibles;
	}
	//Constructor a partir de String
	public Estacion(String s) {
		String[] s1=s.split(",");
		if(s1.length!=5) {
			throw new IllegalArgumentException("Cadena con formato no valido");
		}
		String nombre=s1[0];
		Integer puestos=Integer.valueOf(s1[1]);
		Integer bicis_disponibles=Integer.valueOf(s1[2]);
		Coordenadas ubicacion= new Coordenadas(Double.valueOf(s1[3]), Double.valueOf(s1[4]));
		Integer puestos_vacios=puestos-bicis_disponibles;
		Boolean tiene_bicis_disponibles = false;
		if(bicis_disponibles>0) {
			tiene_bicis_disponibles=true;
		}
		this.nombre=nombre;
		this.puestos=puestos;
		this.bicis_disponibles=bicis_disponibles;
		this.ubicacion=ubicacion;
		this.puestos_vacios=puestos_vacios;
		this.tiene_bicis_disponibles=tiene_bicis_disponibles;
	}
	
	//Metodos getters and setters
	
	public String getNombre() {
		return nombre;
	}
	public Integer getPuestos() {
		return puestos;
	}
	public Integer getBicis_disponibles() {
		return bicis_disponibles;
	}
	public Coordenadas getUbicacion() {
		return ubicacion;
	}
	public Integer getPuestos_vacios() {
		return puestos_vacios;
	}
	public Boolean getTiene_bicis_disponibles() {
		return tiene_bicis_disponibles;
	}
	
	public void setBicis_disponibles(Integer bicis_disponibles) {
		this.bicis_disponibles = bicis_disponibles;
	}
	//metodo hash
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	//metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacion other = (Estacion) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	//metodo to string con propiedades basicas
	@Override
	public String toString() {
		return "Estacion [nombre=" + nombre + ", puestos=" + puestos + ", bicis_disponibles=" + bicis_disponibles
				+ ", ubicacion=" + ubicacion + ", tiene_bicis_disponibles=" + tiene_bicis_disponibles + "]";
	}
	//metodo compareTo
	public int compareTo(Estacion e) {
		int res=0;
		res=getNombre().compareTo(e.getNombre());
		return res;
		}
}
