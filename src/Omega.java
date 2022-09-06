import java.util.concurrent.ThreadLocalRandom;
/**
 * Transformacion de Megan Man la cual representa a Megan Man transformado en Omega
 * con su forma de pelear personalizada.
 */
public class Omega extends MeganManTransformacion implements FormaDePelear {

    public Omega() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Megan Man-Omega hizo un Tiro de Arco");
            return 8;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Megan Man-Omega ocupo espada perforadora");
            return 12;
        } else {
            Bitacora.registrarAccionDePelea(peleadorBase, "MeganMan-Omega ocupo un ataque cuyo nombre no podemos mencionar, \n" +
                    "ya que tenemos miedo de que cierta empresa que empieza con N y acaba con endo, nos demande.\n " +
                    "Pero es muy poderoso, creanos.");
            return 16;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Megan Man-Omega tiene armadura, el golpe no le afecta (tanto)");
        int gopeRecibido = fuerza - 2;
        if (gopeRecibido <= 0) {
            gopeRecibido = 4;
        }
        peleadorBase.reducirVida(gopeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase,
                "El complejo de Dios de Megan Man-Omega no lo vuelve inmortal, perdio " + gopeRecibido + " de vida");
    }

}
