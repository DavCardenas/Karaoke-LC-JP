package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logica.Genero;

public class AgregarAutor extends JDialog {
	
	private JLabel lbNombre;
	private JTextField txNombre;
	private JLabel lbGenero;
	private DefaultComboBoxModel modeloGeneros;
	private JComboBox<Genero> cbxGeneros;
	private JLabel lbFoto;
	private JButton btnAgregarAutor;
	private JButton btnSubirFoto;
	
	public final static String SUBIR_IMAGEN_AUTOR = "SUBIR_IMAGEN_AUTOR";
	public final static String ACEPTAR_AGREGAR_AUTOR = "ACEPTAR_AUTOR";
	
	public AgregarAutor(KaraokePrincipal karaokePrincipal, ManejadorDeEventos eventos) {
		
		setSize(500,500);
		setTitle("Agregar Autor");
		setModal(true);

		GridBagLayout gridbag;
		gridbag = new GridBagLayout();
		GridBagConstraints gbc;
		
		setIconImage(new ImageIcon(getClass().getResource("/img/AddArtist.png")).getImage());
		
		setLayout(gridbag);
		setLocationRelativeTo(karaokePrincipal);
		
		
		lbNombre = new JLabel("Nombre Artista");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbNombre, gbc);
		
		txNombre = new JTextField();
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(txNombre, gbc);
		
		lbGenero = new JLabel("Genero musical");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbGenero, gbc);
		
		modeloGeneros = new DefaultComboBoxModel();
		cbxGeneros = new JComboBox<Genero>(modeloGeneros);
		gbc = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(cbxGeneros, gbc);
		
		lbFoto = new JLabel(new ImageIcon(getClass().getResource("/Img/logo.png")));
		gbc = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbFoto, gbc);
		
		btnSubirFoto = new JButton("Subir Imagen");
		btnSubirFoto.setActionCommand(SUBIR_IMAGEN_AUTOR);
		btnSubirFoto.addActionListener(eventos);
		gbc = new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnSubirFoto, gbc);
		
		btnAgregarAutor = new JButton("Aceptar");
		btnAgregarAutor.setActionCommand(ACEPTAR_AGREGAR_AUTOR);
		btnAgregarAutor.addActionListener(eventos);
		gbc = new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(btnAgregarAutor, gbc);
		
		
	}

}
