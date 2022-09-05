import java.util.Random;

public class Zero extends MeganManTransformacion implements FormaDePelear{

    public Zero() {
        super();
    }
    public void setPeleadorBase(Peleador p) {
        personajeBase = p;
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;

        if (numeroAleatorio > .3f) {
            Bitacora.registerEvent(personajeBase, "¡¡Mega Man-Zero ataca con la espada Sigma, porque no sabes demostrar!!");
            fuerza = 40;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);
            
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registerEvent(personajeBase, "¡¡Mega Man-Zero hace el ataque lightning, aventando muchos rayos laser!!");
            fuerza = 25;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);

        } else {
            Bitacora.registerEvent(personajeBase, "¡¡Mega Man-Zero hace el ataque W-Shredder, creandote la ilusion de estar con ella!!");
            fuerza = 30;
            Bitacora.registerEvent(personajeBase, "Repercusion de ataque: " + fuerza);

        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Zero se defiende con su traje resistente");

        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        personajeBase.reducirVida(golpeRecibido);
        Bitacora.registerEvent(personajeBase, "Perdió " + golpeRecibido + " puntos de vida");
   
        
    }
    
    
}
