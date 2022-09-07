import java.util.concurrent.ThreadLocalRandom;
/**
 * Poder especial de Korby la cual representa a Korby transformado en WaddleDee
 * con su forma de pelear personalizada.
 */
public class WaddleDee implements KorbyPoder {

    /**
     * Constructor de la clase de WaddleDee
     */
    public WaddleDee() {
        super();
    }

    /**
     * Este metodo ejecuta ataques personalizados de WaddleDee
     * @return regresa un int con el danio causado al rival
     */
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

    /**
     * Este metodo ejecuta la defensa personalizada de WaddleDee
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
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
