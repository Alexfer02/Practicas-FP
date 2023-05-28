package Tipo;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import fp.utiles.Checkers;
 
public class FactoriaVinos {
	public static Vinos leerVinos2(String rutaFicheroVinos) {
		try {
			Vinos res = new Vinos();
			List<String>lineas=Files.lines(Paths.get(rutaFicheroVinos)).collect(Collectors.toList());
			for(int i=1;i<lineas.size();i++){
				System.out.println("Vino:  "+ lineas.get(i));
				res.añadirVino(parsearVino(lineas.get(i)));;
			}
			return res;
		}catch (IOException e) {
			System.out.println("No se ha encontrado el fichero"+ rutaFicheroVinos);
			e.printStackTrace();
			return null;
		}
	}
	public static Vino parsearVino(String lineaCSV) {
		String[] campos= lineaCSV.split(",");
		Checkers.check("La línea debe contener 5 campos", campos.length==5);
		String pais=campos[0].trim();
		String region= campos[1].trim();
		Integer puntos= Integer.valueOf(campos[2].trim());
		Double precio= Double.valueOf(campos[3].trim());
		String uva=campos[4].trim();
		
		
		return new Vino(pais, region, puntos, precio, uva);
	}
}
