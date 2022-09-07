import java.util.concurrent.ThreadLocalRandom;

/**
 * Poder especial de Megan Man la cual representa a Megan Man transformado en Omega
 * con su forma de pelear personalizada.
 */
public class Omega implements MeganManPoder {
    /**
     * Constructor de la clase de Omega
     */
    public Omega() {
        super();
    }

    /**
     * Este metodo ejecuta ataques personalizados de Omega
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea("Megan Man-Omega hizo un Tiro de Arco");
            return 8;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea("Megan Man-Omega ocupo espada perforadora");
            return 12;
        } else {
            Bitacora.registrarAccionDePelea("MeganMan-Omega ocupo un ataque cuyo nombre no podemos mencionar, \n" +
                    "ya que tenemos miedo de que cierta empresa que empieza con N y acaba con endo, nos demande.\n " +
                    "Pero es muy poderoso, creanos.");
            return 16;
        }
    }
    /**
     * Este metodo ejecuta la defensa personalizada de Omega
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "Megan Man-Omega tiene armadura, el golpe no le afecta (tanto)");
        int golpeRecibido = fuerza - 2;
        if (golpeRecibido <= 0) {
            golpeRecibido = 4;
        }
        Bitacora.registrarAccionDePelea("El complejo de Dios de Megan Man-Omega no lo vuelve inmortal");
        return golpeRecibido;
    }

}
