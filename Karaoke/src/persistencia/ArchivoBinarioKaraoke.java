package persistencia;

import interfaz.KaraokePrincipal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logica.Cancion;
import logica.Karaoke;

public class ArchivoBinarioKaraoke {

	private File file;
	private ObjectInputStream inputStream;
	private ObjectOutputStream objectOutputStream;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	
	public Karaoke leer(String ruta) throws IOException, ClassNotFoundException {
		file = new File(ruta);
		fileInputStream = new FileInputStream(file);
		inputStream = new ObjectInputStream(fileInputStream);
		
		Karaoke karaoke;
		karaoke = (Karaoke)inputStream.readObject();
		inputStream.close();
		return karaoke;
	}
	
	public void escribir(Karaoke karaoke, String ruta) {
		file = new File(ruta);
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objectOutputStream =  new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objectOutputStream.writeObject(karaoke);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//clase a guardar
		try {
			objectOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
