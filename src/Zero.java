import java.util.Random;
/**
 * Representa una de las transformaciones de MeganMan con su 
 * forma de pelear personalizada.
 */
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
            Bitacora.registrarAccionDePelea(personajeBase, "¡¡Mega Man-Zero ataca con la espada Sigma, porque no sabes demostrar!!");
            fuerza = 40;
            Bitacora.registrarAccionDePelea(personajeBase, "Repercusion de ataque: " + fuerza);
            
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registrarAccionDePelea(personajeBase, "¡¡Mega Man-Zero hace el ataque lightning, aventando muchos rayos laser!!");
            fuerza = 25;
            Bitacora.registrarAccionDePelea(personajeBase, "Repercusion de ataque: " + fuerza);

        } else {
            Bitacora.registrarAccionDePelea(personajeBase, "¡¡Mega Man-Zero hace el ataque W-Shredder, creandote la ilusion de estar con ella!!");
            fuerza = 30;
            Bitacora.registrarAccionDePelea(personajeBase, "Repercusion de ataque: " + fuerza);

        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(personajeBase, "Zero se defiende con su traje resistente");

        int golpeRecibido = fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        personajeBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(personajeBase, "Perdió " + golpeRecibido + " puntos de vida");
   
        
    }
    
    
}
