import java.util.Random;

/**
 * Poder especial de Megan Man la cual representa a Megan Man transformado en
 * Bass
 * con su forma de pelear personalizada.
 */
public class Bass implements MeganManPoder {

    /**
     * Constructor de la clase de Bass
     */
    public Bass() {
        super();
    }

    /**
     * Este metodo ejecuta ataques personalizados de Bass
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;
        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea("Mega Man-Bass ataca con su buster repetidamente");
            fuerza = 15;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea("Mega Man-Bass acaba de saltar doble y dispararte");
            fuerza = 8;
        } else {
            Bitacora.registrarAccionDePelea("Mega Man-Bass acaba de copiar el poder de tu maestra, esta rotisimo");
            fuerza = 12;
        }
        return fuerza;
    }

    /**
     * Este metodo ejecuta la defensa personalizada de Bass
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
    @Override
    public int ejecutarDefensa(int fuerza) {
        Bitacora.registrarAccionDePelea("Megan Man-Bass se defiende esquivando los ataques en el aire");
        int golpeRecibido = fuerza - 2;
        if (golpeRecibido <= 0) {
            golpeRecibido = 1;
        }
        return golpeRecibido;
    }

}
