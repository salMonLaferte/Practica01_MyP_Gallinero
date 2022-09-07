import java.util.concurrent.ThreadLocalRandom;
/**
 * Poder especial de Dittuu la cual representa a Dittuu transformado en MimiKyu
 * con su forma de pelear personalizada.
 */
public class Mimikyu implements DittuuPoder {

    public Mimikyu() {
        super();
    }

    @Override
    public int ejecutarAtaque() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (randomNum == 1) {
            Bitacora.registrarAccionDePelea( "Dittuu-Mimikyu se cachetea al contrincante");
            return 7;
        } else if (randomNum == 2) {
            Bitacora.registrarAccionDePelea( "Dittuu-Mimikyu ocupa mazazo");
            return 10;
        } else {
            Bitacora.registrarAccionDePelea(
                    "Dittuu-Mimikyu hace un movimiento muy poderoso, pero poco adecuado y nada fiel al lore de Pokemon");
            return 17;
        }
    }

    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "Dittu-Mimikyu se defiende, es bueno para evitar los golpes.");
        int golpeRecibido = fuerza - 3;
        if (golpeRecibido <= 0) {
            golpeRecibido = 8;
        }
        return golpeRecibido;
    }

}
