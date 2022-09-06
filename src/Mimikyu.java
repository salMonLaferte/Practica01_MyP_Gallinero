import java.util.concurrent.ThreadLocalRandom;
/**
 * Transformacion de Dittuu la cual representa a Dittuu transformado en MimiKyu
 * con su forma de pelear personalizada.
 */
public class Mimikyu extends DittuuTransformacion implements FormaDePelear {

    public Mimikyu() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu-Mimikyu se cachetea al contrincante");
            return 7;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu-Mimikyu ocupa mazazo");
            return 10;
        } else {
            Bitacora.registrarAccionDePelea(peleadorBase,
                    "Dittuu-Mimikyu hace un movimiento muy poderoso, pero poco adecuado y nada fiel al \n " +
                            "lore de Pokemon, pedimos perdon a los fans, es que nunca lo jugamos");
            return 17;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Mimikyu es bueno para evitar los golpes");
        int golpeRecibido = fuerza - 3;
        if (golpeRecibido <= 0) {
            golpeRecibido = 8;
        }
        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "Sin emargo aun asi lograron lastimarlo, perdio " + golpeRecibido + " de vida");
    }

}
