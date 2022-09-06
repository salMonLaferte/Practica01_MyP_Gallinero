public class MeganManBase extends Transformacion implements FormaDePelear {

    public MeganManBase() {
        super();
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Bitacora.registrarAccionDePelea(personajeBase, "MeganMan disparó sin mucha potencia.");
        return 3;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(personajeBase, "El traje MeganMan le proporcionó una defensa aceptable.");
        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        personajeBase.reducirVida(golpeRecibido);
    }
    
}
