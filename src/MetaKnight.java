import java.util.Random;

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
            Bitacora.registrarAccionDePelea(personajeBase, "Korby-Meta Knight ataca con turbo taladro, el mismo que usa tu vecino a las 6 de la mañana");
            fuerza = 40;
            Bitacora.registrarAccionDePelea(personajeBase, "Repercusion de ataque: " + fuerza);

        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea(personajeBase, "Korby-Meta Knight ataca con un Megaataque");
            fuerza = 25;
            Bitacora.registrarAccionDePelea(personajeBase, "Repercusion de ataque: " + fuerza);

        } else {
            Bitacora.registrarAccionDePelea(personajeBase, "Korby-Meta Knight ataca como un tonado similar a tu crush, porque te manda a volar");
            fuerza = 30;
            Bitacora.registrarAccionDePelea(personajeBase, "Repercusion de ataque: " + fuerza);

        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(personajeBase, "Se defiende con sus guantes blancos especiales");

        int golpeRecibido = fuerza - 5;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        personajeBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(personajeBase, "Perdió " + golpeRecibido + " puntos de vida");
        
    }

}
