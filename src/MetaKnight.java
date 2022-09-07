import java.util.Random;
/**
 * Poder especial de Korby la cual representa a Korby transformado en Meta Knight
 * con su forma de pelear personalizada.
 */
public class MetaKnight implements KorbyPoder{

    /**
     * Constructor de la clase de MetaKnight
     */
    public MetaKnight() {
        super();
    }
    
    /**
     * Este metodo ejecuta ataques personalizados de MetaKnight
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea("Korby-Meta Knight ataca con turbo taladro, el mismo que usa tu vecino a las 6 de la mañana");
            fuerza = 12;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea( "Korby-Meta Knight ataca con un Megaataque");
            fuerza = 16;
        } else {
            Bitacora.registrarAccionDePelea( "Korby-Meta Knight ataca como un tonado similar a tu crush, porque te manda a volar");
            fuerza = 4;
        }
        return fuerza;
    }

    /**
     * Este metodo ejecuta la defensa personalizada de MetaKnight
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "Korby-Meta Knight se defiende con sus guantes blancos especiales");
        int golpeRecibido = fuerza - 5;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        return golpeRecibido;
    }

}
