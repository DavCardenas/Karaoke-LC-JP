
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

import logica.Cancion;
import logica.Genero;


public class PanelCancion extends JPanel{

	private JList<String> jList;
	private DefaultListModel<String > defaultListModel;
	private JScrollPane jScrollPaneS;
	private JPanel pnlContenedor;
	private Font fuenteLista;
	private ImageIcon imagenfondo;
	private ListaCancionesImagen lista;
	
	public PanelCancion() {
		
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
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)jList.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);
		jScrollPaneS.setOpaque(false);
		jScrollPaneS.getViewport().setOpaque(false);
		jScrollPaneS.setBorder(null);
		jScrollPaneS.getViewport().setBackground (new Color (0.0f,0.0f,0.0f,0.0f));
		pnlContenedor.add(jScrollPaneS,BorderLayout.CENTER);
		
		jList.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(pnlContenedor);
	}
	
	public void imagenListas(ArrayList<Cancion> canciones) {
		if (!canciones.isEmpty()) {
			lista = new ListaCancionesImagen(canciones);
			this.jList.setCellRenderer(lista);
		}
	}
	
	public void actualizarListaEliminadaCancion() {
		defaultListModel.removeAllElements();
	}
	
	public void actualizarLista(ArrayList<Cancion> listaActulizada) {
		defaultListModel.removeAllElements();
		for (Cancion cancion : listaActulizada) {
			defaultListModel.addElement(cancion.getNombre());
		}
		jList.setModel(defaultListModel);
	}
	@Override
	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagenfondo = new ImageIcon(getClass().getResource("/Img/Derecha.png"));
		g.drawImage(imagenfondo.getImage(),0,0,tamanio.width,tamanio.height, null);
		super.paint(g);
	}
	
}