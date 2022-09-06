/**
 * Transformacion de MeganMan la cual representa a MeganMan sin transformacion.
 */
public class MeganManBase extends Transformacion implements FormaDePelear {

    public MeganManBase() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Bitacora.registrarAccionDePelea(peleadorBase, "MeganMan disparó sin mucha potencia.");
        return 3;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "El traje MeganMan le proporcionó una defensa aceptable.");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "MeganMan recibió un golpe de: " +  golpeRecibido );
    }
    
}
