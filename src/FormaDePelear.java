/**
 * Interfaz para formas de pelea basadas en atacar y defenderse
 * de objetos de tipo poeleador
 */
public interface FormaDePelear {
    public int ejecutarAtaque(Peleador objetivo);
    public void ejecutarDefensa(Peleador atacante, int fuerza);
}
