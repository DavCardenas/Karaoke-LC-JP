package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logica.Genero;
import logica.Karaoke;

public class KaraokePrincipal extends JFrame {

	private Karaoke lKaraoke;
	private JToolBar toolBar;
	private JButton btnAgregarCancion;
	private JButton btnEliminarCancion;
	private JButton btnAgregarGenero;
	private JButton btnEliminarGenero;
	private JButton btnAgregarAutor;
	private JButton btnEliminarAutor;
	private ManejadorDeEventos eventos;
	private PanelGeneros generos;
	private PanelArtista artista;
	private PanelCancion cancion;
	private AgregarCancion agregarCancion;
	private AgregarGenero agregarGenero;
	private AgregarAutor agregarAutor;

	public static final String COMANDO_BOTON_AGREGAR_CANCION = "AGREGAR_CANCION";
	public static final String COMANDO_BOTON_ELIMINAR_CANCION = "ELIMINAR_CANCION";
	public static final String COMANDO_BOTON_AGREGAR_AUTOR = "AGREGAR_AUTOR";
	public static final String COMANDO_BOTON_ELIMINAR_AUTOR = "ELIMINAR_AUTOR";
	public static final String COMANDO_BOTON_AGREGAR_GENERO = "AGREGAR_GENERO";
	public static final String COMANDO_BOTON_ELIMINAR_GENERO = "ELIMINAR_GENERO";

	public KaraokePrincipal() {

		setTitle("Karaoke LC-JP");
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		

		UIManager.put("Label.font",	UIManager.getFont("Label.font").deriveFont((float) 17.0));
		SwingUtilities.updateComponentTreeUI(this);

		/*
		 * Este codigo cambia la aparencia de todos los componentes graficos del
		 * programa
		 */
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		eventos = new ManejadorDeEventos(this);
		lKaraoke = new Karaoke();
		// PANELES
		generos = new PanelGeneros();
		artista = new PanelArtista();
		cancion = new PanelCancion();

		agregarCancion = new AgregarCancion(this, eventos);
		agregarGenero = new AgregarGenero(this, eventos);
		agregarAutor = new AgregarAutor(this, eventos, agregarGenero.getGeneros());

		// T O L B A R
		toolBar = new JToolBar(("Menu de registro"));
		toolBar.setOrientation(JToolBar.HORIZONTAL);

		// Botones tolbarr

		btnAgregarCancion = new JButton();
		btnAgregarCancion.setIcon(new ImageIcon(getClass().getResource(
				"/Img/AddSong.png")));
		btnAgregarCancion.setFocusable(false);
		btnAgregarCancion.addActionListener(eventos);
		btnAgregarCancion.setActionCommand(COMANDO_BOTON_AGREGAR_CANCION);
		btnAgregarCancion.setToolTipText("Agregar Cancion");

		btnEliminarCancion = new JButton();
		btnEliminarCancion.setIcon(new ImageIcon(getClass().getResource(
				"/Img/DeleteSong.png")));
		btnEliminarCancion.setFocusable(false);
		btnEliminarCancion.addActionListener(eventos);
		btnEliminarCancion.setActionCommand(COMANDO_BOTON_ELIMINAR_CANCION);
		btnEliminarCancion.setToolTipText("Eliminar cancion");

		btnAgregarGenero = new JButton();
		btnAgregarGenero.setIcon(new ImageIcon(getClass().getResource(
				"/Img/AddGenero.png")));
		btnAgregarGenero.setFocusable(false);
		btnAgregarGenero.addActionListener(eventos);
		btnAgregarGenero.setActionCommand(COMANDO_BOTON_AGREGAR_GENERO);
		btnAgregarGenero.setToolTipText("Agregar Genero");

		btnEliminarGenero = new JButton();
		btnEliminarGenero.setIcon(new ImageIcon(getClass().getResource(
				"/Img/DeleteGenero.png")));
		btnEliminarGenero.setFocusable(false);
		btnEliminarGenero.addActionListener(eventos);
		btnEliminarGenero.setActionCommand(COMANDO_BOTON_ELIMINAR_GENERO);
		btnEliminarGenero.setToolTipText("Eliminar Genero");

		btnAgregarAutor = new JButton();
		btnAgregarAutor.setIcon(new ImageIcon(getClass().getResource(
				"/Img/AddArtist.png")));
		btnAgregarAutor.setFocusable(false);
		btnAgregarAutor.addActionListener(eventos);
		btnAgregarAutor.setActionCommand(COMANDO_BOTON_AGREGAR_AUTOR);
		btnAgregarAutor.setToolTipText("Agregar Autor");

		btnEliminarAutor = new JButton();
		btnEliminarAutor.setIcon(new ImageIcon(getClass().getResource(
				"/Img/DeleteArtist.png")));
		btnEliminarAutor.setFocusable(false);
		btnEliminarAutor.addActionListener(eventos);
		btnEliminarAutor.setActionCommand(COMANDO_BOTON_ELIMINAR_AUTOR);
		btnEliminarAutor.setToolTipText("Eliminar Autor");

		toolBar.add(btnAgregarCancion);
		toolBar.addSeparator();
		toolBar.add(btnEliminarCancion);
		toolBar.addSeparator();
		toolBar.add(btnAgregarAutor);
		toolBar.addSeparator();
		toolBar.add(btnEliminarAutor);
		toolBar.addSeparator();
		toolBar.add(btnAgregarGenero);
		toolBar.addSeparator();
		toolBar.add(btnEliminarGenero);

		add(generos, BorderLayout.WEST);
		add(artista, BorderLayout.CENTER);
		add(cancion, BorderLayout.EAST);
		add(toolBar, BorderLayout.NORTH);
	}

	public AgregarCancion getAgregarCancion() {
		return agregarCancion;
	}

	public void setAgregarCancion(AgregarCancion agregarCancion) {
		this.agregarCancion = agregarCancion;
	}

	public AgregarGenero getAgregarGenero() {
		return agregarGenero;
	}

	public void setAgregarGenero(AgregarGenero agregarGenero) {
		this.agregarGenero = agregarGenero;
	}

	public AgregarAutor getAgregarAutor() {
		return agregarAutor;
	}

	public void setAgregarAutor(AgregarAutor agregarAutor) {
		this.agregarAutor = agregarAutor;
	}

	public void agregarCancion() {
		agregarCancion.setVisible(true);
	}

	public void agregarGenero() {
		agregarGenero.setVisible(true);
	}

	public void agregarAutor() {
		agregarAutor.actualizarComboBoxGeneros(agregarGenero.getGeneros());
		agregarAutor.setVisible(true);
	}
	public void  actualizarListasArtistas() {
		artista.actualizarLista(agregarAutor.getAutores());
	}
	
	public void actualizarListaGeneros() {
		generos.actualizarLista(agregarGenero.getGeneros());
	}
	

	public void enviarDatosCancion() {
		JFileChooser jf = new JFileChooser("./src/archivos/");
		int opcion = jf.showSaveDialog(this);
		if (opcion == jf.APPROVE_OPTION) {
			String ruta = jf.getSelectedFile().getPath();
			lKaraoke.crearCancion(agregarCancion.getTxtNombreCancion().getText(),
					Integer.parseInt(agregarCancion.getTxtDuracion().getText()),
					ruta, agregarCancion.getArea().getText(), ruta);
		}
		
	}

}
