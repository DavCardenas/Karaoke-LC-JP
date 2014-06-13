package interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarGenero extends JDialog{

	private JLabel jLabel;
	private JTextField txtNombreGenero;
	private JButton buttonAceptar;
	
	public final static String ACEPTAR = "ACEPTAR";
	
	public AgregarGenero(KaraokePrincipal karaoke, ManejadorDeEventos deEventos) {
		
		setSize(300,170);
		setTitle("Agregar Genero");
		setModal(true);
		setLayout(new GridLayout(3, 1));
		
		jLabel = new JLabel("Ingrese el Genero");
		txtNombreGenero = new JTextField();
		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setActionCommand(ACEPTAR);
		buttonAceptar.addActionListener(deEventos);
		
		add(jLabel);
		add(txtNombreGenero);
		add(buttonAceptar);
	}
	
}
