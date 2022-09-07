import java.util.Random;
/**
 * Poder especial de MeganMan la cual representa a Megan Man transformado en Zero
 * con su forma de pelear personalizada.
 */
public class Zero implements MeganManPoder{

    /**
     * Constructor de la clase de Zero
     */
    public Zero() {
        super();
    }

    /**
     * Este metodo ejecuta ataques personalizados de Zero
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea( "Mega Man-Zero ataca con la espada Sigma, porque no sabes demostrar");
            fuerza = 13;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea( "Mega Man-Zero hace el ataque lightning, aventando muchos rayos laser");
            fuerza = 6;
        } else {
            Bitacora.registrarAccionDePelea( "Mega Man-Zero hace el ataque W-Shredder, creandote la ilusion de estar con ella");
            fuerza = 15;
        }
        return fuerza;
    }

    /**
     * Este metodo ejecuta la defensa personalizada de Zero
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "Megan Man-Zero se defiende con su traje resistente");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        return golpeRecibido;
    }
    
    
}
