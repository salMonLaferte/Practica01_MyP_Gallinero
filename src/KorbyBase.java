/**
 * Transformacion de Korby la cual representa a Korby sin transformacion.
 */
public class KorbyBase extends Transformacion implements FormaDePelear {

    public KorbyBase(int ataqueBase, int defensaBase) {
        super(ataqueBase, defensaBase);
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Bitacora.registerEvent(personajeBase,"Korby dice Poyo y da un golpesito.");
        return 2;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Korby se hizo todavìa más bolita para defenderse.");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        personajeBase.reducirVida(golpeRecibido);
    }
    
}
