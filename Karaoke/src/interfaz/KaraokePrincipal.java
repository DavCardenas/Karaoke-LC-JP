package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logica.Karaoke;

public class KaraokePrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Karaoke lKaraoke;
	private JToolBar toolBar;
	private JButton btnAgregarCancion;
	private JButton btnEliminarCancion;
	private JButton btnAgregarGenero;
	private JButton btnEliminarGenero;
	private JButton btnAgregarAutor;
	private JButton btnEliminarAutor;
	private JButton btnPlay;
	private ManejadorDeEventos eventos;
	private PanelGeneros generos;
	private PanelArtista artista;
	private PanelCancion cancion;
	private AgregarCancion agregarCancion;
	private AgregarGenero agregarGenero;
	private AgregarAutor agregarAutor;
	private Reproduccion reproduccion;
	private JPanel contenedorListas;
	private JMenuBar menuBar;
	private JMenu menuArchivo;
	private JMenuItem itemSalir;
	private JMenu menuRegistro;
	private JMenu subMenuCanciones;
	private JMenuItem itemAgregarCancion;
	private JMenuItem itemEliminarCancion;
	private JMenu subMenuAutores;
	private JMenuItem itemAgregarAutor;
	private JMenuItem itemEliminarAutor;
	private JMenu subMenuGeneros;
	private JMenuItem itemAgregarGenero;
	private JMenuItem itemEliminarGenero;
	private JMenu menuAyuda;
	private JMenuItem itemAbout;
	private JDialogAbout about;
	

	public static final String COMANDO_BOTON_AGREGAR_CANCION = "AGREGAR_CANCION";
	public static final String COMANDO_BOTON_ELIMINAR_CANCION = "ELIMINAR_CANCION";
	public static final String COMANDO_BOTON_AGREGAR_AUTOR = "AGREGAR_AUTOR";
	public static final String COMANDO_BOTON_ELIMINAR_AUTOR = "ELIMINAR_AUTOR";
	public static final String COMANDO_BOTON_AGREGAR_GENERO = "AGREGAR_GENERO";
	public static final String COMANDO_BOTON_ELIMINAR_GENERO = "ELIMINAR_GENERO";
	public static final String COMANDO_BOTON_PLAY = "PLAY";
	public static final String COMANDO_ABOUT = "ABOUT";
	public static final String COMANDO_SALIR = "SALIR";

	public KaraokePrincipal() {

		setTitle("Karaoke LC-JP");
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());



		UIManager.put("Label.font",	UIManager.getFont("Label.font").deriveFont((float) 16.0));
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
		contenedorListas = new JPanel();
		contenedorListas.setLayout(new GridLayout(1,3));
		generos = new PanelGeneros();
		artista = new PanelArtista();
		cancion = new PanelCancion();
		about = new JDialogAbout(eventos, this);


		agregarGenero = new AgregarGenero(this, eventos);
		agregarAutor = new AgregarAutor(this, eventos, agregarGenero.getGeneros());
		agregarCancion = new AgregarCancion(this, eventos, agregarGenero.getGeneros(), lKaraoke);
		reproduccion = new Reproduccion(this, eventos, agregarGenero.getGeneros());

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
		
		btnPlay = new JButton();
		btnPlay.setIcon(new ImageIcon(getClass().getResource(
				"/Img/play.png")));
		btnPlay.setFocusable(false);
		btnPlay.addActionListener(eventos);
		btnPlay.setActionCommand(COMANDO_BOTON_PLAY);
		btnPlay.setToolTipText("Play");
		
		

		// M E N U    B A R 
		menuBar = new JMenuBar();

		// MENU ARCHIVO
		menuArchivo = new JMenu("Archivo");

		//Salir
		itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(eventos);
		itemSalir.setActionCommand(COMANDO_SALIR);

		// MENU REGISTRO
		menuRegistro = new JMenu("Registro");

		// Equipo
		subMenuCanciones = new JMenu("Canciones");

		itemAgregarCancion = new JMenuItem("Agregar");
		itemAgregarCancion.addActionListener(eventos);
		itemAgregarCancion.setActionCommand(COMANDO_BOTON_AGREGAR_CANCION);

		itemEliminarCancion = new JMenuItem("Eliminar");
		itemEliminarCancion.addActionListener(eventos);
		itemEliminarCancion.setActionCommand(COMANDO_BOTON_ELIMINAR_CANCION);

		//Jugador
		subMenuAutores = new JMenu(("Autores"));

		itemAgregarAutor = new JMenuItem(("Agregar"));
		itemAgregarAutor.addActionListener(eventos);
		itemAgregarAutor.setActionCommand(COMANDO_BOTON_AGREGAR_AUTOR);

		itemEliminarAutor = new JMenuItem(("Eliminar"));
		itemEliminarAutor.addActionListener(eventos);
		itemEliminarAutor.setActionCommand(COMANDO_BOTON_ELIMINAR_AUTOR);

		//Generos
		subMenuGeneros = new JMenu(("Generos"));

		itemAgregarGenero = new JMenuItem(("Agregar"));
		itemAgregarGenero.addActionListener(eventos);
		itemAgregarGenero.setActionCommand(COMANDO_BOTON_AGREGAR_GENERO);

		itemEliminarGenero = new JMenuItem(("Eliminar"));
		itemEliminarGenero.addActionListener(eventos);
		itemEliminarGenero.setActionCommand(COMANDO_BOTON_ELIMINAR_GENERO);


		//MENU AYUDA
		menuAyuda = new JMenu("Ayuda");
		itemAbout = new JMenuItem("Acerca de");
		itemAbout.addActionListener(eventos);
		itemAbout.setActionCommand(COMANDO_ABOUT);

		//A�ADIR ITEMS A MENUS

		//Archivo
		menuArchivo.add(itemSalir);


		//Registro
		menuRegistro.add(subMenuCanciones);
		menuRegistro.add(subMenuAutores);
		menuRegistro.add(subMenuGeneros);
		//SubMenuCanciones
		subMenuCanciones.add(itemAgregarCancion);
		subMenuCanciones.add(itemEliminarCancion);
		//SubMenuAutores
		subMenuAutores.add(itemAgregarAutor);
		subMenuAutores.add(itemEliminarAutor);
		//SubMenuGeneros
		subMenuGeneros.add(itemAgregarGenero);
		subMenuGeneros.add(itemEliminarGenero);
		
		//Ayuda
		menuAyuda.add(itemAbout);

		

		menuBar.add(menuArchivo);
		menuBar.add(menuRegistro);
		menuBar.add(menuAyuda);
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
		toolBar.addSeparator();
		toolBar.add(btnPlay);

		
		setJMenuBar(menuBar);
		
		add(toolBar, BorderLayout.NORTH);
		contenedorListas.add(generos);
		contenedorListas.add(artista);
		contenedorListas.add(cancion);
		add(contenedorListas, BorderLayout.CENTER);

	}
	
	public void MostrarAbout() {
		about.setVisible(true);
		
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
		if (!agregarGenero.getGeneros().isEmpty()) {
			agregarCancion.actualizarComboBoxGeneros(agregarGenero.getGeneros());
			agregarCancion.actualizarComboBoxartistas(agregarGenero.getGeneros().get(0).getListaAutores());
			agregarCancion.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(this, "Agregue un genero y un autor como minimo");
		}

	}

	public void agregarGenero() {
		agregarGenero.setVisible(true);
	}

	public void agregarAutor() {
		agregarAutor.actualizarComboBoxGeneros(agregarGenero.getGeneros());
		agregarAutor.setVisible(true);
	}
	
	public void reproducir() {
		reproduccion.setVisible(true);
	}
	
	public void  actualizarListasArtistas() {
		artista.actualizarLista(agregarAutor.getAutores());
	}

	public void actualizarListaGeneros() {
		generos.actualizarLista(agregarGenero.getGeneros());
	}
	public void actualizarListaCanciones(){
		cancion.actualizarLista(agregarCancion.getCanciones());
	}


}
