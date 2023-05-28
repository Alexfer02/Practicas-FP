package Tipo;

public class Vino {
	private String país;
	private String region;
	private Integer puntos;
	private Double precio;
	private String uva;
	
	public Vino(String pais, String region, Integer puntos, Double precio, String uva) {
		this.país = pais;
		this.region=region;
		this.puntos=puntos;
		this.precio=precio;
		this.uva=uva;
	}

	public String getPaís() {
		return país;
	}
 
	public String getRegion() {
		return region;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getUva() {
		return uva;
	}

	//Propiedad derivada 
	public Double getCalidadPrecio() {
		return puntos/precio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((país == null) ? 0 : país.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((puntos == null) ? 0 : puntos.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((uva == null) ? 0 : uva.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vino other = (Vino) obj;
		if (país == null) {
			if (other.país != null)
				return false;
		} else if (!país.equals(other.país))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (uva == null) {
			if (other.uva != null)
				return false;
		} else if (!uva.equals(other.uva))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vino [país=" + país + ", region=" + region + ", puntos=" + puntos + ", precio=" + precio + ", uva="
				+ uva + "]";
	}
	
}
