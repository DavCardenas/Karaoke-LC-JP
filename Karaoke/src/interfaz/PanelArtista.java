package interfaz;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import logica.Autor;
import logica.Genero;

public class PanelArtista extends JPanel{
	
	private JList<String> jList;
	private DefaultListModel<String > defaultListModel;
	
	public PanelArtista() {
		
		setPreferredSize(new Dimension(333, getHeight()));
		
		defaultListModel = new DefaultListModel<>();
		jList = new JList<>(defaultListModel);
		
		add(jList);
	}
	
	public void actualizarLista(ArrayList<Autor> listaActulizada) {
		defaultListModel.removeAllElements();
		for (Autor autores : listaActulizada) {
			defaultListModel.addElement(autores.getNombre());
		}
		jList.setModel(defaultListModel);
	}

}
