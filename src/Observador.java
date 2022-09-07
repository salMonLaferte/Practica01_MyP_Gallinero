/**
 * Interfaz del Observador para implementar el patron "Observer" la idea es que se use en conjunto
 * con Sujeto
 */
public interface Observador {
    /**
     * Actualiza los datos del observador, la idea es que se llame a este metodo desde un sujeto de interes
     * al ocurrir un evento
     */
    public void actualizar();
}
