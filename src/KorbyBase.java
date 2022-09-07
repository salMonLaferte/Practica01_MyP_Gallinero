/**
 * Poder especial de  Korby la cual representa a Korby sin transformacion.
 */
public class KorbyBase implements KorbyPoder {

    /**
     * Constructor de la clase de Korby Base
     */
    public KorbyBase() {
        super();
    }

    /**
     * Este metodo ejecuta ataques personalizados de base de Korby
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        Bitacora.registrarAccionDePelea("Korby dice Poyo y da un golpesito.");
        return 2;
    }

    /**
     * Este metodo ejecuta la defensa personalizada de base de Korby
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "Korby se hizo todavìa más bolita para defenderse.");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        return golpeRecibido;
    }
    
}
