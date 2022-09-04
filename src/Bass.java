import java.util.Random;

public class Bass extends MeganManTransformacion implements FormaDePelear{

    public Bass(int ataqueBase, int defensaBase) {
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
            Bitacora.registerEvent(personajeBase, "¡¡Bass ataca con su buster repetidamente!!");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 45);
            return 40;
        } else if (numeroAleatorio < .3f && numeroAleatorio > .1f) {
            Bitacora.registerEvent(personajeBase, "¡¡Bass acaba de saltar doble y dispararte!!");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 35);
            return 25;
        } else {
            Bitacora.registerEvent(personajeBase, "¡¡Bass acaba de copiar el poder de tu maestra, esta rotisimo!!");
            Bitacora.registerEvent(personajeBase, "Daño de ataque: " + 15);
            return 30;
        }
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Bass se defiende esquivando los ataques en el aire");

        int daño = fuerza - 2;
        if(daño <= 0){
            daño = 1;
        }
        personajeBase.reducirVida(daño);
        Bitacora.registerEvent(personajeBase, "Perdió" + daño + "puntos de vida");
   
        
    }
    
    
}
