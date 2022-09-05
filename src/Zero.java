import java.util.Random;

public class Zero extends MeganManTransformacion implements FormaDePelear{

    public Zero(int ataqueBase, int defensaBase) {
        super(ataqueBase, defensaBase);

    }
    public void setPeleadorBase(Peleador p) {
        personajeBase = p;
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();

        if (numeroAleatorio > .3f) {
            Bitacora.registerEvent(personajeBase, "¡¡Zero ataca con la espada Sigma, porque no sabes demostrar!!");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 55);
            return 40;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registerEvent(personajeBase, "¡¡Zero hace el ataque lightning, aventando muchos rayos laser!!");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 35);
            return 25;
        } else {
            Bitacora.registerEvent(personajeBase, "¡¡Zero hace el ataque W-Shredder, creandote la ilusion de estar con ella!!");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 15);
            return 30;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Zero se defiende con su traje resistente");

        int daño = fuerza - 2;
        if(daño <= 0){
            daño = 1;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registerEvent(personajeBase, "Perdió" + daño + "puntos de vida");
   
        
    }
    
    
}
