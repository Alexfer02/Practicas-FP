package fp.tipos.musica.test;
import java.time.Duration;

import fp.tipos.musica.Cancion;
import fp.tipos.musica.Genero;

public class TestCancion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cancion c1= new Cancion("Perfect","Ed Sheeran");
		Cancion c2=new Cancion("Sevilla","Manuel Carrasco");
		Cancion c3= new Cancion("Going Backwards","Depeche Mode");
		Cancion c4= new Cancion("Perfect","Ed Sheeran");
		
		c1.setGenero(Genero.POP);
		c1.setDuracion(Duration.ofSeconds(180));
		boolean b=c1==c4;
		System.out.println("c1==c4 es "+b);
		System.out.println(c1);
		System.out.println(c2 + "\nc3 " + c3);
	}
}
