package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import persistencia.ArchivoBinarioClase;
import logica.Autor;
import logica.Cancion;
import logica.Genero;

public class Reproduccion extends JDialog implements ItemListener{

	private JLabel lbGenero;
	private JLabel lbArtista;
	private DefaultComboBoxModel<String> modeloGenero;
	private DefaultComboBoxModel<String> modeloArtista;
	private JComboBox<String> cbxGeneros;
	private JComboBox<String> cbxArtistas;
	private ArrayList<Genero> generos;
	private JButton reproducir;
	private Cancion cancionActual;
	private ArchivoBinarioClase archivoBinarioClase;
	
	public final static String BTN_ABRIR = "ABRIR_ARCHIVO";
	
	public Reproduccion(KaraokePrincipal karaoke, ManejadorDeEventos manejador, ArrayList<Genero> genero) {
		
		setTitle("Reproducir");
		setSize(400, 400);
		setModal(true);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/img/play.png")).getImage());
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
		
		reproducir = new JButton("Abrir");
		reproducir.setActionCommand(BTN_ABRIR);
		reproducir.addActionListener(manejador);
		gbc = new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(reproducir, gbc);
		
		cbxGeneros.addItemListener(this);
		cbxArtistas.addItemListener(this);
				
		this.generos = genero;
		archivoBinarioClase = new ArchivoBinarioClase();
	}
	
	public Cancion getCancionActual() {
		return cancionActual;
	}

	public void setCancionActual(Cancion cancionActual) {
		this.cancionActual = cancionActual;
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
	
	
	
	public void abrirArchivo() {
		JFileChooser jf = new JFileChooser("src/archivos/"+ (String)cbxGeneros.getSelectedItem() + "/" + (String)cbxArtistas.getSelectedItem());
		int opcion = jf.showOpenDialog(null);
		if (opcion == jf.APPROVE_OPTION) {
			String ruta = jf.getSelectedFile().getPath();
			try {
				cancionActual = archivoBinarioClase.leer(ruta.substring(0, ruta.length()-4) + ".krk");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancionActual.abrirCancion(ruta);
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbxGeneros) {
			int idGG = cbxGeneros.getSelectedIndex();
			if (idGG >= 0) {
				actualizarComboBoxartistas(generos.get(idGG).getListaAutores());
			}
		}else if (e.getSource() ==  cbxArtistas) {
			int id = cbxArtistas.getSelectedIndex();
			
		}
	}
	
	
}
