import java.util.concurrent.ThreadLocalRandom;

public class ReyDeDeDe extends KorbyTransformacion implements FormaDePelear {

    public ReyDeDeDe() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea(personajeBase, "Rey Dedede hizo un lanzamiento de gordo");
            return 10;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea(personajeBase,
                    "Rey Dedede se burlo tanto de los otros oponentes que perdieron vida");
            return 12;
        } else {
            Bitacora.registrarAccionDePelea(personajeBase, "Rey Dede conto un chiste de Eugenio Derbez, " +
                    "eso no le hizo daño a nadie. Pero fue un chiste tan malo que los demas perdieron vida");
            return 15;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(personajeBase,
                "Rey Dedede nunca tomo clases de defensa personal, pero al menos intento meter las manos.");
        int daño = fuerza - 3;
        if (daño <= 0) {
            daño = 8;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registrarAccionDePelea(personajeBase, "Rey Dedede no está de suerte hoy, perdio: " + daño + " de vida");
    }

}
