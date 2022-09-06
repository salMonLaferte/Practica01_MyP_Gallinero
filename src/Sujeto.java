/**
 * Interfaz de sujeto que indica metodos para manejar los observadores del 
 * patron correspondiente.
 */
public interface Sujeto {
    public void registrarObservador(Observador observador);
    public void removerObservador(Observador observador);
    public void notificarObservadores();
}
