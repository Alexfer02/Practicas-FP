package fp.avistamientos.test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import fp.avistamientos.Avistamiento;
import fp.avistamientos.Avistamientos;
import fp.avistamientos.Forma;
import fp.coordenadas.Coordenadas;

public class TestAvistamientos {

	public static void main(String[] args) {

		Avistamiento av1 = new Avistamiento(
				LocalDate.of(2019, 1, 21), "Sevilla", 30,
				Forma.CIRCULAR, new Coordenadas(37.38, -5.97));
		Avistamiento av2 = new Avistamiento(
				LocalDate.of(2019, 1, 21), "Cádiz", 25,
				Forma.CIRCULAR, new Coordenadas(36.53, -6.29));
		Avistamiento av3 = new Avistamiento(
				LocalDate.of(2019, 1, 23), "Cádiz", 19,
				Forma.TRIANGULAR, new Coordenadas(36.52, -6.27));
		
		Avistamientos av = new Avistamientos();
		av.añadirAvistamiento(av1);
		av.añadirAvistamiento(av2);
		av.añadirAvistamiento(av3);
		
		Integer num = av.getNumeroAvistamientosFecha(LocalDate.of(2019, 1, 21));
		System.out.println("Número de avistamientos del 21/1/2019: " + num);
		
		Coordenadas c = new Coordenadas(36.50, -6.30);
		Set<Avistamiento> avs = av.getAvistamientosCercanosUbicacion(c, 0.5);
		System.out.println("Avistamientos cercanos a (36.50, -6.30): " + avs);
		
		Boolean existe = av.existeAvistamientoLugarAño("Cádiz", 2019);
		System.out.println("¿Algún avistamiento en Cádiz en 2019? " + existe);
		
		Avistamiento avmax = av.getAvistamientoMayorDuracion();
		System.out.println("Avistamiento más largo: " + avmax);
		
		Map<LocalDate, Set<Avistamiento>> avXFecha = av.getAvistamientosPorFecha();
		for (LocalDate f: avXFecha.keySet()) {
			System.out.println(f + ": " + avXFecha.get(f));
		}
		
		Map<Integer, Long> avXAño = av.getNumeroAvistamientosPorAño();
		for (Integer f: avXAño.keySet()) {
			System.out.println(f + ": " + avXAño.get(f));
		}
		
	}

}
