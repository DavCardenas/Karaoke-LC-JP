package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Visualizacion extends JDialog{
	private JLabel lbSuperior;
	private JLabel lbCentral;
	private JLabel lbInferior;
	
	
	
	public Visualizacion(KaraokePrincipal karaoke, ManejadorDeEventos eventos) {
		setTitle("Visualizacion");
		setSize(600, 400);
		setModal(true);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/img/play.png")).getImage());
		setLayout(new GridLayout(3,1));
		setLocationRelativeTo(karaoke);
		
		
		lbSuperior = new JLabel("");
		lbSuperior.setBackground(Color.red);
		
		lbCentral = new JLabel("");
		lbCentral.setBackground(Color.green);
		
		lbInferior = new JLabel("");
		lbInferior.setBackground(Color.blue);
		
		
		add(lbSuperior);
		add(lbCentral);
		add(lbInferior);
	}

}
