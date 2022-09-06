import java.util.concurrent.ThreadLocalRandom;
/**
 * Transformacion de Korby la cual representa a Korby transformado en WaddleDee
 * con su forma de pelear personalizada.
 */
public class WaddleDee extends KorbyTransformacion implements FormaDePelear {

    public WaddleDee() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Al parecer WaddleDee es un personaje pacifico, \n" +
                    "pero hoy escogio la violencia");
            return 6;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea(peleadorBase, "WaddleDee se transformo en ninja y se tasajeo al rival");
            return 8;
        } else {
            Bitacora.registrarAccionDePelea(peleadorBase, "WaddleDee le lanzo una lanza al enemigo");
            return 12;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "WaddleDee se defiende bien porque le cae bien al programador");
        int daño = fuerza - 4;
        if (daño <= 0) {
            daño = 1;
        }
        peleadorBase.reducirVida(daño);
        Bitacora.registrarAccionDePelea(peleadorBase, "Sin embargo aun asi pierde " + daño + " de vida");
    }

}
