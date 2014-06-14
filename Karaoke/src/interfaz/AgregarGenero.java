package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarGenero extends JDialog{

	private JLabel jLabel;
	private JTextField txtNombreGenero;
	private JButton buttonAceptar;
	private JLabel foto;
	
	public final static String ACEPTAR = "ACEPTAR";
	
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
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 100, 0);
		add(txtNombreGenero, gbc);
		
		
		foto = new JLabel(new ImageIcon(getClass().getResource("/img/logo.png")));
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(foto, gbc);
		
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setActionCommand(ACEPTAR);
		buttonAceptar.addActionListener(deEventos);
		gbc = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(buttonAceptar, gbc);
		
		
	}
	
}
