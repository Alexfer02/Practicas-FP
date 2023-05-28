package fp.avistamientos.test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import fp.avistamientos.Avistamiento;
import fp.avistamientos.Avistamientos;
import fp.avistamientos.Avistamientos;
import fp.avistamientos.FactoriaAvistamientos2;
import fp.coordenadas.Coordenadas;

public class TestFactoriaAvistamientos2 {

	public static void main(String[] args) {

		// Leer avistamientos del fichero
		System.out.println("Ejercicio: Avistamientos");
		System.out.println("========================");
		Avistamientos av =
			FactoriaAvistamientos2.leerFichero("data/ovnis.csv");

		Integer num = av.getNumeroAvistamientosFecha(LocalDate.of(2014, 4, 23));
		System.out.println("Número de avistamientos del 23/04/2014: " + num);
		
		Coordenadas c = new Coordenadas(47.61,-122.33);
		Set<Avistamiento> avs = av.getAvistamientosCercanosUbicacion(c, 0.05);
		System.out.println("Número de avistamientos cercanos a (47.61,-122.33): "
				+ avs.size());
		
		Boolean existe = av.existeAvistamientoLugarAño("seattle", 2013);
		System.out.println("¿Algún avistamiento en Seattle en 2013? " + existe);
		
		Avistamiento avmax = av.getAvistamientoMayorDuracion();
		System.out.println("Avistamiento más largo: " + avmax);
		
		Map<LocalDate, Set<Avistamiento>> avXFecha = av.getAvistamientosPorFecha();
		muestraMapN(avXFecha, 5);
		
		Map<Integer, Long> avXAño = av.getNumeroAvistamientosPorAño();
		muestraMapN(avXAño, 5);
		
	}

	// Método genérico que muestra un Map
	public static <K, V> void muestraMap(Map<K, V> m) {
		for (K c : m.keySet()) {
			System.out.println("Clave: " + c + ". Valor: " + m.get(c));
		}
	}
	
	// Método genérico que muestra los n primeros elementos de un Map
	public static <K, V> void muestraMapN(Map<K, V> m, Integer n) {
		Integer cont = 0;
		for (K c : m.keySet()) {
			System.out.println("Clave: " + c + ". Valor: " + m.get(c));
			cont++;
			if (cont.equals(n)) {
				break;
			}
		}
	}
}
