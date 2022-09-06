import java.util.concurrent.ThreadLocalRandom;
/**
 * Representa una de las transformaciones de MeganMan con su 
 * forma de pelear personalizada.
 */
public class Omega extends MeganManTransformacion implements FormaDePelear {

    public Omega() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea(personajeBase, "Omega hizo un Tiro de Arco");
            return 8;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea(personajeBase, "Omega ocupo espada perforadora");
            return 12;
        } else {
            Bitacora.registrarAccionDePelea(personajeBase, "Omega ocupo un ataque cuyo nombre no podemos mencionar, \n" +
                    "ya que tenemos miedo de que cierta empresa que empieza con N y acaba con endo, nos demande.\n " +
                    "Pero es muy poderoso, creanos.");
            return 16;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(personajeBase, "Omega tiene armadura, el golpe no le afecta (tanto)");
        int daño = fuerza - 2;
        if (daño <= 0) {
            daño = 4;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registrarAccionDePelea(personajeBase,
                "El complejo de Dios de Omega no lo vuelve inmortal, perdio " + daño + " de vida");
    }

}
