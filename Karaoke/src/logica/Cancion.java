package logica;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import persistencia.ArchivoPlano;

public class Cancion {
	
	/**
	 *Description
	 *
	 * Esta clase permite traer el archivo cargado y mostrar su letra.
	 */
	
	private String nombre;
	private int duracion;
	private ArrayList<String> letra;
	private int numeroLineaActual;
	private URL Imagen;
	private ArchivoPlano archivoPlano;
	
	
	
	public Cancion() {
		nombre = null;
		duracion = 0;
		letra = null;
		numeroLineaActual = 0;
		Imagen = null;
		archivoPlano = new ArchivoPlano();
		
	}

	public Cancion(String nombre, int duracion,URL imagen) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.letra = null;
		this.numeroLineaActual = 0;
		Imagen = imagen;
		archivoPlano = new ArchivoPlano();
	}




	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public ArrayList<String> getLetra() {
		return letra;
	}

	public void setLetra(ArrayList<String> letra) {
		this.letra = letra;
	}

	public int getNumeroLineaActual() {
		return numeroLineaActual;
	}

	public void setNumeroLineaActual(int numeroLineaActual) {
		this.numeroLineaActual = numeroLineaActual;
	}

	public URL getImagen() {
		return Imagen;
	}

	public void setImagen(URL imagen) {
		Imagen = imagen;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**s
	 * Metodo que permite mostrar la letra de la cancion
	 * @return cada linea de la letra.
	 */
	public String mostrarLetra() {
		String linea = letra.get(numeroLineaActual);
		numeroLineaActual+=1;
		if (numeroLineaActual == letra.size()) {
			letra = null;
		}
	 return linea;
	 	
	}
	/**
	 * El metodo nos trae el archivo plano cargado en la persistencia, y lo almacenamos en el arrayList
	 */
	public void abrircancion(String ruta){
		letra = archivoPlano.leerArchivoLetra(ruta);
	}
	
	public void crearCancion(String pletra, String pruta) {
		archivoPlano.crearArchivoLetra(pletra, pruta);
	}
	

}
