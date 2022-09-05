import java.util.Random;
/**
 * El calculo de daño se haga en la defensa.
 */
public class JigglyPuff extends DittuuTransformacion implements FormaDePelear  {
    
    public JigglyPuff(int ataqueBase, int defensaBase) {
        super(ataqueBase, defensaBase);

    }

    public void setPeleadorBase( Peleador p){
        personajeBase = p;
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;
        
        if( numeroAleatorio >.3f ){

            Bitacora.registerEvent(personajeBase, "Dittuu-JigglyPuff empezo cantando bien bonito");
            fuerza = 20;
            Bitacora.registerEvent(personajeBase, " " + fuerza );

        }else{
            Bitacora.registerEvent(personajeBase, "Dittuu-JigglyPuff ataca durmiendote, como tu clase de matematicas");
            fuerza = 40;
            Bitacora.registerEvent(personajeBase, " " + fuerza );
        }
        return fuerza;
    }


    /**
     * Aqui vamos a hacer el calculo de golpeRecibido.
     * Siempre se reciba alemnos 1 de golpeRecibido.
     */
    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Dittuu-JigglyPuff se prepara para defenderse"); 

        int golpeRecibido =  fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }

        personajeBase.reducirVida(golpeRecibido);
        Bitacora.registerEvent(personajeBase, "Perdió " + golpeRecibido + " puntos de vida");//termine
    }
    




}
