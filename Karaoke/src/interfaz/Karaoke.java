package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import logica.Genero;

public class Karaoke extends JFrame{
	
	private PanelGeneros generos;
	private logica.Karaoke karaoke;
	public Karaoke() {
		
		setTitle("Karaoke LC-JP");
		setSize(1000,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		generos = new PanelGeneros();
		karaoke = new logica.Karaoke();
		add(generos, BorderLayout.WEST);
		
	}
	
	public void actulizarListas() {
		generos.actualizarLista(karaoke.getListaGeneros());
	}

}
