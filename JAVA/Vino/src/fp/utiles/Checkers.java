package fp.utiles;

public class Checkers {
	public static void check(String textoRestriccion, Boolean condicion) {
		
		if(!condicion) {
			throw new IllegalArgumentException(
					Thread.currentThread().getStackTrace()[2].getClassName() +
					"." +
					Thread.currentThread().getStackTrace()[2].getMethodName() +
					"." +
					textoRestriccion);
			
		
		}
	}
}
 