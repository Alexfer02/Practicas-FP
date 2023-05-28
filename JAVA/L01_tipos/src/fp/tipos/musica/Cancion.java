package fp.tipos.musica;

import java.time.Duration;
import java.time.LocalDate;

public class Cancion {

	/*
	 * 1. Cancion
	Paquetes: fp.tipos.musica, fp.tipos.musica.test
	Propiedades:
	• titulo, de tipo String, consultable y modificable.
	• artista, de tipo String, consultable y modificable. Representa al intérprete de la canción.
	• duracion, de tipo Duration, consultable y modificable.
	• fechaLanzamiento, de tipo LocalDate, consultable y modificable.
	• genero, de tipo Genero, consultable y modificable. Puede tomar los valores: POP, ROCK, FOLK.
	 */
	
	private String titulo;
	private String artista;
	private Duration duracion;
	private LocalDate fechaLanzamiento;
	private Genero genero;
	
	/*Getter and Setters*/
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public Duration getDuracion() {
		return duracion;
	}
	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/*• formatoCorto, de tipo String, consultable. Cadena que representa una canción con el siguiente formato:
	el título de la canción, seguido del artista entre paréntesis y la duración, por ejemplo, “Whole Lotta Love
	(Led Zeppelin) 3:20”*/
	
	public String formatoCorto(){
		return this.titulo + "(" + this.artista + ")" + this.duracion;
	}
	/*Constructores:
	• C1: recibe como parámetros el título y el artista y crea una canción con duración de 0 segundos, y el resto
	de atributos nulos.
	*/
	
	public Cancion(String titulo, String artista) {
		this.titulo=titulo;
		this.artista=artista;
		this.duracion= Duration.ofSeconds(0);
		this.fechaLanzamiento= null;
		this.genero= null;
	}
	/*Representación como cadena: una cadena con el nombre de la clase y todas las propiedades del tipo
	separadas por comas.*/
	
	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", artista=" + artista + ", duracion=" + duracion + ", fechaLanzamiento="
				+ fechaLanzamiento + ", genero=" + genero + "]";
	}
}
