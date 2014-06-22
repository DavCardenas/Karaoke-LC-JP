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


public class PanelGeneros extends JPanel implements ListSelectionListener{

	private JList<String> jList;
	private DefaultListModel<String > defaultListModel;
	private JScrollPane jScrollPaneS;
	private ArrayList<Genero> generos;
	private PanelArtista panelArtista;
	
	
	public PanelGeneros(ArrayList<Genero> generos, PanelArtista panelArtista) {
		
		setPreferredSize(new Dimension(333, getHeight()));
		setLayout(new BorderLayout());
		
		defaultListModel = new DefaultListModel<>();
		jList = new JList<>(defaultListModel);
		jScrollPaneS = new JScrollPane(jList);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)
		jList.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		jScrollPaneS.setOpaque(false);
		jScrollPaneS.getViewport().setOpaque(false);
		jScrollPaneS.setBorder(null);
		jScrollPaneS.getViewport().setBackground (new Color (0.0f,0.0f,0.0f,0.0f));
		add(jScrollPaneS,BorderLayout.CENTER);
		
		jList.addListSelectionListener(this);
		
		this.generos = generos;
		this.panelArtista = panelArtista;
		
	}
	
	public void actualizarLista(ArrayList<Genero> listaActulizada) {
		defaultListModel.removeAllElements();
		for (Genero genero : listaActulizada) {
			defaultListModel.addElement(genero.getNombre());
		}
		jList.setModel(defaultListModel);
	}

	public ArrayList<Autor> actualizarArtistas(ArrayList<Autor> ListaArtistas) {
		return ListaArtistas;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == jList) {
			panelArtista.actualizarLista(generos.get(jList.getSelectedIndex()).getListaAutores());
		}
	}
	
}
