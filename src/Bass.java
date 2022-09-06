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

            Bitacora.registerEvent(personajeBase, "¡¡Mega Man-Bass ataca con su buster repetidamente!!");
            fuerza = 45;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registerEvent(personajeBase, "¡¡Mega Man-Bass acaba de saltar doble y dispararte!!");
            fuerza = 35;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);
        } else {
            Bitacora.registerEvent(personajeBase, "¡¡Mega Man-Bass acaba de copiar el poder de tu maestra, esta rotisimo!!");
            fuerza = 15;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);
        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Bass se defiende esquivando los ataques en el aire");

        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        personajeBase.reducirVida(golpeRecibido);
        Bitacora.registerEvent(personajeBase, "Perdió " + golpeRecibido + " puntos de vida");
     
    }
 
}
