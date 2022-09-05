import java.util.concurrent.ThreadLocalRandom;

public class Omega extends MeganManTransformacion implements FormaDePelear {

    public Omega(int ataqueBase, int defensaBase) {
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
            Bitacora.registerEvent(personajeBase, "Omega hizo un Tiro de Arco");
            return 8;
        } else if (randomNum == 2) {
            Bitacora.registerEvent(personajeBase, "Omega ocupo espada perforadora");
            return 12;
        } else {
            Bitacora.registerEvent(personajeBase, "Omega ocupo un ataque cuyo nombre no podemos mencionar, \n" +
                    "ya que tenemos miedo de que cierta empresa que empieza con N y acaba con endo, nos demande.\n " +
                    "Pero es muy poderoso, creanos.");
            return 16;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Omega tiene armadura, el golpe no le afecta (tanto)");
        int daño = fuerza - 2;
        if (daño <= 0) {
            daño = 4;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registerEvent(personajeBase,
                "El complejo de Dios de Omega no lo vuelve inmortal, perdio " + daño + " de vida");
    }

}
