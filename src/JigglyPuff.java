import java.util.Random;
/**
 * Poder especial de Dittuu la cual representa a Dittuu transformado en Jiggly Puff
 * con su forma de pelear personalizada.
 */
public class JigglyPuff implements DittuuPoder{
    
    public JigglyPuff() {
        super();
    }

    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;
        
        if( numeroAleatorio >.3f ){
            Bitacora.registrarAccionDePelea("Dittuu-JigglyPuff ataco cantando bien bonito");
            fuerza = 20;
        }else{
            Bitacora.registrarAccionDePelea( "Dittuu-JigglyPuff ataca durmiendote, como tu clase de matematicas");
            fuerza = 40;
        }
        return fuerza;
    }

    @Override
    public int ejecutarDefensa( int fuerza) {
        Bitacora.registrarAccionDePelea( "Dittuu-JigglyPuff se prepara para defenderse"); 
        int golpeRecibido =  fuerza - 2;
        if(golpeRecibido <= 0){
            golpeRecibido = 1;
        }
        Bitacora.registrarAccionDePelea( "Dittuu-JigglyPuff es algo fragil, su defensa no fue la mejor."); 
        return golpeRecibido;
    }

}
