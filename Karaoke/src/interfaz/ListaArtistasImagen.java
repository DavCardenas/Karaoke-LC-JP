package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import logica.Autor;
import logica.Genero;

public class ListaArtistasImagen extends JLabel implements ListCellRenderer{
	
	private Hashtable<Object, ImageIcon> lista;
	private ArrayList<ImageIcon> icons;
	private ImageIcon iconoNulo;
	
	public ListaArtistasImagen(ArrayList<Autor> autores) {
		icons = new ArrayList<>();
		lista = new Hashtable<>();
		iconoNulo = new ImageIcon(getClass().getResource("/Img/AddArtist.png"));
		
			for (Autor autor : autores) {
				if (autor != null) {
					if (autor.getFoto() != null) {
						icons.add(new ImageIcon(autor.getFoto().getPath()));
					}else {
						icons.add(iconoNulo);
					}
				}
			}
			int i = 0;
			for (Autor autor : autores) {
				lista.put(autor.getNombre(), icons.get(i));
				i++;
			}
			
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			setHorizontalAlignment(JLabel.CENTER);
			Font fuenteLista = new Font("Swis721 BlkEx BT", Font.PLAIN, 15);
			setForeground(Color.WHITE);
			setFont(fuenteLista);
		
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
