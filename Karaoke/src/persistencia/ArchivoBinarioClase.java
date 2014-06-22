package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logica.Cancion;

public class ArchivoBinarioClase {

	private File file;
	private ObjectInputStream inputStream;
	private ObjectOutputStream objectOutputStream;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	
	public Cancion leer(String ruta) throws IOException, ClassNotFoundException {
		file = new File(ruta);
		fileInputStream = new FileInputStream(file);
		inputStream = new ObjectInputStream(fileInputStream);
		
		Cancion cancion;
		cancion = (Cancion)inputStream.readObject();
		inputStream.close();
		return cancion;
	}
	
	public void escribir(Cancion cancion, String ruta) {
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
			objectOutputStream.writeObject(cancion);
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
