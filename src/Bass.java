import java.util.Random;
/**
 * Representa una de las transformaciones de MeganMan con su 
 * forma de pelear personalizada.
 */
public class Bass extends MeganManTransformacion implements FormaDePelear{

    public Bass() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;
        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea(peleadorBase, "¡¡Mega Man-Bass ataca con su buster repetidamente!!");
            fuerza = 45;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea(peleadorBase, "¡¡Mega Man-Bass acaba de saltar doble y dispararte!!");
            fuerza = 35;
        } else {
            Bitacora.registrarAccionDePelea(peleadorBase, "¡¡Mega Man-Bass acaba de copiar el poder de tu maestra, esta rotisimo!!");
            fuerza = 15;
        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Megan Man-Bass se defiende esquivando los ataques en el aire");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "Megan Man-Bass perdió " + golpeRecibido + " puntos de vida");
    }
 
}
