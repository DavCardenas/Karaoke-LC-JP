package logica;

import java.io.IOException;
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
	private String Imagen;
	private ArchivoPlano archivoPlano;
	
	
	
	public Cancion() {
		nombre = null;
		duracion = 0;
		letra = null;
		numeroLineaActual = 0;
		Imagen = null;
		archivoPlano = new ArchivoPlano();
		
	}

	public Cancion(String nombre, int duracion,String imagen) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.letra = null;
		this.numeroLineaActual = 0;
		Imagen = imagen;
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

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
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
	public void abrircancion(){
		letra = archivoPlano.leerArchivoLetra("");
	}
	
	

}
