package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManejadorDeEventos implements ActionListener{

	private KaraokePrincipal karaoke;
	
	public ManejadorDeEventos(KaraokePrincipal pkaraoke) {
		this.karaoke = pkaraoke;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch (comando) {
		case KaraokePrincipal.COMANDO_BOTON_AGREGAR_CANCION:
			karaoke.agregarCancion();
			break;
		case KaraokePrincipal.COMANDO_BOTON_AGREGAR_GENERO:
			karaoke.agregarGenero();
			break;
		case KaraokePrincipal.COMANDO_BOTON_AGREGAR_AUTOR:
			karaoke.agregarAutor();
			break;
			
		default:
			break;
		}
		
	}

}
