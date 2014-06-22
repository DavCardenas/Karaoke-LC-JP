package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Cancion;

public class Visualizacion extends JDialog implements Runnable{
	private JLabel lbSuperior;
	private JLabel lbInferior;
	private Cancion cancion;
	private Thread hiloVisualizar;
	private String aux1;
	private String aux2;
	private boolean ejecucion;
	private boolean pausa;
	private JButton Reanudar;
	private JButton Pausa;
	private JButton Detener;
	private JPanel pnlContenedor;
	private JPanel pnlBotones;
	private ImageIcon iconPausa;
	private ImageIcon iconReanuda;
	private ImageIcon iconDetiene;
	public final static String PAUSAR = "PAUSA";
	public final static String REANUDAR = "REANUDA";
	public final static String DETENER = "DETIENE";
	
	public Visualizacion(KaraokePrincipal karaoke, ManejadorDeEventos eventos, Cancion cancionActual) {
		setTitle("Visualizacion");
		setSize(600, 400);
		setModal(true);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/img/play.png")).getImage());
		setLayout(new BorderLayout());
		setLocationRelativeTo(karaoke);
		
		this.cancion = cancionActual;
		
		hiloVisualizar = new Thread(this);
		aux1 = "";
		aux2 = "";
		
		pnlContenedor = new JPanel();
		setLayout(new GridLayout(2, 1));
		
		lbSuperior = new JLabel("");
		lbInferior = new JLabel("");
		
		pnlContenedor.add(lbSuperior);
		pnlContenedor.add(lbInferior);
	
	
		pnlBotones = new JPanel();
		setLayout(new FlowLayout());
		
		iconPausa = new ImageIcon(getClass().getResource("/img/pause2.png"));
		iconReanuda = new ImageIcon(getClass().getResource("/img/play2.png"));
		iconDetiene = new ImageIcon(getClass().getResource("/img/stop2.png"));
		
		Pausa = new JButton(iconPausa);
		Pausa.setActionCommand(PAUSAR);
		Pausa.addActionListener(eventos);
		Pausa.setToolTipText("Pausar");
		pnlBotones.add(Pausa);
		
		Reanudar = new JButton(iconReanuda);
		Reanudar.setActionCommand(REANUDAR);
		Reanudar.addActionListener(eventos);
		Reanudar.setToolTipText("Reanudar");
		pnlBotones.add(Reanudar);
		
		Detener = new JButton(iconDetiene);
		Detener.setActionCommand(DETENER);
		Detener.addActionListener(eventos);
		Detener.setToolTipText("Detener");
		pnlBotones.add(Detener);
		
		add(pnlContenedor,BorderLayout.CENTER);
		add(pnlBotones,BorderLayout.SOUTH);
	
	}
	
	
	
	public void Visualizar(){
		aux1 = cancion.mostrarLetra();
		lbSuperior.setText(aux1);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aux2 = cancion.mostrarLetra();
		lbInferior.setText(aux1);
		lbSuperior.setText(aux2);
	}
	
	@Override
	public void run() {
		while (ejecucion) {
			Visualizar();
			while (pausa) {
				System.out.println("Pausado");
			}
		}
	}
	
	public void iniciar() {
		ejecucion = true;
		hiloVisualizar.start();
	}
	public void detener() {
		ejecucion = false;
	}
	public void pausar(){
		pausa = true;
	}
	public void reanudar() {
		pausa = false;
	}
	

}
