import java.util.Random;
/**
 * Poder especial de MeganMan la cual representa a Megan Man transformado en Zero
 * con su forma de pelear personalizada.
 */
public class Zero implements MeganManPoder{

    public Zero() {
        super();
    }

    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea( "Mega Man-Zero ataca con la espada Sigma, porque no sabes demostrar");
            fuerza = 40;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea( "Mega Man-Zero hace el ataque lightning, aventando muchos rayos laser");
            fuerza = 25;
        } else {
            Bitacora.registrarAccionDePelea( "Mega Man-Zero hace el ataque W-Shredder, creandote la ilusion de estar con ella");
            fuerza = 30;
        }
        return fuerza;
    }

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
