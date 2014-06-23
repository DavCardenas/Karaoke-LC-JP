package ejecucion;


import java.io.IOException;

import logica.Karaoke;
import persistencia.ArchivoBinarioKaraoke;
import interfaz.KaraokePrincipal;

public class TestKaraoke {

	public static void main(String[] args) {
		ArchivoBinarioKaraoke archivo = new ArchivoBinarioKaraoke();
		KaraokePrincipal karaoke = new KaraokePrincipal();
		try {
			Karaoke Lkaraoke = archivo.leer("src/archivos/karaoke");
			karaoke.getAgregarGenero().setGeneros(Lkaraoke.getListaGeneros());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		karaoke.setVisible(true);
	}

}
