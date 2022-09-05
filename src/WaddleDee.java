import java.util.concurrent.ThreadLocalRandom;

public class WaddleDee extends KorbyTransformacion implements FormaDePelear {

    public WaddleDee(int ataqueBase, int defensaBase) {
        super(ataqueBase, defensaBase);
        // TODO Auto-generated constructor stub
    }

    public void setPeleadorBase(Peleador p) {
        personajeBase = p;
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registerEvent(personajeBase, "Al parecer WaddleDee es un personaje pacifico, \n" +
                    "pero hoy escogio la violencia");
            return 6;
        } else if (randomNum == 2) {
            Bitacora.registerEvent(personajeBase, "WaddleDee se transformo en ninja y se tasajeo al rival");
            return 8;
        } else {
            Bitacora.registerEvent(personajeBase, "WaddleDee le lanzo una lanza al enemigo");
            return 12;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "WaddleDee se defiende bien porque le cae bien al programador");
        int daño = fuerza - 4;
        if (daño <= 0) {
            daño = 1;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registerEvent(personajeBase, "Sin embargo aun asi pierde " + daño + " de vida");
    }

}
