package fp.avistamientos.test;

import java.time.LocalDate;

import fp.avistamientos.Avistamiento;
import fp.avistamientos.Forma;
import fp.coordenadas.Coordenadas;

public class TestAvistamiento {

	public static void main(String[] args) {

		Avistamiento av1 = new Avistamiento(
				LocalDate.of(2019, 1, 21), "Sevilla", 30,
				Forma.CIRCULAR, new Coordenadas(37.38, -5.97));
		Avistamiento av2 = new Avistamiento(
				LocalDate.of(2019, 1, 21), "Cádiz", 25,
				Forma.CIRCULAR, new Coordenadas(36.53, -6.29));
		System.out.println(av1);
		System.out.println("Año del avistamiento: " + av1.getAño());
		System.out.println("Distancia al avistamiento 2: " + 
				av1.getDistancia(av2));
		
		Avistamiento avs = new Avistamiento(
				"21/01/2019; Sevilla; 30; CIRCULAR; (37.38, -5.97)");
		System.out.println(avs);
	}

}
