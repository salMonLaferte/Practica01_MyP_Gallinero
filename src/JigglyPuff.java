import java.util.Random;
/**
 * El calculo de daño se haga en la defensa.
 */
public class JigglyPuff extends DittuuTransformacion implements FormaDePelear  {
    
    public JigglyPuff() {
        super();
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

            Bitacora.registrarAccionDePelea(personajeBase, "Dittuu-JigglyPuff empezo cantando bien bonito");
            fuerza = 20;
            Bitacora.registrarAccionDePelea(personajeBase, " " + fuerza );

        }else{
            Bitacora.registrarAccionDePelea(personajeBase, "Dittuu-JigglyPuff ataca durmiendote, como tu clase de matematicas");
            fuerza = 40;
            Bitacora.registrarAccionDePelea(personajeBase, " " + fuerza );
        }
        return fuerza;
    }


    /**
     * Aqui vamos a hacer el calculo de golpeRecibido.
     * Siempre se reciba alemnos 1 de golpeRecibido.
     */
    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(personajeBase, "Dittuu-JigglyPuff se prepara para defenderse"); 

        int golpeRecibido =  fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }

        personajeBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(personajeBase, "Perdió " + golpeRecibido + " puntos de vida");//termine
    }
    




}
