/**
 * Interfaz para formas de pelea basadas en atacar y defenderse
 * de objetos de tipo poeleador
 */
public interface FormaDePelear {
    /**
     * Se ejecuta un ataque contra un peleador objetivo, la idea es que
     * desde estos metodos se registren ataques en la bitacora.
     * @param objetivo Peleador al cual se ataca,
     * @return La fuerza con la que se ataca al objetivo.
     */
    public int ejecutarAtaque(Peleador objetivo);
    /**
     * Se ejecuta una defensa contra el peleador atacante, la idea es
     * que se disminuya la fuerza del ataque y se reste a la vida,
     * de manera que despues de ejecutar la defensa el peleador siempre pierde 
     * vida. 
     * Durante este metodo se realiza el calculo de la vida perdida.
     * @param atacante
     * @param fuerza
     */
    public void ejecutarDefensa(Peleador atacante, int fuerza);
}
