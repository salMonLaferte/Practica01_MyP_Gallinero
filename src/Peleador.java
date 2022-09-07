
/**
 * Representacion de un peleador que puede adquirir
 * una forma de pelear.
 */
public interface Peleador {
    /**
     * Ataca al peleador objetivo y ejecuta la defensa del peleador objetivo.
     * @param objetivo Peleador enemigo.
     */
    public void ejecutarAtaque(Peleador objetivo);

    /**
     * Se defiende de atacante, que lo ataca con tal fuerza.
     * @param atacante Peleador que realizó el ataque.
     * @param fuerza Valor de ataque del atacante.
     */
    public void ejecutarDefensa(Peleador atacante,int fuerza);
    
    /**
     * Regresa el nombre del peleador.
     * @return Nombre del peleador.
     */
    public String obtenerNombre();

    /**
     * Asigna una transformacion aleatoria al peleador.
     */
    public void cambiaTransformacion();

    /**
     * Nos dice si el peleador ya no puede combatir.
     * @return true si el peleador se considera derroto, falso en caso contrario.
     */
    public boolean haSidoDerrotado();
}
