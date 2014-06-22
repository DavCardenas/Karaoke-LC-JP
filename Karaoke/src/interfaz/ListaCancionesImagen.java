package interfaz;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import logica.Autor;
import logica.Cancion;
import logica.Genero;

public class ListaCancionesImagen extends JLabel implements ListCellRenderer{
	
	private Hashtable<Object, ImageIcon> lista;
	private ArrayList<ImageIcon> icons;
	private ImageIcon iconoNulo;
	
	public ListaCancionesImagen(ArrayList<Cancion> canciones) {
		icons = new ArrayList<>();
		lista = new Hashtable<>();
		iconoNulo = new ImageIcon(getClass().getResource("/Img/AddSong.png"));
		
			for (Cancion cancion : canciones) {
				if (cancion != null) {
					if (cancion.getImagen() != null) {
						icons.add(new ImageIcon(cancion.getImagen().getPath()));
					}else {
						icons.add(iconoNulo);
					}
				}
			}
			int i = 0;
			for (Cancion cancion : canciones) {
				lista.put(cancion.getNombre(), icons.get(i));
				i++;
			}
		
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		if (lista.get(value) != null) {
			setIcon(lista.get(value));
			setText("" + value);
			
		}else {
			setIcon(iconoNulo);
			setText("" + value);
		}
		return this;
	}

}
