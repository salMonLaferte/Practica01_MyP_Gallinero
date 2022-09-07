import java.util.Random;
/**
* Poder especial de Megan Man la cual representa a Megan Man transformado en Bass
 * con su forma de pelear personalizada.
 */
public class Bass implements MeganManPoder{

    public Bass() {
        super();
    }

    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;
        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea("Mega Man-Bass ataca con su buster repetidamente");
            fuerza = 45;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea( "Mega Man-Bass acaba de saltar doble y dispararte");
            fuerza = 35;
        } else {
            Bitacora.registrarAccionDePelea( "Mega Man-Bass acaba de copiar el poder de tu maestra, esta rotisimo");
            fuerza = 15;
        }
        return fuerza;
    }

    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea("Megan Man-Bass se defiende esquivando los ataques en el aire");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        return golpeRecibido;
    }
 
}
