import java.util.Random;

/*
 * Poder especial de Dittuu la cual representa a Dittuu transformado en Evee
 * con su forma de pelear personalizada.
 */
public class Evee implements DittuuPoder {

    /**
     * Constructor
     */
    public Evee() {
        super();
    }

    /**
     * Ejecuta los 3 posibles ataques de Evee
     * 
     * @return con cuanta fuerza ejecuto el golpe
     */
    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea("Dittuu-Evee ataca con su hermosa ternura");
            fuerza = 15;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea("Dittuu-Evee ataca excavando su corazón y no te encontro");
            fuerza = 50;
        } else {
            Bitacora.registrarAccionDePelea("Dittuu-Evee ataca con un golpe elite");
            fuerza = 35;
        }
        return fuerza;
    }

    /**
     * Ejecuta la defensa de Evee
     * 
     * @param recibe la fuerza con la que fue golpeada
     * @return cuanta vida perdio despues de ejecutar su defensa
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