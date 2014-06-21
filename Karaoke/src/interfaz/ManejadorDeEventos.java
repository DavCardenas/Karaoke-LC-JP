package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.Karaoke;

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
		case AgregarCancion.ACEPTAR_CANCION:
			karaoke.enviarDatosCancion();
			karaoke.getAgregarCancion().vaciarCamposCancion();
			break;
		case AgregarGenero.SUBIR_IMAGEN_GENERO:
			karaoke.getAgregarGenero().seleccionarArchivo();
			break;
		case AgregarGenero.ACEPTAR:
			karaoke.getAgregarGenero().agregarGenero();
			karaoke.actualizarListaGeneros();
			karaoke.getAgregarGenero().actulizarCampos();
			break;
		case AgregarAutor.ACEPTAR_AGREGAR_AUTOR:
			karaoke.getAgregarAutor().agregarAutor();
			karaoke.actualizarListasArtistas();
			karaoke.getAgregarAutor().vaciarCamposAutor();
			break;
		case AgregarAutor.SUBIR_IMAGEN_AUTOR:
			karaoke.getAgregarAutor().seleccionarArchivo();
		default:
			break;
		}
		
	}

}
