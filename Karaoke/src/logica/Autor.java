package logica;

import java.util.ArrayList;

public class Autor {

	private String nombre;
	private ArrayList<Cancion> listaCanciones;
	private String foto;

	/**
	 * Description
	 * Esta clase sirve para la organizacion del programa en cuanto aspectos 
	 * de busqueda
	 */	
	
	public Autor(String nombre, ArrayList<Cancion> listaCanciones, String foto) {
		super();
		this.nombre = nombre;
		this.listaCanciones = listaCanciones;
		this.foto = foto;
	}

	public Autor() {
		nombre = "";
		listaCanciones = null;
		foto = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cancion> getListaCanciones() {
		return listaCanciones;
	}
	
	public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}

	

}
