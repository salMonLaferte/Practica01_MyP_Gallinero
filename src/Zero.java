import java.util.Random;
/**
 * Transformacion de Megan Man la cual representa a Megan Man transformado en Zero
 * con su forma de pelear personalizada.
 */
public class Zero extends MeganManTransformacion implements FormaDePelear{

    public Zero() {
        super();
    }
    public void setPeleadorBase(Peleador p) {
        peleadorBase = p;
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea(peleadorBase, "¡¡Mega Man-Zero ataca con la espada Sigma, porque no sabes demostrar!!");
            fuerza = 40;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea(peleadorBase, "¡¡Mega Man-Zero hace el ataque lightning, aventando muchos rayos laser!!");
            fuerza = 25;
        } else {
            Bitacora.registrarAccionDePelea(peleadorBase, "¡¡Mega Man-Zero hace el ataque W-Shredder, creandote la ilusion de estar con ella!!");
            fuerza = 30;
        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Megan Man-Zero se defiende con su traje resistente");

        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "Perdió " + golpeRecibido + " puntos de vida");
    }
    
    
}
