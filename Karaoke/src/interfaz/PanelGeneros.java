package interfaz;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import logica.Genero;


public class PanelGeneros extends JPanel{

	private JList<String> jList;
	private DefaultListModel<String > defaultListModel;
	
	public PanelGeneros() {
		
		setPreferredSize(new Dimension(333, getHeight()));
		
		defaultListModel = new DefaultListModel<>();
		jList = new JList<>(defaultListModel);
		
		add(jList);
	}
	
	public void actualizarLista(ArrayList<Genero> listaActulizada) {
		defaultListModel.removeAllElements();
		for (Genero genero : listaActulizada) {
			defaultListModel.addElement(genero.getNombre());
		}
		jList.setModel(defaultListModel);
	}
	
}
