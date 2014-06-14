
package interfaz;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import logica.Genero;


public class PanelCancion extends JPanel{

	private JList<String> jList;
	private DefaultListModel<String > defaultListModel;
	
	public PanelCancion() {
		
		setPreferredSize(new Dimension(333, getHeight()));
		
		defaultListModel = new DefaultListModel<>();
		jList = new JList<>(defaultListModel);
	}
	
	public void actualizarLista(ArrayList<Genero> listaActulizada) {
		defaultListModel.removeAllElements();
		for (Genero seleccion : listaActulizada) {
			defaultListModel.addElement(seleccion.getNombre());
		}
		jList.setModel(defaultListModel);
	}
	
}