package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
	private int indiceGenero;
	private ListaGeneroImagen lista;
	private JPanel pnlContenedor;
	private Font fuenteLista;
	private ImageIcon imagenfondo;
	
	public PanelGeneros(ArrayList<Genero> generos, PanelArtista panelArtista) {
		
		setPreferredSize(new Dimension(333, getHeight()));
		setLayout(new GridLayout());
		setBackground(new Color (0.0f,0.0f,0.0f,0.3f));
		setOpaque(false);
		
		fuenteLista = new Font("Swis721 BlkEx BT", Font.PLAIN, 15);
		
		pnlContenedor = new JPanel();
		pnlContenedor.setLayout(new BorderLayout());
		pnlContenedor.setBackground(Color.WHITE);
		pnlContenedor.setOpaque(false);
		
		defaultListModel = new DefaultListModel<>();
		jList = new JList<>(defaultListModel);
		jList.setFont(fuenteLista);
		jList.setForeground(Color.WHITE);
		jList.setOpaque(false);
		jList.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		jScrollPaneS = new JScrollPane(jList);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)
		jList.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		jScrollPaneS.setOpaque(false);
		jScrollPaneS.getViewport().setOpaque(false);
		jScrollPaneS.setBorder(null);
		jScrollPaneS.getViewport().setBackground (new Color (0.0f,0.0f,0.0f,0.0f));
		pnlContenedor.add(jScrollPaneS,BorderLayout.CENTER);
		
		add(pnlContenedor);
		jList.addListSelectionListener(this);
		
		this.generos = generos;
		this.panelArtista = panelArtista;
		
		jList.setCursor(new Cursor(Cursor.HAND_CURSOR));		
	}
	
	public void imagenListas(ArrayList<Genero> generos) {
		if (!generos.isEmpty()) {
			lista = new ListaGeneroImagen(generos);
			this.jList.setCellRenderer(lista);
		}
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
			if (jList.getSelectedIndex() >= 0) {
				panelArtista.actualizarLista(generos.get(jList.getSelectedIndex()).getListaAutores());
				indiceGenero = jList.getSelectedIndex();
			}else {
				indiceGenero = 0;
			}
		}
	}
	
	public void setIndiceGenero(int indiceGenero) {
		this.indiceGenero = indiceGenero;
	}
	
	public int getIndiceGenero() {
		return indiceGenero;
	}
	@Override
	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagenfondo = new ImageIcon(getClass().getResource("/Img/Izquierda.png"));
		g.drawImage(imagenfondo.getImage(),0,0,tamanio.width,tamanio.height, null);
		super.paint(g);
	}
	
}
