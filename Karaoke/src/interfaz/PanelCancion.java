
package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logica.Genero;


public class PanelCancion extends JPanel{

	private JList<String> jList;
	private DefaultListModel<String > defaultListModel;
	private JScrollPane jScrollPaneS;
	
	public PanelCancion() {
		
		setPreferredSize(new Dimension(333, getHeight()));
		
		defaultListModel = new DefaultListModel<>();
		jList = new JList<>(defaultListModel);
		
		jScrollPaneS = new JScrollPane(jList);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)jList.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		jScrollPaneS.setOpaque(false);
		jScrollPaneS.getViewport().setOpaque(false);
		jScrollPaneS.setBorder(null);
		jScrollPaneS.getViewport().setBackground (new Color (0.0f,0.0f,0.0f,0.0f));
		add(jScrollPaneS,BorderLayout.CENTER);
	}
	
	public void actualizarLista(ArrayList<Genero> listaActulizada) {
		defaultListModel.removeAllElements();
		for (Genero seleccion : listaActulizada) {
			defaultListModel.addElement(seleccion.getNombre());
		}
		jList.setModel(defaultListModel);
	}
	
}