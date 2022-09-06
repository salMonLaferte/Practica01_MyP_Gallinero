import java.util.Random;
/**
 * Transformacion de Korby la cual representa a Korby transformado en Meta Knight
 * con su forma de pelear personalizada.
 */
public class MetaKnight extends KorbyTransformacion implements FormaDePelear{

    public MetaKnight() {
        super();
    }
    
    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Korby-Meta Knight ataca con turbo taladro, el mismo que usa tu vecino a las 6 de la mañana");
            fuerza = 40;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Korby-Meta Knight ataca con un Megaataque");
            fuerza = 25;
        } else {
            Bitacora.registrarAccionDePelea(peleadorBase, "Korby-Meta Knight ataca como un tonado similar a tu crush, porque te manda a volar");
            fuerza = 30;
        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Korby-Meta Knight se defiende con sus guantes blancos especiales");

        int golpeRecibido = fuerza - 5;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "Perdió " + golpeRecibido + " puntos de vida");
        
    }

}
