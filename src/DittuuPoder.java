/**
 * Interface que deben implementar todos los poderes especiales de Dittuu
 */
public interface DittuuPoder{
    /**
     * Ejecuta un golpe.
     * @return Magnitud que representa que tan fuerte es el ataque.
     */
    public int ejecutarAtaque();
    
    /**
     * Ejecuta una defensa ante un golpe.
     * @param fuerza Magnitud del golpe.
     * @return Una magnitud > 0 que representa la fuerza del golpe luego de aplicar la defensa.
     */
    public int ejecutarDefensa( int fuerza);

}
