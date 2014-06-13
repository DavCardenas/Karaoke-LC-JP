package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarCancion extends JDialog{

	private JLabel jLabel;
	private JTextField txtNombreCancion;
	private JButton buttonAceptar;
	
	public final static String ACEPTAR_CANCION = "ACEPTAR_CANCION";
	
	public AgregarCancion(KaraokePrincipal karaoke, ManejadorDeEventos deEventos) {
		
		setSize(300,170);
		setTitle("Agregar Cancion");
		setModal(true);
		GridBagLayout gridbag;
		
		setLayout(new GridLayout(3, 1));
		
		jLabel = new JLabel("Datos Cancion");
		txtNombreCancion = new JTextField();
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setActionCommand(ACEPTAR_CANCION);
		buttonAceptar.addActionListener(deEventos);
		
		add(jLabel);
		add(txtNombreCancion);
		add(buttonAceptar);
	}
}
