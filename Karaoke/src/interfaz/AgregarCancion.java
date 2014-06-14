package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AgregarCancion extends JDialog{

	private JLabel jLabelDatos;
	private JLabel LbNombreCancion;
	private JLabel LbDuracion;
	private JButton cargarImagen;
	private JTextField txtNombreCancion;
	private JTextField txtDuracion;
	private JButton buttonAceptar;
	private JTextArea area;
	private JLabel foto;
	
	public final static String ACEPTAR_CANCION = "ACEPTAR_CANCION";
	public final static String SUBIR_IMAGEN = "SUBIR_IMAGEN";
	
	public AgregarCancion(KaraokePrincipal karaoke, ManejadorDeEventos deEventos) {
		
		setSize(500,500);
		setTitle("Agregar Cancion");
		setModal(true);

		GridBagLayout gridbag;
		gridbag = new GridBagLayout();
		GridBagConstraints gbc;
		
		setIconImage(new ImageIcon(getClass().getResource("/img/AddSong.png")).getImage());
		
		setLayout(gridbag);
		setLocationRelativeTo(karaoke);
		
		LbNombreCancion = new JLabel("Nombre Canción");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(LbNombreCancion, gbc);
		
		txtNombreCancion = new JTextField();
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(txtNombreCancion, gbc);
		
		LbDuracion = new JLabel("Duración");
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(LbDuracion, gbc);
		
		txtDuracion = new JTextField();
		gbc = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(txtDuracion, gbc);
		
		area = new JTextArea();
		gbc = new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 400, 100);
		add(area, gbc);
		
		foto = new JLabel(new ImageIcon(getClass().getResource("/Img/logo.png")));
		gbc = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(foto, gbc);
		
		cargarImagen = new JButton("Subir Imagen");
		cargarImagen.setActionCommand(SUBIR_IMAGEN);
		cargarImagen.addActionListener(deEventos);
		gbc = new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cargarImagen, gbc);
		
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setActionCommand(ACEPTAR_CANCION);
		buttonAceptar.addActionListener(deEventos);
		gbc = new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(buttonAceptar, gbc);
		
	}
}
