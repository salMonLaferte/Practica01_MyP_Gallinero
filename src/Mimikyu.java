import java.util.concurrent.ThreadLocalRandom;

public class Mimikyu extends DittuuTransformacion implements FormaDePelear {

    public Mimikyu() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registerEvent(personajeBase, "Mimikyu se cachetea al contrincante");
            return 7;
        } else if (randomNum == 2) {
            Bitacora.registerEvent(personajeBase, "Mimikyu ocupa mazazo");
            return 10;
        } else {
            Bitacora.registerEvent(personajeBase,
                    "Mimikyu hace un movimiento muy poderoso, pero poco adecuado y nada fiel al \n " +
                            "lore de Pokemon, pedimos perdon a los fans, es que nunca lo jugamos");
            return 17;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Mimikyu es bueno para evitar los golpes");
        int daño = fuerza - 3;
        if (daño <= 0) {
            daño = 8;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registerEvent(personajeBase, "Sin emargo aun asi lograron lastimarlo, perdio " + daño + " de vida");
    }

}
