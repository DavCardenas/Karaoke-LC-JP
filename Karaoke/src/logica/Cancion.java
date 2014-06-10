package logica;

import java.util.ArrayList;

public class Cancion {
	
	private String nombre;
	private int duración;
	private ArrayList<String> letra;
	private int numeroLineaActual;
	private String Imagen;
	
	public Cancion() {
	}

	public Cancion(String nombre, int duración, ArrayList<String> letra,
			int numeroLineaActual, String imagen) {
		super();
		this.nombre = nombre;
		this.duración = duración;
		this.letra = letra;
		this.numeroLineaActual = numeroLineaActual;
		Imagen = imagen;
	}




	public int getDuración() {
		return duración;
	}

	public void setDuración(int duración) {
		this.duración = duración;
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
