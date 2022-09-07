/**
 * Poder de MeganMan la cual representa a MeganMan sin transformacion.
 */
public class MeganManBase implements MeganManPoder {

    /**
     * Constructor de la clase de MeganMan Base
     */
    public MeganManBase() {
        super();
    }

    /**
     * Este metodo ejecuta ataques personalizados de base de MeganMan
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        Bitacora.registrarAccionDePelea( "MeganMan disparó sin mucha potencia.");
        return 3;
    }

    /**
     * Este metodo ejecuta la defensa personalizada de base de MeganMan
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "El traje MeganMan le proporcionó una defensa aceptable.");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        return golpeRecibido;
    }
    
}
