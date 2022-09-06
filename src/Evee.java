import java.util.Random;
/*
 * Representa la transformacion de Dittuu en Evee.
 */
public class Evee extends DittuuTransformacion implements FormaDePelear {

    public Evee() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu-Evee ataca con su hermosa ternura");
            fuerza = 15;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu-Evee ataca excavando su corazón y no te encontro");
            fuerza = 50;
        } else {
            Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu-Evee ataca con un golpe elite");
            fuerza = 35;
        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Se prepara para defenderse con cinta de Sol");

        int golpeRecibido = fuerza - 3;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "Perdió " + golpeRecibido + " puntos de vida");
    }
}