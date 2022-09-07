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

    /**
     * Peleador que ha ganado.
     */
    private Peleador peleadorGanador;

    /**
     * Observadores registrados y que son notificados cuando algo ha ocurrido
     * en una pelea.
     */
    private ArrayList<Observador> observadores;

    /**
     * Instancia de bitacora para usar funciones no estaticas
     * desde metodos estaticos
     */
    public static Bitacora bitacora = new Bitacora();

    /**
     * Constructor de la clase Bitacora
     */
    public Bitacora() {
        ultimaNotificacion = "";
        observadores = new ArrayList<>();
        peleadorGanador = null;
    }

    /**
     * Metodo que registra una accion ocurrida en la pelea, lo guarda como la ultima
     * notificacion y notifica a los espectadores.
     * @param s  Accion de pelea a registrar
     */
    public static void registrarAccionDePelea(String s) {
        bitacora.ultimaNotificacion = s;
        bitacora.notificarObservadores();
    }

    /**
     * Registra cuando un peleador atacara a otro y notifica a los observadores.
     * @param fuente Peleador base.
     * @param objetivo Peleador que es el objetivo del peleador base.
     */
    public static void registrarAtaque(Peleador fuente, Peleador objetivo) {
        bitacora.ultimaNotificacion = fuente.obtenerNombre() + " atacara a " + objetivo.obtenerNombre() + "\n";
        bitacora.notificarObservadores();
    }

    /**
     * Regresa una cadena con la ultima accion ocurrida en la pelea.
     * @return Un string que detalla la ultima accion.
     */
    public static String obtenerUltimaModificacion() {
        return bitacora.ultimaNotificacion;
    }

    /**
     * Regresa el peleador que ganador.
     * @return Regresa el peleador ganador o null si la pelea aun no termina.
     */
    public static Peleador obtenerGanador() {
        return bitacora.peleadorGanador;
    }

    /**
     * Metodo para registrar quien gano la pelea.
     * @param ganador el peleador identificado como el ganador de la pelea.
     */
    public static void registrarGanador(Peleador ganador) {
        bitacora.peleadorGanador = ganador;
        bitacora.notificarObservadores();
    }

    /**
     * Registra cuando hay un nuevo observador.
     * @param observador Que sera registrado.
     */
    @Override
    public void registrarObservador(Observador observador) {
        bitacora.observadores.add(observador);
    }

    /**
     * Elimina a un observador.
     * @param observador Que sera eliminado.
     */
    @Override
    public void removerObservador(Observador observador) {
        bitacora.observadores.remove(observador);
    }

    /**
     * Notifica a los observadores lo ocurrido en la pelea.
     */
    @Override
    public void notificarObservadores() {
        for (Observador observador : bitacora.observadores) {
            observador.actualizar();
        }
    }

}
