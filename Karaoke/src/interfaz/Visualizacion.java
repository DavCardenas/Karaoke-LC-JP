package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logica.Cancion;

public class Visualizacion extends JDialog implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JButton Reproducir;
	private JPanel pnlContenedor;
	private JPanel pnlBotones;
	private ImageIcon iconPausa;
	private ImageIcon iconReanuda;
	private ImageIcon iconDetiene;
	private ImageIcon iconReproduce;
	public final static String PAUSAR = "PAUSA";
	public final static String REANUDAR = "REANUDA";
	public final static String DETENER = "DETIENE";
	public final static String REPRODUCIR = "REPRODUCIR";
	public Font fuenteLb;

	public Visualizacion(KaraokePrincipal karaoke, ManejadorDeEventos eventos, Cancion cancionActual) {
		setTitle("Visualizacion");
		setSize(600, 400);
		setModal(true);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/img/play.png")).getImage());
		setLayout(new BorderLayout());
		setLocationRelativeTo(karaoke);

		fuenteLb = new Font("Swis721 BlkEx BT", Font.PLAIN, 15);
		
		ejecucion = true;
		pausa = false;
		this.cancion = cancionActual;

		hiloVisualizar = new Thread(this);
		aux1 = "";
		aux2 = "";

		pnlContenedor = new JPanel();
		pnlContenedor.setLayout(new GridLayout(2, 1));

		lbSuperior = new JLabel("",JLabel.CENTER);
		lbSuperior.setFont(fuenteLb);
		
		lbInferior = new JLabel("",JLabel.CENTER);
		lbInferior.setFont(fuenteLb);

		pnlContenedor.add(lbSuperior);
		pnlContenedor.add(lbInferior);


		pnlBotones = new JPanel();
		pnlBotones.setLayout(new FlowLayout());

		iconPausa = new ImageIcon(getClass().getResource("/img/pause2.png"));
		iconReanuda = new ImageIcon(getClass().getResource("/img/reanudar2.png"));
		iconDetiene = new ImageIcon(getClass().getResource("/img/stop2.png"));
		iconReproduce = new ImageIcon(getClass().getResource("/img/play2.png"));
		

		
		Reproducir = new JButton(iconReproduce);
		Reproducir.setActionCommand(REPRODUCIR);
		Reproducir.addActionListener(eventos);
		Reproducir.setToolTipText("Reproducir");
		pnlBotones.add(Reproducir);
		
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

	public Cancion getCancion() {
		return cancion;
	}



	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}



	public void VisualizarLetra(){
		if (cancion.getLetra() != null) {
			aux1 = cancion.mostrarLetra();
			lbSuperior.setText(aux1);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (cancion.getLetra() != null) {
				aux2 = cancion.mostrarLetra();
				lbInferior.setText(aux1);
				lbSuperior.setText(aux2);
				lbSuperior.updateUI();
			}else{
				JOptionPane.showMessageDialog(null, "Se ha terminado la cancion", "Alerta", JOptionPane.INFORMATION_MESSAGE);
				detener();
			}
			
		} else{
		JOptionPane.showMessageDialog(null, "Terminado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			detener();
		}

	}

	@Override
	public void run() {
		while (ejecucion) {
			VisualizarLetra();
			while (pausa) {
				int i = 0;
				System.out.println("Pausa "+i);
				i++;
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
