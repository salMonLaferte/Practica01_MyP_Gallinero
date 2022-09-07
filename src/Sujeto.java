/**
 * Interfaz de sujeto que indica metodos para manejar los observadores del patron "Observer",
 * se deberia usar en conjunto con la interfaz Observador.
 */
public interface Sujeto {
    /**
     * Registra un observador que puede ser notificado despues de algun evento de interes
     * @param observador Observador a registrar
     */
    public void registrarObservador(Observador observador);
    /**
     * Remueve un observador de manera que este deja deser notificado de los eventos de interes
     * @param observador  Observador a remover
     */
    public void removerObservador(Observador observador);
    /**
     * Notifica a los observadores registrados sobre un evento de interes
     */
    public void notificarObservadores();
}
