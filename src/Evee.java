import java.util.Random;

public class Evee extends DittuuTransformacion implements FormaDePelear {

    public Evee(int ataqueBase, int defensaBase) {
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
            Bitacora.registerEvent(personajeBase, "Evee ataca con su hermosa ternura");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 15);
            return 15;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registerEvent(personajeBase, " Evee ataca excavando su corazón y no te encontro");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 50);
            return 50;
        } else {
            Bitacora.registerEvent(personajeBase, "Evee ataca con un golpe elite");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 35);
            return 35;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Se prepara para defenderse con cinta de Sol");

        int daño = fuerza - 3;
        if(daño <= 0){
            daño = 1;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registerEvent(personajeBase, "Perdió" + daño + "puntos de vida");
    }
}