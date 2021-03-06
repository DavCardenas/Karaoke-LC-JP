package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class ArchivoPlano implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * Description
	 * 
	 * Esta clase se encarga de leer los archivos planos
	 *
	
	//Este metodo se utiliza para leer un archivo plano y retornar un 
	//ArrayList con la letra de la cancion seleccionada
	/*public ArrayList<String> abrirArchivo() throws IOException {
		ArrayList<String> letra = new ArrayList<>();
		JFileChooser jf = new JFileChooser();
		jf.showOpenDialog(null);
		int opcion = jf.APPROVE_OPTION;
		if (opcion == JFileChooser.APPROVE_OPTION) {
			file = new File(jf.getSelectedFile().getPath());
		}
		
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		
		String linea;
		while ((linea = bufferedReader.readLine()) != null) {
			letra.add(linea);
		}
		
		bufferedReader.close();
		
		return letra;
	}*/
		
	public static ArrayList<String> leerArchivoLetra(String ruta) {
		File archivo = new File(ruta);
		FileReader fileReader = null;
		
		ArrayList<String> letra = new ArrayList<String>();

		try {
			fileReader = new FileReader(archivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String linea = null;
		try {
			while ((linea = bufferedReader.readLine()) != null) {
				letra.add(linea);
			}
			return letra;
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void crearArchivoLetra(String letra, String ruta) {
		File archivo = new File(ruta);
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(archivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileWriter.write(letra);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
