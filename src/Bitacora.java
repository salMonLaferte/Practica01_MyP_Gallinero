import java.util.ArrayList;

/**
 * Clase que registra las acciones de pelea y avisa a los observadores
 * registrados cuando algo ha ocurrido en la pelea
 */
public class Bitacora implements Sujeto {

    /**
     * Contiene la ultima accion en pelea, de manera que un observador registrado
     * pueda obtener dicha accion una vez se le notifique
     */
    private String ultimaNotificacion;

    private Peleador peleadorGanador;

    /**
     * Observadores registrados y que son notificados cuando algo ha ocurrido
     * en una pelea.
     */
    private ArrayList<Observador> observadores;
    
    /**
     * Instancia de bitacora para usar funciones no estaticas
     * desde metodos estaticos
     *  */   
    public static Bitacora bitacora = new Bitacora();

    public Bitacora(){
        ultimaNotificacion = "";
        observadores = new ArrayList<>();
        peleadorGanador = null;
    }

    /**
     * Metodo que registra una accion ocurrida en la pelea y lo guarda
     * como la ultima notificacion
     * @param fuente Peleador que realizo la accion
     * @param s Accion de pelea a registrar
     */
    public static void registrarAccionDePelea(Peleador fuente, String s){
        bitacora.ultimaNotificacion = s;
        bitacora.notificarObservadores();
    }

    public static void registrarAtaque(Peleador fuente, Peleador objetivo){
        bitacora.ultimaNotificacion = "\n" + fuente.obtenerNombre() + " atacará a " + objetivo.obtenerNombre() + "\n";
        bitacora.notificarObservadores();
    }

    /**
     * Regresa una cadena con la ultima accion ocurrida en la pelea.
     * @return
     */
    public static String obtenerUltimaModificacion(){
        return bitacora.ultimaNotificacion;
    }

    /**
     * Regresa el peleador que gano
     * @return Regresa el peleador ganador o null si la pelea aun no termina
     */
    public static Peleador obtenerGanador(){
        return bitacora.peleadorGanador;
    }

    /**
     * Metodo para registrar quien gano la pelea
     * @param ganador el peleador identificado como el ganador de la pelea
     */
    public static void registrarGanador(Peleador ganador){
        bitacora.peleadorGanador = ganador;
        bitacora.notificarObservadores();
    }

    @Override
    public void registrarObservador(Observador observador) {
        bitacora.observadores.add(observador);    
    }

    @Override
    public void removerObservador(Observador observador) {
        bitacora.observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : bitacora.observadores) {
            observador.actualizar();
        }
    }

    

    
}
