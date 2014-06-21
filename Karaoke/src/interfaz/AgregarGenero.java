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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import logica.Genero;

public class AgregarGenero extends JDialog{

	private JLabel jLabel;
	private JTextField txtNombreGenero;
	private JButton buttonAceptar;
	private JButton subirImagen;
	private JLabel foto;
	private ArrayList<Genero> generos;
	private Genero genero;
	private URL imagenUrl;
	
	
	public final static String ACEPTAR = "ACEPTAR";
	public final static String SUBIR_IMAGEN_GENERO = "SUBIR_IMAGEN_GENERO";
	
	public AgregarGenero(KaraokePrincipal karaoke, ManejadorDeEventos deEventos) {
		
		setSize(500,300);
		setTitle("Agregar Genero");
		setLocationRelativeTo(karaoke);
		setModal(true);
		setIconImage(new ImageIcon(getClass().getResource("/img/AddGenero.png")).getImage());		
		
		GridBagLayout gridBag;
		gridBag = new GridBagLayout();
		GridBagConstraints gbc;
		
		setLayout(gridBag);
		
		jLabel = new JLabel("Ingrese el Genero");
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(jLabel, gbc);
		
		txtNombreGenero = new JTextField();
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 130, 0);
		add(txtNombreGenero, gbc);
		
		
		foto = new JLabel(new ImageIcon(getClass().getResource("/img/logo.png")));
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(foto, gbc);
		
		subirImagen = new JButton("Subir Imagen");
		subirImagen.setActionCommand(SUBIR_IMAGEN_GENERO);
		subirImagen.addActionListener(deEventos);
		gbc = new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(subirImagen, gbc);
		
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setActionCommand(ACEPTAR);
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
	
	public boolean camposVacios() {
		boolean vacios = false;
		if (txtNombreGenero.getText().isEmpty()) {
			vacios = true;
		}
		return vacios;
	}
	
	public boolean buscarRepetido() {
		boolean repetido = false;
		for (Genero genero : generos) {
			if (txtNombreGenero.getText().equals(genero.getNombre())) {
				repetido = true;
			}
		}
		return repetido;
	}
	
	public void agregarGenero() {
		if (!camposVacios()) {
			if (!buscarRepetido()) {
				genero = new Genero(txtNombreGenero.getText(), imagenUrl);
				generos.add(genero);
			}else {
				JOptionPane.showMessageDialog(null, "El genero ya esta");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Campos vacios");
		}
		
	}
	
	public void actualizarImagen(String imagen) {
		try
        {
            remove( foto );
            foto = new JLabel( new ImageIcon( cargarImagen( imagen ) ) );
            GridBagConstraints gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
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
	
	public void actulizarCampos() {
		txtNombreGenero.setText("");
	}
}
