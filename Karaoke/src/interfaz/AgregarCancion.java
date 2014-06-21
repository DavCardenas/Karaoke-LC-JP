package interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import logica.Autor;
import logica.Cancion;
import logica.Genero;
import logica.Karaoke;

public class AgregarCancion extends JDialog implements ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelDatos;
	private JLabel LbNombreCancion;
	private JLabel LbDuracion;
	private JButton cargarImagen;
	private JTextField txtNombreCancion;
	private JTextField txtDuracion;
	private JButton buttonAceptar;
	private JTextArea area;
	private JLabel lbGenero;
	private DefaultComboBoxModel<String> modeloGeneros;
	private JComboBox<String> cbxGeneros;
	private JLabel lbAutores;
	private DefaultComboBoxModel<String> modeloAutores;
	private JComboBox<String> cbxAutores;
	private JLabel foto;
	private ArrayList<Genero> generos;
	private ArrayList<Cancion>canciones;
	private Karaoke lKaraoke;
	private Cancion cancionC;
	private URL imagenUrl;
	
	
	
	public final static String ACEPTAR_CANCION = "ACEPTAR_CANCION";
	public final static String SUBIR_IMAGEN = "SUBIR_IMAGEN";
	
	public AgregarCancion(KaraokePrincipal karaoke, ManejadorDeEventos deEventos, ArrayList<Genero> Lgeneros, Karaoke lKaraoke) {
		
		setSize(750,550);
		setTitle("Agregar Cancion");
		setModal(true);

		GridBagLayout gridbag;
		gridbag = new GridBagLayout();
		GridBagConstraints gbc;
		
		setIconImage(new ImageIcon(getClass().getResource("/img/AddSong.png")).getImage());
		
		setLayout(gridbag);
		setLocationRelativeTo(karaoke);
		
		LbNombreCancion = new JLabel("Nombre Canción");
		gbc = new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(LbNombreCancion, gbc);
		
		txtNombreCancion = new JTextField();
		gbc = new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(txtNombreCancion, gbc);
		
		LbDuracion = new JLabel("Duración");
		gbc = new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(LbDuracion, gbc);
		
		txtDuracion = new JTextField();
		gbc = new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(txtDuracion, gbc);
		
		area = new JTextArea(7,30);
		area.setMinimumSize(new Dimension(300, 70));
		area.setMaximumSize(new Dimension(300, 70));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		
		gbc = new GridBagConstraints(2, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(area, gbc);
		
		lbGenero = new JLabel("Genero musical");
		gbc = new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lbGenero, gbc);
		
		modeloGeneros = new DefaultComboBoxModel();
		cbxGeneros = new JComboBox<>(modeloGeneros);
		gbc = new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(cbxGeneros, gbc);
		
		lbAutores = new JLabel("Autores");
		gbc = new GridBagConstraints(3, 5, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(		lbAutores, gbc);
		
		modeloAutores = new DefaultComboBoxModel();
		cbxAutores = new JComboBox<String>(modeloAutores);
		gbc = new GridBagConstraints(3, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 150, 0);
		add(cbxAutores, gbc);
		
		foto = new JLabel(new ImageIcon(getClass().getResource("/Img/logo.png")));
		gbc = new GridBagConstraints(2, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(foto, gbc);
		
		cargarImagen = new JButton("Subir Imagen");
		cargarImagen.setActionCommand(SUBIR_IMAGEN);
		cargarImagen.addActionListener(deEventos);
		gbc = new GridBagConstraints(2, 10, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(cargarImagen, gbc);
		
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setActionCommand(ACEPTAR_CANCION);
		buttonAceptar.addActionListener(deEventos);
		gbc = new GridBagConstraints(2, 11, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(buttonAceptar, gbc);
		
		cbxGeneros.addItemListener(this);
		
		generos = Lgeneros;
		canciones = new ArrayList<>();
		this.lKaraoke = lKaraoke;
	}

	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}

	public void setCbxAutores(JComboBox<String> cbxAutores) {
		this.cbxAutores = cbxAutores;
	}
	
	public JComboBox<String> getCbxAutores() {
		return cbxAutores;
	}
	
	public JComboBox<String> getCbxGeneros() {
		return cbxGeneros;
	}
	
	public void setCbxGeneros(JComboBox<String> cbxGeneros) {
		this.cbxGeneros = cbxGeneros;
	}
	
	public JTextField getTxtNombreCancion() {
		return txtNombreCancion;
	}

	public void setTxtNombreCancion(JTextField txtNombreCancion) {
		this.txtNombreCancion = txtNombreCancion;
	}

	public JTextField getTxtDuracion() {
		return txtDuracion;
	}

	public void setTxtDuracion(JTextField txtDuracion) {
		this.txtDuracion = txtDuracion;
	}

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}
	
	public void actualizarComboBoxartistas(ArrayList<Autor> listaArtistas) {
		modeloAutores.removeAllElements();
		for (Autor autores: listaArtistas) {
			modeloAutores.addElement(autores.getNombre());
		}
	}
	
	public void actualizarComboBoxGeneros(ArrayList<Genero> ListaGeneros) {
		modeloGeneros.removeAllElements();
		for (Genero genero: ListaGeneros) {
			modeloGeneros.addElement(genero.getNombre());
		}
	}
	public boolean camposVacios() {
		boolean vacios = false;
		if (txtNombreCancion.getText().isEmpty() && txtDuracion.getText().isEmpty()) {
			vacios = true;
		}
		return vacios;
	}
	public boolean buscarRepetido() {
		boolean repetido = false;
		for (Cancion cancion : canciones) {
			if (txtNombreCancion.getText().equals(cancion.getNombre()) && txtDuracion.getText().equals(cancion.getDuracion())) {
				repetido = true;
			}
		}
		return repetido;
	}
	
	
	public void vaciarCamposCancion() {
		txtDuracion.setText("");
		txtNombreCancion.setText("");
		area.setText("");
		cbxAutores.setSelectedIndex(0);
		cbxGeneros.setSelectedIndex(0);
		
	}
	public void CrearCancion() {
		if (!camposVacios()) {
			if (!buscarRepetido()) {
				JFileChooser jf = new JFileChooser("./src/archivos/");
				int opcion = jf.showSaveDialog(this);
				if (opcion == jf.APPROVE_OPTION) {
					String ruta = jf.getSelectedFile().getPath();
					cancionC = lKaraoke.crearCancion(txtNombreCancion.getText(), Integer.parseInt(txtDuracion.getText()), imagenUrl, area.getText(), ruta);

				}
				canciones.add(cancionC);
				generos.get(cbxGeneros.getSelectedIndex()).getListaAutores().get(cbxAutores.getSelectedIndex()).getListaCanciones().add(cancionC);
			}else {
				JOptionPane.showMessageDialog(null, "El artista se encuentra registrado");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Ingresa los datos");
		}
		
	}

	public void actualizarImagen(String imagen) {
		try
		{
			remove( foto );
			foto = new JLabel( new ImageIcon( cargarImagen( imagen ) ) );
			GridBagConstraints gbc = new GridBagConstraints(2, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
			add( foto, gbc );
			//refresca el Jlabel con el UpdateUI();
			foto.updateUI();
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
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbxGeneros) {
			int id = cbxGeneros.getSelectedIndex();
			actualizarComboBoxartistas(generos.get(id).getListaAutores());
		}
	}
}
