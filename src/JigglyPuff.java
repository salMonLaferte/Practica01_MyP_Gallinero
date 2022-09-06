import java.util.Random;
/**
 * Transformacion de Dittuu la cual representa a Dittuu transformado en Jiggly Puff
 * con su forma de pelear personalizada.
 */
public class JigglyPuff extends DittuuTransformacion implements FormaDePelear  {
    
    public JigglyPuff() {
        super();
    }

    public void setPeleadorBase( Peleador p){
        peleadorBase = p;
    }

    @Override
    public int ejecutarAtaque(Peleador objetivo) {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;
        
        if( numeroAleatorio >.3f ){
            Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu-JigglyPuff empezo cantando bien bonito");
            fuerza = 20;
        }else{
            Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu-JigglyPuff ataca durmiendote, como tu clase de matematicas");
            fuerza = 40;
        }
        return fuerza;
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registrarAccionDePelea(peleadorBase, "Dittuu-JigglyPuff se prepara para defenderse"); 

        int golpeRecibido =  fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }

        peleadorBase.reducirVida(golpeRecibido);
        Bitacora.registrarAccionDePelea(peleadorBase, "Perdió " + golpeRecibido + " puntos de vida");
    }

}
