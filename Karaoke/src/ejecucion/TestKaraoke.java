package ejecucion;


import persistencia.ArchivoBinarioKaraoke;
import interfaz.KaraokePrincipal;

public class TestKaraoke {

	public static void main(String[] args) {
		ArchivoBinarioKaraoke archivo = new ArchivoBinarioKaraoke();
		KaraokePrincipal karaoke = new KaraokePrincipal();
//		archivo.escribir(karaoke, "src/archivos/karaoke");
		karaoke.setVisible(true);
	}

}
