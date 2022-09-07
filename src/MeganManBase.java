/**
 * Poder de MeganMan la cual representa a MeganMan sin transformacion.
 */
public class MeganManBase implements MeganManPoder {

    public MeganManBase() {
        super();
    }

    @Override
    public int ejecutarAtaque() {
        Bitacora.registrarAccionDePelea( "MeganMan disparó sin mucha potencia.");
        return 3;
    }

    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "El traje MeganMan le proporcionó una defensa aceptable.");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        return golpeRecibido;
    }
    
}
