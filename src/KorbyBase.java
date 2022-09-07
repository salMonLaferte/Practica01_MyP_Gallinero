/**
 * Poder especial de  Korby la cual representa a Korby sin transformacion.
 */
public class KorbyBase implements KorbyPoder {

    public KorbyBase() {
        super();
    }

    @Override
    public int ejecutarAtaque() {
        Bitacora.registrarAccionDePelea("Korby dice Poyo y da un golpesito.");
        return 2;
    }

    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "Korby se hizo todavìa más bolita para defenderse.");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        return golpeRecibido;
    }
    
}
