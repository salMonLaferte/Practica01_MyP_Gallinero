public class MeganManBase extends Transformacion implements FormaDePelear {

    public MeganManBase(int ataqueBase, int defensaBase) {
        super(ataqueBase, defensaBase);
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Bitacora.registerEvent(personajeBase, "MeganMan disparó sin mucha potencia.");
        return 3;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "El traje MeganMan le proporcionó una defensa aceptable.");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        personajeBase.reducirVida(golpeRecibido);
    }
    
}
