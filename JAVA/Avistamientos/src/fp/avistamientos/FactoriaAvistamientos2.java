package fp.avistamientos;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import fp.coordenadas.Coordenadas;
import fp.utiles.Checkers;

public class FactoriaAvistamientos2 {
	//pre: rutaFichero es la ruta de un fichero en formato csv con la
	//     información de los avistamientos.
	//post: se devuelve el objeto r contaniendo todos los avistamientos
	//      incluido en el fichero.
	public static Avistamientos leerFichero(String rutaFichero) {
		Avistamientos r = new Avistamientos(); 
		try {
			List<String>lineas = Files.readAllLines(Paths.get(rutaFichero));
			for(int p=1;p<lineas.size();p++){
				Avistamiento a = parsearAvistamiento(lineas.get(p));
				r.añadirAvistamiento(a);
			}
			
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFichero);
			e.printStackTrace();
		}
		return r;
	}	
	
	//Pre: lineaCSV es una línea de un fichero de texto con información sobre un
	//     avistamiento. La línea contiene 5 trozos de información separados por punto
	//     y coma: fecha del avistamiento, ciudad, duración, forma y coordenadas
	//Post: se devuelve un objeto avistamiento con dicha información.
	private static Avistamiento parsearAvistamiento(String lineaCSV) {
		String[] sp = lineaCSV.split(";");
		Checkers.check("Cadena con formato no válido", sp.length == 5);	
		
		LocalDate fecha = LocalDate.parse(sp[0].trim(),
				DateTimeFormatter.ofPattern("d/M/y"));
		String lugar = sp[1].trim();
		Integer duracion = Integer.valueOf(sp[2].trim()); 
		Forma forma = Forma.valueOf(sp[3].trim());
		Coordenadas ubicacion = new Coordenadas(sp[4].trim());
		
		return new Avistamiento(fecha, lugar, duracion, forma, ubicacion);
	}
}

