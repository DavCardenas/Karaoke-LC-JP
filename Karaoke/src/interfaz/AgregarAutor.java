package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
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

import logica.Autor;
import logica.Genero;

public class AgregarAutor extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbNombre;
	private JTextField txNombre;
	private JLabel lbGenero;
	private DefaultComboBoxModel modeloGeneros;
	private JComboBox<Genero> cbxGeneros;
	private JLabel lbFoto;
	private JButton btnAgregarAutor;
	private JButton btnSubirFoto;
	private URL imagenUrl;
	private ArrayList<Genero> generos;
	private Autor autor;
	private int generoSeleccionado;

	public final static String SUBIR_IMAGEN_AUTOR = "SUBIR_IMAGEN_AUTOR";
	public final static String ACEPTAR_AGREGAR_AUTOR = "ACEPTAR_AUTOR";

	public AgregarAutor(KaraokePrincipal karaokePrincipal, ManejadorDeEventos eventos,ArrayList<Genero> ListaGeneros) {

		setSize(500,500);
		setTitle("Agregar Autor");
		setModal(true);
		setResizable(false);

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

		generos = ListaGeneros;
	}
	
	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}
	
	public ArrayList<Genero> getGeneros() {
		return generos;
	}

	public boolean camposVacios() {
		boolean vacios = false;
		if (txNombre.getText().isEmpty()) {
			vacios = true;
		}
		return vacios;
	}
	public boolean buscarRepetido(ArrayList<Autor> autores) {
		boolean repetido = false;
		for (Autor autor : autores) {
			if (txNombre.getText().equals(autor.getNombre())) {
				repetido = true;
			}
		}
		return repetido;
	}

	public void setGeneroSeleccionado(int generoSeleccionado) {
		this.generoSeleccionado = generoSeleccionado;
	}
	
	public int getGeneroSeleccionado() {
		return generoSeleccionado;
	}
	
	public void agregarAutor() {
		if (!generos.isEmpty()) {
			if (!camposVacios()) {
				if (!buscarRepetido(generos.get(cbxGeneros.getSelectedIndex()).getListaAutores())) {
					autor = new Autor(txNombre.getText(), imagenUrl);
					generoSeleccionado = cbxGeneros.getSelectedIndex();
					generos.get(cbxGeneros.getSelectedIndex()).getListaAutores().add(autor);
				}else {
					JOptionPane.showMessageDialog(null, "El artista se encuentra registrado");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Ingresa los datos");
			}
		}
	}
	public void actualizarImagen(String imagen) {
		try
		{
			remove( lbFoto );
			lbFoto = new JLabel( new ImageIcon( cargarImagen( imagen ) ) );
			GridBagConstraints gbc = new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
			add( lbFoto, gbc );
			//refresca el Jlabel con el UpdateUI();
			lbFoto.updateUI();
		}
		catch( IOException e )
		{
			JOptionPane.showMessageDialog( this, "La imagen no se pudo cargar: " + e.getMessage( ) );
			e.printStackTrace( );
		}
	}

	private byte[] cargarImagen( String imagen ) throws IOException
	{

		ByteArrayOutputStream baos = new ByteArrayOutputStream( );
		FileInputStream fin = new FileInputStream( imagen );
		int data = 0;
		while( data != -1 )
		{
			data = fin.read( );
			baos.write( data );
		}

		return baos.toByteArray( );
	}

	public void seleccionarArchivo() {
		JFileChooser jf = new JFileChooser("./src/Img/");
		int opcion = jf.showOpenDialog(null);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			String url = jf.getSelectedFile().getPath();
			try {
				imagenUrl = new URL("File:///"+url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			this.actualizarImagen(url);		
		}else if (opcion ==  JFileChooser.CANCEL_OPTION) {
			imagenUrl = null;
		}
	}
	public void actualizarComboBoxGeneros(ArrayList<Genero> ListaGeneros) {
		modeloGeneros.removeAllElements();
		for (Genero genero: ListaGeneros) {
			modeloGeneros.addElement(genero.getNombre());
		}
	}
	public void vaciarCamposAutor() {
		txNombre.setText("");
		cbxGeneros.setSelectedIndex(0);
				
	}
}
