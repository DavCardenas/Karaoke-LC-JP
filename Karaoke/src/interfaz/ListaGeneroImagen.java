package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import logica.Genero;

public class ListaGeneroImagen extends JLabel implements ListCellRenderer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hashtable<Object, ImageIcon> lista;
	private ArrayList<ImageIcon> icons;
	private ImageIcon iconoNulo;
	
	public ListaGeneroImagen(ArrayList<Genero> generos) {
		icons = new ArrayList<>();
		lista = new Hashtable<>();
		iconoNulo = new ImageIcon(getClass().getResource("/Img/genero.png"));
		
			for (Genero genero : generos) {
				if (genero != null) {
					if (genero.getImagenGenero() != null) {
						icons.add(new ImageIcon(genero.getImagenGenero().getPath()));
					}else {
						icons.add(iconoNulo);
					}
				}
			}
			int i = 0;
			for (Genero genero : generos) {
				lista.put(genero.getNombre(), icons.get(i));
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
