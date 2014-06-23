package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import logica.Autor;
import logica.Genero;

public class EliminarAutor extends JDialog implements ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbGenero;
	private JLabel lbArtista;
	private DefaultComboBoxModel<String> modeloGenero;
	private DefaultComboBoxModel<String> modeloArtista;
	private JComboBox<String> cbxGeneros;
	private JComboBox<String> cbxArtistas;
	private ArrayList<Genero> generos;
	private JButton eliminar;
	
	public final static String BTN_ELIMINAR_AUTOR = "ELIMINAR";
	
	public EliminarAutor(KaraokePrincipal karaoke, ManejadorDeEventos manejador, ArrayList<Genero> genero) {
		
		setTitle("Reproducir");
		setSize(600, 400);
		setModal(true);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/img/DeleteArtist.png")).getImage());
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
		
		eliminar = new JButton("Eliminar");
		eliminar.setActionCommand(BTN_ELIMINAR_AUTOR);
		eliminar.addActionListener(manejador);
		gbc = new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(eliminar, gbc);
		
		this.generos = genero;
		cbxArtistas.addItemListener(this);
		cbxGeneros.addItemListener(this);
	}
	
	public ArrayList<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}

	public void eliminarAutor() {
		generos.get(cbxGeneros.getSelectedIndex()).getListaAutores().remove(cbxArtistas.getSelectedIndex());
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
	
	public void actualizarArtistasEliminados() {
		actualizarComboBoxartistas(generos.get(cbxGeneros.getSelectedIndex()).getListaAutores());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbxGeneros) {
			int idGG = cbxGeneros.getSelectedIndex();
			if (idGG >= 0) {
				actualizarComboBoxartistas(generos.get(idGG).getListaAutores());
			}
		}
	}
}
