package fp.coordenadas;

import java.util.Objects;

public class Coordenadas implements Comparable<Coordenadas>{
	
	private Double latitud;
	private Double longitud;
	
	//Constructor con restricciones
	public Coordenadas(Double latitud, Double longitud) {
		if(latitud>90 || latitud< -90) {
			throw new IllegalArgumentException("La latitud tiene que esta comprendida entre -90 y 90");
		}
		if(longitud>180 ||longitud<-180) {
			throw new IllegalArgumentException(
					"La longuitud tiene que estar entre -180 y 180");
		}
		this.latitud = latitud;
		this.longitud = longitud;
	}
	//Constructor elemento vacío
	public Coordenadas() {
		latitud =0.;
		longitud=0.;	
	}
	
	public Coordenadas(String s) {
		//Eliminar caracteres innecesarios
		String s1 =s.replace("(", "").replace(")", "");
		//Trocear la cadena y confirmar el numero de trozos
		String[] sp=s1.split(",");
		if(sp.length!=2) {
			throw new IllegalArgumentException("Cadena con formato no válido");
		}
		//Parsear datos
		Double lat=Double.valueOf(sp[0].trim());
		Double lon=Double.valueOf(sp[1].trim());
		
		if(lat>90 || lat <-90) {
			throw new IllegalArgumentException(
					"La latitud debe estar comprendida entre -90 y 90");
		}
		if(lon>180 || lon<-180){
			throw new IllegalArgumentException(
					"La longitud debe estar comprendida entre -180 y 180");
		}
		
		latitud=lat;
		longitud=lon;
	}
	
	//metodos getters y setters
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		if(latitud>90 ||latitud<-90) {
			throw new IllegalArgumentException(
					"La latitud debe estar comprendida entre -90 y 90");
		}
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(Double longitud) {
		if(longitud>180||longitud<-180) {
			throw new IllegalArgumentException(
					"La longitud debe estar comprendida entre -180 y 180");
		}
		this.longitud = longitud;
	}
	//propiedad derivada
	public Hemisferio getHemisferio() {
		Hemisferio res;
		if(latitud>0) {
			res=Hemisferio.NORTE;
		}
		else {
			res=Hemisferio.SUR;
		}
		return res;
	}
	//operacion
	public Double getDistancia(Coordenadas c) {
		Double d;
		Double diflat = latitud -c.getLatitud();
		Double diflon =longitud-c.getLongitud();
		d= Math.sqrt(diflat*diflat + diflon*diflon);
		return d;
	}
	//to string
	@Override
	public String toString() {
		return "Coordenadas [latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	//metodo hashcode
	@Override
	public int hashCode() {
		return Objects.hash(latitud, longitud);
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
		Coordenadas other = (Coordenadas) obj;
		return Objects.equals(latitud, other.latitud) && Objects.equals(longitud, other.longitud);
	}
	//Método compareTo
	public int compareTo(Coordenadas c) {
		int res=0;
		res=getLatitud().compareTo(c.getLatitud());
		if(res==0) {
			res=getLongitud().compareTo(c.getLongitud());
		}
		return res;
	}
	
	
}
