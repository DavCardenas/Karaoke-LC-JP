package interfaz;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;


import logica.Genero;

public class EliminarGenero extends JDialog{

	private JLabel lbGenero;
	private DefaultComboBoxModel modeloGeneros;
	private JComboBox<Genero> cbxGeneros;
	private JButton buttonAceptar;
	private ArrayList<Genero> generos;
	private Genero genero;
	
	
	
	public final static String ELIMINAR_GENERO = "ELIMINARG";
	
	
	public EliminarGenero(KaraokePrincipal karaoke, ManejadorDeEventos deEventos) {
		
		setSize(500,300);
		setTitle("Agregar Genero");
		setLocationRelativeTo(karaoke);
		setModal(true);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/img/AddGenero.png")).getImage());		
		
		GridBagLayout gridBag;
		gridBag = new GridBagLayout();
		GridBagConstraints gbc;
		
		setLayout(gridBag);
		
		lbGenero = new JLabel("Genero musical");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbGenero, gbc);

		modeloGeneros = new DefaultComboBoxModel();
		cbxGeneros = new JComboBox<Genero>(modeloGeneros);
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(cbxGeneros, gbc);
		
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setActionCommand(ELIMINAR_GENERO);
		buttonAceptar.addActionListener(deEventos);
		gbc = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(buttonAceptar, gbc);
		
		generos = new ArrayList<>();
	}
	
	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}
	
	public ArrayList<Genero> getGeneros() {
		return generos;
	}
	
	public void actualizarComboBoxGeneros(ArrayList<Genero> ListaGeneros) {
		modeloGeneros.removeAllElements();
		for (Genero genero: ListaGeneros) {
			modeloGeneros.addElement(genero.getNombre());
		}
	}
	
	public void eliminarGenero(ArrayList<Genero> lista) {
		if (!lista.isEmpty()) {
			lista.remove(cbxGeneros.getSelectedIndex());
			
		}
	}	
}
