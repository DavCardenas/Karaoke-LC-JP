package logica;

import java.util.ArrayList;

public class Cancion {
	
	private String nombre;
	private int duraci�n;
	private ArrayList<String> letra;
	private int numeroLineaActual;
	private String Imagen;
	
	public Cancion() {
	}

	public Cancion(String nombre, int duraci�n, ArrayList<String> letra,
			int numeroLineaActual, String imagen) {
		super();
		this.nombre = nombre;
		this.duraci�n = duraci�n;
		this.letra = letra;
		this.numeroLineaActual = numeroLineaActual;
		Imagen = imagen;
	}




	public int getDuraci�n() {
		return duraci�n;
	}

	public void setDuraci�n(int duraci�n) {
		this.duraci�n = duraci�n;
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
	
	

}
