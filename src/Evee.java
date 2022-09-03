import java.util.Random;

public class Evee implements FormaDePelear {

    private final int ATAQUE_BASE = 4;
    private final int DEFENSA_BASE = 2;
    Peleador base;

    public Evee(Peleador base){
        this.base = base;
    }

    @Override
    public void ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        boolean ataquePotenciado = false;
        int fuerza = ATAQUE_BASE;
        if(rand.nextDouble() < .5d){
            Bitacora.registerEvent(base, " se siente hermoso, cargado de autoestima prepara su ataque contra" + objetivo.name );
            ataquePotenciado = true;
            fuerza+= 2;
        }
        Bitacora.registerEvent(base, " atacó con ojitos tienos  a: " + objetivo.name );
        objetivo.ejecutarDefensa(base, fuerza);
        if(!ataquePotenciado)
            Bitacora.registerEvent(base, "no fue demasiado tierno, el ataque fue débil.");
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(base, "se defendio");
        base.reducirVida(fuerza - DEFENSA_BASE);
    }
    
}
