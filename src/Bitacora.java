import java.util.ArrayList;

/**
 * Clase que registra las acciones de pelea
 */
public class Bitacora implements Sujeto {
    private static String text = "";
    private static String ultimaNotificacion = "";
    private static ArrayList<Observador> observadores = new ArrayList<>();
    private static Bitacora bitacora = new Bitacora();

    public static void registerEvent(Peleador fuente, String s){
        //text += s + "\n";
        ultimaNotificacion = s;
        bitacora.notificarObservadores();
        System.out.println(s);
    }

    @Override
    public void registrarObservador(Observador observador) {
        observadores.add(observador);    
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }

    public static String obtenerUltimaModificacion(){
        return ultimaNotificacion;
    }
}
