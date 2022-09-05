import java.util.Random;

public class MetaKnight extends KorbyTransformacion implements FormaDePelear{

    public MetaKnight(int ataqueBase, int defensaBase) {
        super(ataqueBase, defensaBase);
    }
    public void setPeleadorBase(Peleador p) {
        personajeBase = p;
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();

        if (numeroAleatorio > .3f) {
            Bitacora.registerEvent(personajeBase, "Meta Knight ataca con turbo taladro, el mismo que usa tu vecino a las 6 de la mañana");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 40);
            return 40;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registerEvent(personajeBase, "Meta Knight ataca con un Megaataque");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 25);
            return 25;
        } else {
            Bitacora.registerEvent(personajeBase, "Meta Knight ataca como un tonado similar a tu crush, porque te manda a volar");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 30);
            return 30;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Se defiende con sus guantes blancos especiales");

        int daño = fuerza - 5;
        if(daño <= 0){
            daño = 1;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registerEvent(personajeBase, "Perdió" + daño + "puntos de vida");
        
    }

}
