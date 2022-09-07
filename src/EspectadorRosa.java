import java.io.FileNotFoundException;

/**
 * Espectador concreto
 */
public class EspectadorRosa extends Espectador implements Observador{

    public EspectadorRosa(Peleador favorito) {
        super(favorito);
        nombre = "Rosa";
        bitacora = "Bitacora de " +  nombre + " \nPeleador favorito = " + favorito.obtenerNombre() + "\n";
    }

    @Override
    public void actualizar() {
        Peleador ganador = Bitacora.obtenerGanador();
        //Si ya hay un ganador en la pelea genera un archivo de texto con la bitacora completa.
        if(ganador != null){
            String ganadorNombre = ganador.obtenerNombre();
            String peleadorFavoritoNombre = peleadorFavorito.obtenerNombre();
            if(ganadorNombre.equals(peleadorFavoritoNombre)){
                bitacora += "Felicidades! ganó tu peleador favorito: " + peleadorFavoritoNombre;
            }else{
                bitacora += "Mala suerte, tu peleador favorito: " + peleadorFavoritoNombre + " perdio, el ganador es: " + ganadorNombre;
            }
            try {
                escribirBitacoraEnArchivo();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            //Si aun no hay ganador agrega la ultima notificacion de combate a la bitacora
            bitacora += "XX " + Bitacora.obtenerUltimaModificacion() + " XX\n";
        }
    }
    
}
