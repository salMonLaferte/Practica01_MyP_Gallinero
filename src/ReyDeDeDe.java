import java.util.concurrent.ThreadLocalRandom;
/**
 * Transformacion de Korby la cual representa a Korby transformado en ReyDeDeDe
 * con su forma de pelear personalizada.
 */
public class ReyDeDeDe extends KorbyTransformacion implements FormaDePelear {

    public ReyDeDeDe() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Korby-Dedede hizo un lanzamiento de gordo");
            return 10;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea(peleadorBase,
                    "Korby-Dedede se burlo tanto de los otros oponentes que perdieron vida");
            return 12;
        } else {
            Bitacora.registrarAccionDePelea(peleadorBase, "Korby-Dedede conto un chiste de Eugenio Derbez, " +
                    "eso no le hizo daño a nadie. Pero fue un chiste tan malo que los demas perdieron vida");
            return 15;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase,
                "Korby-Dedede nunca tomo clases de defensa personal, pero al menos intento meter las manos.");
        int golpeRecibido = fuerza - 3;
        if (golpeRecibido <= 0) {
            golpeRecibido = 8;
        }
        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "Korby-Dedede no está de suerte hoy, perdio: " + golpeRecibido + " de vida");
    }

}
