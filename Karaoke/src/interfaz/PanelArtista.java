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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logica.Autor;
import logica.Genero;

public class PanelArtista extends JPanel implements ListSelectionListener{
	
	private JList<String> jList;
	private DefaultListModel<String > defaultListModel;
	private JScrollPane jScrollPaneS;
	private ArrayList<Genero> generos;
	private PanelCancion panelCancion;
	private PanelGeneros panelGeneros;
	
	
	public PanelArtista(ArrayList<Genero> generos, PanelCancion panelCancion) {
		
		setPreferredSize(new Dimension(333, getHeight()));
		setLayout(new BorderLayout());
		
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
		
		this.panelCancion = panelCancion;
		this.generos = generos;
		
		jList.addListSelectionListener(this);
		
	}

	public PanelGeneros getPanelGeneros() {
		return panelGeneros;
	}

	public void setPanelGeneros(PanelGeneros panelGeneros) {
		this.panelGeneros = panelGeneros;
	}


	public void actualizarListaEliminada() {
		defaultListModel.removeAllElements();
	}
	
	public void actualizarLista(ArrayList<Autor> listaActulizada) {
		defaultListModel.removeAllElements();
		for (Autor autores : listaActulizada) {
			defaultListModel.addElement(autores.getNombre());
		}
		jList.setModel(defaultListModel);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == jList) {
			if (jList.getSelectedIndex() >= 0) {
				panelCancion.actualizarLista(generos.get(panelGeneros.getIndiceGenero()).getListaAutores().get(jList.getSelectedIndex()).getListaCanciones());
			}
		}
	}

}
