package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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

public class KaraokePrincipal extends JFrame implements Serializable{

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
	private JButton btnGuardar;
	private ManejadorDeEventos eventos;
	private PanelGeneros generos;
	private PanelArtista artista;
	private PanelCancion cancion;
	private AgregarCancion agregarCancion;
	private AgregarGenero agregarGenero;
	private AgregarAutor agregarAutor;
	private Reproduccion reproduccion;
	private JPanel contenedorListas;
	private EliminarGenero eliminarGenero;
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
	private EliminarAutor eliminarAutor;
	private EliminarCancion eliminarCancion;
	private Visualizacion visualizacion;
	
	

	public static final String COMANDO_BOTON_AGREGAR_CANCION = "AGREGAR_CANCION";
	public static final String COMANDO_BOTON_ELIMINAR_CANCION = "ELIMINAR_CANCION";
	public static final String COMANDO_BOTON_AGREGAR_AUTOR = "AGREGAR_AUTOR";
	public static final String COMANDO_BOTON_ELIMINAR_AUTOR = "ELIMINAR_AUTOR";
	public static final String COMANDO_BOTON_AGREGAR_GENERO = "AGREGAR_GENERO";
	public static final String COMANDO_BOTON_ELIMINAR_GENERO = "ELIMINAR_GENERO";
	public static final String COMANDO_BOTON_PLAY = "PLAY";
	public static final String COMANDO_ABOUT = "ABOUT";
	public static final String COMANDO_SALIR = "SALIR";
	public static final String COMANDO_GUARDAR = "GUARDAR";

	public KaraokePrincipal() {

		setTitle("Karaoke LC-JP");
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Img/nota.png")).getImage());


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
		

		eliminarGenero = new EliminarGenero(this, eventos);
		
		agregarGenero = new AgregarGenero(this, eventos);
		agregarAutor = new AgregarAutor(this, eventos, agregarGenero.getGeneros());
		agregarCancion = new AgregarCancion(this, eventos, agregarGenero.getGeneros(), lKaraoke);
		reproduccion = new Reproduccion(this, eventos, agregarGenero.getGeneros());
		eliminarAutor = new EliminarAutor(this, eventos, agregarGenero.getGeneros());
		eliminarCancion = new EliminarCancion(this, eventos, agregarGenero.getGeneros());

		
		contenedorListas = new JPanel();
		contenedorListas.setLayout(new GridLayout(1,3));
		
		
		cancion = new PanelCancion();
		about = new JDialogAbout(eventos, this);
		artista = new PanelArtista(agregarGenero.getGeneros(),cancion);
		generos = new PanelGeneros(agregarGenero.getGeneros(), artista);
		artista.setPanelGeneros(generos);
		
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
		
		btnGuardar = new JButton();
		btnGuardar.setIcon(new ImageIcon(getClass().getResource(
				"/Img/Guardar.png")));
		btnGuardar.setFocusable(false);
		btnGuardar.addActionListener(eventos);
		btnGuardar.setActionCommand(COMANDO_GUARDAR);
		btnGuardar.setToolTipText("Guardar");
		
		

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
		toolBar.addSeparator();
		toolBar.add(btnGuardar);

		
		setJMenuBar(menuBar);
		
		add(toolBar, BorderLayout.NORTH);
		contenedorListas.add(generos);
		contenedorListas.add(artista);
		contenedorListas.add(cancion);
		add(contenedorListas, BorderLayout.CENTER);

	}
	
	public void visualizarCancion() {
		visualizacion = new Visualizacion(this, eventos,reproduccion.getCancionActual());
	}
	
	
	public void MostrarAbout() {
		about.setVisible(true);
		
	}
	public void visualizar(){
		visualizacion.setVisible(true);
	}
	public void mostrarEliminarGenero() {
		eliminarGenero.actualizarComboBoxGeneros(agregarGenero.getGeneros());
		eliminarGenero.setVisible(true);
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

	public void setReproduccion(Reproduccion reproduccion) {
		this.reproduccion = reproduccion;
	}
	
	public Reproduccion getReproduccion() {
		return reproduccion;
	}
	
	public EliminarGenero getEliminarGenero() {
		return eliminarGenero;
	}

	public void setEliminarGenero(EliminarGenero eliminarGenero) {
		this.eliminarGenero = eliminarGenero;
	}

	public void setAgregarGenero(AgregarGenero agregarGenero) {
		this.agregarGenero = agregarGenero;
	}

	public AgregarAutor getAgregarAutor() {
		return agregarAutor;
	}

	public Visualizacion getVisualizacion() {
		return visualizacion;
	}
	
	public void setGeneros(PanelGeneros generos) {
		this.generos = generos;
	}
	
	public PanelGeneros getGeneros() {
		return generos;
	}

	public void setVisualizacion(Visualizacion visualizacion) {
		this.visualizacion = visualizacion;
	}

	public void setAgregarAutor(AgregarAutor agregarAutor) {
		this.agregarAutor = agregarAutor;
	}

	public void setEliminarAutor(EliminarAutor eliminarAutor) {
		this.eliminarAutor = eliminarAutor;
	}
	
	public EliminarAutor getEliminarAutor() {
		return eliminarAutor;
	}
		
	public EliminarCancion getEliminarCancion() {
		return eliminarCancion;
	}
	
	public void setArtista(PanelArtista artista) {
		this.artista = artista;
	}
	
	public PanelArtista getArtista() {
		return artista;
	}

	public void setEliminarCancion(EliminarCancion eliminarCancion) {
		this.eliminarCancion = eliminarCancion;
	}
	
	public void setCancion(PanelCancion cancion) {
		this.cancion = cancion;
	}
	
	public PanelCancion getCancion() {
		return cancion;
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
	public void mostrarReproduccion(){
		reproduccion.setVisible(true);
	}
	
	public void reproducir() {
		if (!agregarGenero.getGeneros().isEmpty()) {
			if (!agregarGenero.getGeneros().get(0).getListaAutores().isEmpty()) {
				reproduccion.actualizarComboBoxGeneros(agregarGenero.getGeneros());
				reproduccion.actualizarComboBoxartistas(agregarGenero.getGeneros().get(0).getListaAutores());
			}else {
				JOptionPane.showMessageDialog(this, "Agregue un genero y un autor como minimo");
			}
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
	
	public void eliminarAutor() {
		if (!agregarGenero.getGeneros().isEmpty()) {
			eliminarAutor.actualizarComboBoxGeneros(agregarGenero.getGeneros());
			eliminarAutor.actualizarComboBoxartistas(agregarGenero.getGeneros().get(0).getListaAutores());
			eliminarAutor.setVisible(true);
		}
	}
	public void eliminarCancion() {
		if (!agregarGenero.getGeneros().isEmpty()) {
			eliminarCancion.actualizarComboBoxGeneros(agregarGenero.getGeneros());
			eliminarCancion.actualizarComboBoxartistas(agregarGenero.getGeneros().get(0).getListaAutores());
			eliminarCancion.actualizarComboBoxCanciones(agregarGenero.getGeneros().get(0).getListaAutores().get(0).getListaCanciones());
			eliminarCancion.setVisible(true);
		}
	}
	
	public void  actualizarListasArtistas() {
		if (!agregarGenero.getGeneros().isEmpty()) {
			artista.actualizarLista(agregarGenero.getGeneros().get(0).getListaAutores());
		}else {
			artista.actualizarListaEliminada();
		}
		
	}
	
	public void actualizarListasCanciones(){
		if (!agregarGenero.getGeneros().isEmpty()) {
			cancion.actualizarLista(agregarGenero.getGeneros().get(0).getListaAutores().get(0).getListaCanciones());
		}
		else{
			cancion.actualizarListaEliminadaCancion();
		}
	}

	public void actualizarListaGeneros() {
		generos.actualizarLista(agregarGenero.getGeneros());
		
		
	}
	
}
