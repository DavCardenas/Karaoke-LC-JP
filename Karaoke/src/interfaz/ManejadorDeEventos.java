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
		case KaraokePrincipal.COMANDO_ABOUT:
			karaoke.MostrarAbout();
			break;
		
		case KaraokePrincipal.COMANDO_BOTON_AGREGAR_CANCION:
			karaoke.agregarCancion();
			break;
			
		case KaraokePrincipal.COMANDO_BOTON_AGREGAR_GENERO:
			karaoke.agregarGenero();
			break;
			
		case KaraokePrincipal.COMANDO_BOTON_ELIMINAR_GENERO:
			karaoke.mostrarEliminarGenero();
			break;
			
		case KaraokePrincipal.COMANDO_BOTON_AGREGAR_AUTOR:
			karaoke.agregarAutor();
			break;
			
		case AgregarCancion.ACEPTAR_CANCION:
			karaoke.getAgregarCancion().CrearCancion();
			karaoke.actualizarListasCanciones();
			karaoke.getAgregarCancion().vaciarCamposCancion();
			break;
			
		case KaraokePrincipal.COMANDO_SALIR:
			System.exit(0);
			break;
			
		case AgregarGenero.SUBIR_IMAGEN_GENERO:
			karaoke.getAgregarGenero().seleccionarArchivo();
			break;
			
		case AgregarGenero.ACEPTAR:
			karaoke.getAgregarGenero().agregarGenero();
			karaoke.actualizarListaGeneros();
			karaoke.getAgregarGenero().actulizarCampos();
			break;
			
		case EliminarGenero.ELIMINAR_GENERO:
			karaoke.getEliminarGenero().eliminarGenero(karaoke.getAgregarGenero().getGeneros());
			karaoke.getEliminarGenero().actualizarComboBoxGeneros(karaoke.getAgregarGenero().getGeneros());
			karaoke.actualizarListaGeneros();
			karaoke.actualizarListasArtistas();
			karaoke.actualizarListasCanciones();
			break;
			
		case AgregarAutor.ACEPTAR_AGREGAR_AUTOR:
			karaoke.getAgregarAutor().agregarAutor();
			karaoke.actualizarListasArtistas();
			karaoke.getAgregarAutor().vaciarCamposAutor();
			break;
			
		case AgregarAutor.SUBIR_IMAGEN_AUTOR:
			karaoke.getAgregarAutor().seleccionarArchivo();
			break;
			
		case AgregarCancion.SUBIR_IMAGEN:
			karaoke.getAgregarCancion().seleccionarArchivo();
			break;
			
		case KaraokePrincipal.COMANDO_BOTON_PLAY:
			karaoke.reproducir();
			karaoke.mostrarReproduccion();
			break;
			
		case KaraokePrincipal.COMANDO_BOTON_ELIMINAR_AUTOR:
			karaoke.eliminarAutor();
			break;
		
		case KaraokePrincipal.COMANDO_BOTON_ELIMINAR_CANCION:
			karaoke.eliminarCancion();
			break;
			
		case Reproduccion.BTN_ABRIR:
			karaoke.getVisualizacion().setCancion(karaoke.getReproduccion().abrirArchivo());
			karaoke.getReproduccion().dispose();
			karaoke.visualizar();
			break;
			
		case EliminarAutor.BTN_ELIMINAR_AUTOR:
			karaoke.getEliminarAutor().eliminarAutor();
			karaoke.getEliminarAutor().actualizarArtistasEliminados();
			karaoke.actualizarListasArtistas();
			break;
			
		case EliminarCancion.BTN_ELIMINAR_CANCION:
			karaoke.getEliminarCancion().eliminarCancion();
			karaoke.getEliminarCancion().actualizarCancionesEliminados();
			karaoke.actualizarListasCanciones();
			break;
			
		case Visualizacion.PAUSAR:
			karaoke.getVisualizacion().pausar();
			break;
		
		case Visualizacion.REANUDAR:
			karaoke.getVisualizacion().reanudar();
			break;
		
		case Visualizacion.DETENER:
			karaoke.getVisualizacion().detener();
			break;
			
		case Visualizacion.REPRODUCIR:
			karaoke.getVisualizacion().iniciar();
			break;
		
		default:
			break;
		}
		
	}

}
