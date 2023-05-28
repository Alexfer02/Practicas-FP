package TestVinos;

import Tipo.FactoriaVinos;
import Tipo.Vino;
import Tipo.Vinos;
import java.util.*; 

public class TestVinos {
	private static Vino vino1 = new Vino("US", "California",96,235.0,"Cabernet_Sauvignon");
	private static Vino vino2= new Vino("Spain", "Northern Spain", 96,110.0, "Tinta de Toro");
	private static Vino vino3= new Vino("US", "California",96,90.0,"Sauvignon Blanc");
	private static Vino vino4= new Vino("US", "Oregon",96,65.0,"Pinot Noir");
	private static Vino vino5= new Vino("France", "Provence",96,66.0,"Provence red blend");
	private static Vino vino6= new Vino("Spain", "Northern Spain", 95,73.0, "Tinta de Toro");
	private static Vino vino7= new Vino("Spain", "Northern Spain", 95,65.0, "Tinta de Toro");
	private static Vino vino8= new Vino("Spain", "Northern Spain", 95,110.0, "Tinta de Toro");
	private static Vino vino9= new Vino("US", "Oregon",95,65.0,"Pinot Noir");
	private static Vino vino10= new Vino("US", "California",95,60.0,"Pinot Noir");
	
	private static Vinos vinos = new Vinos();
	public static void main(String[] args ) {
		testConstructor();
		testConstructor2();
		testCalcularNumeroVinosPais();
		testVinoMejorPuntuado();
		testCalcularVinosPorPais();
		testUvasPorRegion();
		testObtenerVinosRangoPuntos();
		testCalcularUvasPorPais();
		testCalcularCalidadPrecioPorRegionMayorDe();
	}
	private static void testConstructor() {
		System.out.println("\nTEST del construtor");
		try {
			vinos.añadirVino(vino1);
			vinos.añadirVino(vino2);
			vinos.añadirVino(vino3);
			vinos.añadirVino(vino4);
			vinos.añadirVino(vino5);
			vinos.añadirVino(vino6);
			vinos.añadirVino(vino7);
			vinos.añadirVino(vino8);
			vinos.añadirVino(vino9);
			vinos.añadirVino(vino10);
			System.out.println("     VINOS: "+ vinos + "\n");
		}catch(Exception e) {
			System.out.println("Excepción capturada:\n   "+ e);
		}
	}
	public static void testConstructor2() {
		System.out.println("\nTEST del constructor 2");
		try {
			vinos = FactoriaVinos.leerVinos2("data/wine_reviews.csv");
		}catch(Exception e){
			System.out.println("Excepción capturada:\n"+ e);
		}
	}
	private static void testCalcularNumeroVinosPais() {
		System.out.println("\nTEST de calcularNumeroVinosPais");
		try {
			System.out.println("    PAÍS:"+ "Italy");
			System.out.println("VINOS: "+ vinos.calcularNumeroVinosPais("Italy"));
		}catch(Exception e) {
			System.out.println("Excepción capturada:\n "+ e);
		}
	}
	
	private static void testVinoMejorPuntuado() {
		System.out.println("\nTEST de VinoMejorPuntuado");
		try {
			System.out.println("   VINO:"+ vinos.obtenerVinoMejorPuntuado());
		}catch(Exception e) {
			System.out.println("Excepción capturada:\n  "+ e);
		}
	}
	private static void testCalcularVinosPorPais() {
		System.out.println("\nTEST de VinosPorPaís");
		try {
			System.out.println("VINOS de: "+ vinos.calcularVinosPorPaís());
		}catch(Exception e) {
			System.out.println("Excepción capturada:\n"+ e);
		}
	}
	private static void testUvasPorRegion() {
		System.out.println("\nTEST de calcularUvasRegion");
		try {
			System.out.println("Uvas de Bourdeaux:" + vinos.calcularUvasPorRegion("Bourdeaux"));
		}catch(Exception e) {
			System.out.println("Exccepción capturada:  "+e);
		}	
	}
	private static void testObtenerVinosRangoPuntos() {
		System.out.println("\nTEST de obtenerVinosRangoPuntos");
		try {
			System.out.println("MINIMO:90, MÁXIMO:95");
			for(Vino v:vinos.obtenerVinosRangoPuntos(90, 95))
				System.out.println("VINOS: "+ v);
		}catch (Exception e){
			System.out.println("Excepcion capturada \n:"+ e);
		}
	}
	private static void testCalcularUvasPorPais() {
		System.out.println("\nTEST de CalcularUvasPorPais");
		try {
			Map<String,Set<String>>aux=vinos.calcularUvasPorPaís();
			for(String pais:aux.keySet())
				System.out.println(" PAÍS: "+ pais +" UVAS: "+ aux.get(pais));
			System.out.println();
		}catch(Exception e) {
			System.out.println("Excepcion capturada: \n"+ e);
		}
	}
	private static void testCalcularCalidadPrecioPorRegionMayorDe() {
		System.out.println("\nTEST de calcularCalidadPrecioPorRegionMayorDe");
		try {
			System.out.println("    TOTAL VINOS DE CALIDAD/PRECIO MAYOR QUE 4.5:"+ vinos.calcularCalidadPrecioPorRegionMayorDe(4.5));
		}catch(Exception e) {
			System.out.println("EXcepcion capturada:\n"+ e);
		}
	}
}
