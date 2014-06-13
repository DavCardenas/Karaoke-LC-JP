package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logica.Karaoke;

public class ArchivoBinario {
	
	private File file;
	private ObjectInputStream inputStream;
	private ObjectOutputStream objectOutputStream;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	
	public void leer(String ruta) throws IOException, ClassNotFoundException {
		file = new File(ruta);
		fileInputStream = new FileInputStream(file);
		inputStream = new ObjectInputStream(fileInputStream);
		
		Karaoke karaoke;
		karaoke = (Karaoke)inputStream.readObject();
		inputStream.close();
	}

	public static void crearArchivoCancion(Karaoke karaoke, String ruta) {
		File archivo = new File(ruta);
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
			try {
				fileOutputStream = new FileOutputStream(archivo);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			try {
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				objectOutputStream.writeObject(karaoke);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		try {
			fileOutputStream.close();
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
