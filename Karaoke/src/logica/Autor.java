package logica;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class Autor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Cancion> listaCanciones;
	private URL foto;

	/**
	 * Description
	 * Esta clase sirve para la organizacion del programa en cuanto aspectos 
	 * de busqueda
	 */	
	
	public Autor(String nombre, URL foto) {
		super();
		this.nombre = nombre;
		this.foto = foto;
		listaCanciones = new ArrayList<>();
	}

	public Autor() {
		nombre = "";
		listaCanciones = null;
		foto = null;
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
	
	public URL getFoto() {
		return foto;
	}
	
	public void setFoto(URL foto) {
		this.foto = foto;
	}

	

}
