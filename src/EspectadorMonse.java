public class EspectadorMonse extends Espectador implements Observador {
    @Override
    public void actualizar() {
        bitacora += "Notificacion para Monse " + Bitacora.obtenerUltimaModificacion();
    }
    
}
