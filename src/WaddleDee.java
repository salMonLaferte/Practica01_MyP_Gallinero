import java.util.concurrent.ThreadLocalRandom;
/**
 * Poder especial de Korby la cual representa a Korby transformado en WaddleDee
 * con su forma de pelear personalizada.
 */
public class WaddleDee implements KorbyPoder {

    public WaddleDee() {
        super();
    }

    @Override
    public int ejecutarAtaque() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea("Al parecer Korby-WaddleDee es un personaje pacifico, pero hoy escogio la violencia");
            return 6;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea("Korby-WaddleDee se transformo en ninja y se tasajeo al rival");
            return 8;
        } else {
            Bitacora.registrarAccionDePelea("Korby-WaddleDee le lanzo una lanza al enemigo");
            return 12;
        }
    }

    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea("Korby-WaddleDee se defiende bien porque le cae bien al programador");
        int golpeRecibido = fuerza - 4;
        if (golpeRecibido <= 0) {
            golpeRecibido = 1;
        }
        return golpeRecibido;
    }

}
