package fp.coordenadas;

public class Coordenadas implements Comparable<Coordenadas> {
	
	// Atributos
	
	private Double latitud;
	private Double longitud;
	
	// Constructores
	
	public Coordenadas() {
		latitud = 0.;
		longitud = 0.;
		
		// También:
		//this(0.0, 0.0);
	}
	
	public Coordenadas(Double lat, Double lon) {
		if (lat > 90 || lat < -90) {
			throw new IllegalArgumentException(
				"La latitud debe estar comprendida entre -90º y +90º");
		}
		if (lon > 180 || lon < -180) {
			throw new IllegalArgumentException(
				"La longitud debe estar comprendida entre -180º y +180º");
		}
		latitud = lat;
		longitud = lon;
	}
	
	// Representación (ejemplo): "(-1.5, 0.22)"
	public Coordenadas(String s) {
		
		// 1. Eliminar caracteres innecesarios, si procede
		String s1 = s.replace("(", "").replace(")", "");
		
		// 2. Trocear cadena y chequear número de trozos
		String[] sp = s1.split(",");
		if (sp.length != 2) {
			throw new IllegalArgumentException("Cadena con formato no válido");
		}
		
		// 3. Convertir trozos al tipo correspondiente
		Double lat = Double.valueOf(sp[0].trim());
		Double lon = Double.valueOf(sp[1].trim());

		// 4. Chequear restricciones
		if (lat > 90 || lat < -90) {
			throw new IllegalArgumentException(
				"La latitud debe estar comprendida entre -90º y +90º");
		}
		if (lon > 180 || lon < -180) {
			throw new IllegalArgumentException(
				"La longitud debe estar comprendida entre -180º y +180º");
		}
		
		// 5. Almacenar valores en los atributos
		latitud = lat;
		longitud = lon;
	}
	
	// Métodos getters y setters
	
	public Double getLatitud() {
		return this.latitud;
	}
	
	public Double getLongitud() {
		return longitud;
	}
	
	public void setLatitud(Double lat) {
		if (lat > 90 || lat < -90) {
			throw new IllegalArgumentException(
				"La latitud debe estar comprendida entre -90º y +90º");
		}
		this.latitud = lat;
	}
	
	public void setLongitud(Double lon) {
		if (lon > 180 || lon < -180) {
			throw new IllegalArgumentException(
				"La longitud debe estar comprendida entre -180º y +180º");
		}
		longitud = lon;
	}
	
	// Propiedad derivada
	
	public Hemisferio getHemisferio() {
		Hemisferio res;
		if (latitud > 0) {
			res = Hemisferio.NORTE;
		} else {
			res = Hemisferio.SUR;
		}
		return res;
	}
	
	// Otras operaciones
	
	public Double getDistancia(Coordenadas c) {
		Double d;
		Double diflat = latitud - c.getLatitud();
		Double diflon = longitud - c.getLongitud();
		d = Math.sqrt(diflat*diflat + diflon*diflon);
		return d;
	}
	
	// Método toString
	
	public String toString() {
		String s;
		s = "(" + this.latitud + ", " + this.longitud + ")";
		return s;
	}
	
	// Método hashCode
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
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
		Coordenadas other = (Coordenadas) obj;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		return true;
	}
	
	// Método equals 'a mano'
	/*
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Coordenadas) {
			Coordenadas c = (Coordenadas) o;
			res = latitud.equals(c.getLatitud())
					&& longitud.equals(c.getLongitud());
		}
		return res;
	}*/

	// Método compareTo
	
	public int compareTo(Coordenadas c) {
		int res = 0;
		res = getLatitud().compareTo(c.getLatitud());
		if (res == 0) {
			res = getLongitud().compareTo(c.getLongitud());
		}
		return res;
	}	
	
}
