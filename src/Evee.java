import java.util.Random;

/*
 * Poder especial de Dittuu la cual representa a Dittuu transformado en Evee
 * con su forma de pelear personalizada.
 */
public class Evee implements DittuuPoder {

    /**
     * Constructor de la clase Evee
     */
    public Evee() {
        super();
    }

    /**
     * Este metodo ejecuta ataques personalizados de Evee
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea("Dittuu-Evee ataca con su hermosa ternura");
            fuerza = 14;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea("Dittuu-Evee ataca excavando su corazón y no te encontro");
            fuerza = 6;
        } else {
            Bitacora.registrarAccionDePelea("Dittuu-Evee ataca con un golpe elite");
            fuerza = 11;
        }
        return fuerza;
    }

    /**
     * Este metodo ejecuta la defensa personalizada de Evee
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
    @Override
    public int ejecutarDefensa(int fuerza) {
        Bitacora.registrarAccionDePelea("Dituu-Eve se defiende con cinta de Sol");
        int golpeRecibido = fuerza - 3;
        if (golpeRecibido <= 0) {
            golpeRecibido = 1;
        }
        return golpeRecibido;
    }
}