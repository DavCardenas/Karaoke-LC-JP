package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import logica.Autor;
import logica.Cancion;
import logica.Genero;

public class Reproduccion extends JDialog implements ItemListener{

	private JLabel lbGenero;
	private JLabel lbArtista;
	private JLabel lbCancion;
	private DefaultComboBoxModel<String> modeloGenero;
	private DefaultComboBoxModel<String> modeloArtista;
	private DefaultComboBoxModel<String> modeloCancion;
	private JComboBox<String> cbxGeneros;
	private JComboBox<String> cbxArtistas;
	private JComboBox<String> cbxCanciones;
	private ArrayList<Genero> generos;
	private JButton reproducir;
	
	public final static String BTN_REPRODUCIR = "REPRODUCIR";
	
	public Reproduccion(KaraokePrincipal karaoke, ManejadorDeEventos manejador, ArrayList<Genero> genero) {
		
		setTitle("Reproducir");
		setSize(600, 400);
		setModal(true);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/img/play.png")).getImage());
		setLocationRelativeTo(karaoke);
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc;
		setLayout(gridbag);
		
		lbGenero = new JLabel("Generos");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbGenero, gbc);
		
		modeloGenero = new DefaultComboBoxModel<>();
		cbxGeneros = new JComboBox<>(modeloGenero);
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 100, 0);
		add(cbxGeneros, gbc);
		
		lbArtista = new JLabel("Artistas");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbArtista, gbc);
		
		modeloArtista = new DefaultComboBoxModel<>();
		cbxArtistas = new JComboBox<>(modeloArtista);
		gbc = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 100, 0);
		add(cbxArtistas, gbc);
		
		lbCancion = new JLabel("Canciones");
		gbc = new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbCancion, gbc);
		
		modeloCancion = new DefaultComboBoxModel<>();
		cbxCanciones = new JComboBox<>(modeloCancion);
		gbc = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 100, 0);
		add(cbxCanciones, gbc);
		
		reproducir = new JButton("Reproducir");
		reproducir.setActionCommand(BTN_REPRODUCIR);
		reproducir.addActionListener(manejador);
		gbc = new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(reproducir, gbc);
		
		cbxGeneros.addItemListener(this);
		cbxArtistas.addItemListener(this);
		cbxCanciones.addItemListener(this);
	}
	
	public void actualizarComboBoxartistas(ArrayList<Autor> listaArtistas) {
		modeloArtista.removeAllElements();
		for (Autor autores: listaArtistas) {
			modeloArtista.addElement(autores.getNombre());
		}
	}
	
	public void actualizarComboBoxGeneros(ArrayList<Genero> ListaGeneros) {
		modeloGenero.removeAllElements();
		for (Genero genero: ListaGeneros) {
			modeloGenero.addElement(genero.getNombre());
		}
	}
	
	public void actualizarComboBoxCanciones(ArrayList<Cancion> ListaCanciones) {
		modeloCancion.removeAllElements();
		for (Cancion cancion: ListaCanciones) {
			modeloCancion.addElement(cancion.getNombre());
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int idG = cbxGeneros.getSelectedIndex();
		if (e.getSource() == cbxGeneros) {
			int idGG = cbxGeneros.getSelectedIndex();
			actualizarComboBoxartistas(generos.get(idGG).getListaAutores());
		}else if (e.getSource() ==  cbxArtistas) {
			int id = cbxArtistas.getSelectedIndex();
			actualizarComboBoxCanciones(generos.get(idG).getListaAutores().get(id).getListaCanciones());
		}
	}
	
	
}
