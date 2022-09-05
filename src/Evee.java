import java.util.Random;

public class Evee extends DittuuTransformacion implements FormaDePelear {

    public Evee() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registerEvent(personajeBase, "Dittuu-Evee ataca con su hermosa ternura");
            fuerza = 15;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);

        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registerEvent(personajeBase, "Dittuu-Evee ataca excavando su corazón y no te encontro");
            fuerza = 50;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);
 
        } else {
            Bitacora.registerEvent(personajeBase, "Dittuu-Evee ataca con un golpe elite");
            fuerza = 35;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);

        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Se prepara para defenderse con cinta de Sol");

        int golpeRecibido = fuerza - 3;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        personajeBase.reducirVida(golpeRecibido);
        Bitacora.registerEvent(personajeBase, "Perdió " + golpeRecibido + " puntos de vida");
    }
}