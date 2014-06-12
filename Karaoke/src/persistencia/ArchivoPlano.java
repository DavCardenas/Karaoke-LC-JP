package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class ArchivoPlano {
	
	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	/**
	 * Description
	 * 
	 * Esta clase se encarga de leer los archivos planos
	 */
	
	//Este metodo se utiliza para leer un archivo plano y retornar un 
	//ArrayList con la letra de la cancion seleccionada
	public ArrayList<String> abrirArchivo() throws IOException {
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
	}

}
