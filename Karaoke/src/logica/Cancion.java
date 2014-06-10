package logica;

import java.util.ArrayList;

public class Cancion {
	
	private String nombre;
	private int duracion;
	private ArrayList<String> letra;
	private int numeroLineaActual;
	private String Imagen;
	
	public Cancion() {
	}

	public Cancion(String nombre, int duracion, ArrayList<String> letra,
			int numeroLineaActual, String imagen) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.letra = letra;
		this.numeroLineaActual = numeroLineaActual;
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
	
	

}
