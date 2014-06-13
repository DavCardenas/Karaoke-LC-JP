package interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;



import logica.Genero;
import logica.Karaoke;
public class KaraokePrincipal extends JFrame{

	private PanelGeneros generos;
	private Karaoke lKaraoke;
	private JToolBar toolBar;
	private JButton btnAgregarCancion;
	private JButton btnEliminarCancion;
	private JButton btnAgregarGenero;
	private JButton btnEliminarGenero;
	private JButton btnAgregarAutor;
	private JButton btnEliminarAutor;
	private ManejadorDeEventos eventos;
	
	public static final String COMANDO_BOTON_AGREGAR_CANCION = "AGREGAR_CANCION";
	public static final String COMANDO_BOTON_ELIMINAR_CANCION = "ELIMINAR_CANCION";
	public static final String COMANDO_BOTON_AGREGAR_AUTOR = "AGREGAR_AUTOR";
	public static final String COMANDO_BOTON_ELIMINAR_AUTOR = "ELIMINAR_AUTOR";
	public static final String COMANDO_BOTON_AGREGAR_GENERO = "AGREGAR_GENERO";
	public static final String COMANDO_BOTON_ELIMINAR_GENERO = "ELIMINAR_GENERO";
	public KaraokePrincipal() {

		
		
		setTitle("Karaoke LC-JP");
		setSize(1000,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		eventos = new ManejadorDeEventos();
		lKaraoke = new Karaoke();
		//PANEL GENERO
		generos = new PanelGeneros();
		
		
		
		
		
		//T O L B A R 
		toolBar = new JToolBar(("Menu de registro"));
		toolBar.setOrientation(JToolBar.HORIZONTAL);


		//Botones tolbarr

		btnAgregarCancion = new JButton();
		btnAgregarCancion.setIcon(new ImageIcon(getClass().getResource("/Img/AddSong.png")));
		btnAgregarCancion.setFocusable(false);
		btnAgregarCancion.addActionListener(eventos);
		btnAgregarCancion.setActionCommand(COMANDO_BOTON_AGREGAR_CANCION);
		btnAgregarCancion.setToolTipText("Agregar Cancion");

		btnEliminarCancion = new JButton();
		btnEliminarCancion.setIcon(new ImageIcon(getClass().getResource("/Img/DeleteSong.png")));
		btnEliminarCancion.setFocusable(false);
		btnEliminarCancion.addActionListener(eventos);
		btnEliminarCancion.setActionCommand(COMANDO_BOTON_ELIMINAR_CANCION);
		btnEliminarCancion.setToolTipText("Eliminar cancion");

		btnAgregarGenero = new JButton();
		btnAgregarGenero.setIcon(new ImageIcon(getClass().getResource("/Img/AddGenero.png")));
		btnAgregarGenero.setFocusable(false);
		btnAgregarGenero.addActionListener(eventos);
		btnAgregarGenero.setActionCommand(COMANDO_BOTON_AGREGAR_AUTOR);
		btnAgregarGenero.setToolTipText("Agregar Genero");

		btnEliminarGenero = new JButton();
		btnEliminarGenero.setIcon(new ImageIcon(getClass().getResource("/Img/DeleteGenero.png")));
		btnEliminarGenero.setFocusable(false);
		btnEliminarGenero.addActionListener(eventos);
		btnEliminarGenero.setActionCommand(COMANDO_BOTON_ELIMINAR_AUTOR);
		btnEliminarGenero.setToolTipText("Eliminar Genero");

		btnAgregarAutor = new JButton();
		btnAgregarAutor.setIcon(new ImageIcon(getClass().getResource("/Img/AddArtist.png")));
		btnAgregarAutor.setFocusable(false);
		btnAgregarAutor.addActionListener(eventos);
		btnAgregarAutor.setActionCommand(COMANDO_BOTON_AGREGAR_GENERO);
		btnAgregarAutor.setToolTipText("Agregar Autor");
		
		btnEliminarAutor = new JButton();
		btnEliminarAutor.setIcon(new ImageIcon(getClass().getResource("/Img/DeleteArtist.png")));
		btnEliminarAutor.setFocusable(false);
		btnEliminarAutor.addActionListener(eventos);
		btnEliminarAutor.setActionCommand(COMANDO_BOTON_ELIMINAR_GENERO);
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
		add(toolBar,BorderLayout.NORTH);
	}

	public void actulizarListas() {
		generos.actualizarLista(lKaraoke.getListaGeneros());
	}

}
