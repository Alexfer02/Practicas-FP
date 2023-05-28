package fp.coordenadas.test;

import fp.coordenadas.Coordenadas;

public class TestCoordenadas {

	public static void main(String[] args) {
		
		// Construir objetos de tipo Coordenadas
		System.out.println("=== Test de la creación de objetos");
		Coordenadas c1 = new Coordenadas();
		Coordenadas c2 = new Coordenadas(0., 4.);

		// Mostrar objetos
		System.out.println("El punto c1 es " + c1);
		System.out.println("El punto c2 es " + c2);

		// Modificar objetos
		System.out.println("\n=== Test de la modificación de objetos");
		c1.setLatitud(3.0);
		c2.setLongitud(5.0);
		System.out.println("El nuevo punto c1 es " + c1);
		System.out.println("El nuevo punto c2 es " + c2);

		// Obtener la distancia entre dos coordenadas
		System.out.println("\n=== Test de otros métodos");
		Double d = c1.getDistancia(c2);
		System.out.println("La distancia entre c1 y c2 es " + d);
		
		// Igualdad e identidad
		System.out.println("\n=== Test de la igualdad");
		Coordenadas c3 = new Coordenadas(0., 5.);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
		if(c2 == c3) {
			System.out.println("c2 y c3 son idénticos");
		} else {
			System.out.println("c2 y c3 no son idénticos");
		}
		if (c2.equals(c3)) {
			System.out.println("c2 y c3 son iguales");
		} else {
			System.out.println("c2 y c3 no son iguales");
		}	
		
		// Orden natural
		System.out.println("\n=== Test del orden natural");
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		
		if (c1.compareTo(c2) < 0) {
			System.out.println("c1 es anterior a c2");
		} else if (c1.compareTo(c2) > 0) {
			System.out.println("c1 es posterior a c2");
		} else {
			System.out.println("c1 está en la misma posición que c2");
		}

		// Restricciones
		System.out.println("\n=== Test de las restricciones");
		
		// A) De esta forma, el programa se interrumpe
		//Coordenadas ce1 = new CoordenadasImpl(34.0, 220.5);
		//System.out.println("ce1: " + ce1);
		//Coordenadas ce2 = new CoordenadasImpl(34.0, 120.5);
		//ce2.setLatitud(115.6);
		//System.out.println("ce2: " + ce2);
		
		// B) De esta forma, la excepción se captura y el programa continúa
		try {
			Coordenadas ce3 = new Coordenadas(34.0, 220.5);
			System.out.println("ce3: " + ce3);
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción capturada: " + e.getMessage());
		}
		System.out.println("Programa finalizado");

		// Constructor a partir de String
		System.out.println("\n=== Test del constructor a partir de String");
		Coordenadas cs = new Coordenadas("(-2.5, 3.47)");
		System.out.println("cs: " + cs);
		
	}
}

