/**
 * Transformacion de Dittuu la cual representa a Dittuu sin transformacion.
 */
public class DittuuBase extends Transformacion implements FormaDePelear {

    public DittuuBase() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu atacó en su forma gelatinosa y dió un poco de asco.");
        return 1;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu esta gelatinoso y fue un poco complicado golpearlo.");
        int golpeRecibido = fuerza - 3;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu recibio un golpe de  " + golpeRecibido);
    }
    
}
