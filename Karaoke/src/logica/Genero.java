package logica;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class Genero implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Esta clase va  a contener una lista de autores, as� como una respectiva imagen de G�nero y el alb�m.
	 */
	
private String nombre;
private ArrayList<Autor> listaAutores;
private URL imagenGenero;

	public Genero() {
		nombre = "";
		listaAutores = new ArrayList<>();
		imagenGenero = null;
	}

	public Genero(String nombre,URL imagenGenero) {
		super();
		this.nombre = nombre;
		this.imagenGenero = imagenGenero;
		listaAutores = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Autor> getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(ArrayList<Autor> listaAutores) {
		this.listaAutores = listaAutores;
	}

	public URL getImagenGenero() {
		return imagenGenero;
	}

	public void setImagenGenero(URL imagenGenero) {
		this.imagenGenero = imagenGenero;
	}
	
}
