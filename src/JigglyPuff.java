import java.util.Random;
/**
 * Poder especial de Dittuu la cual representa a Dittuu transformado en Jiggly Puff
 * con su forma de pelear personalizada.
 */
public class JigglyPuff implements DittuuPoder{
    /**
     * Constructor de la clase JigglyPuff
     */
    public JigglyPuff() {
        super();
    }
    /**
     * Este metodo ejecuta ataques personalizados de JigglyPuff
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        int fuerza = 1;
        
        if( numeroAleatorio >.3f ){
            Bitacora.registrarAccionDePelea("Dittuu-JigglyPuff ataco cantando bien bonito");
            fuerza = 15;
        }else{
            Bitacora.registrarAccionDePelea( "Dittuu-JigglyPuff ataca durmiendote, como tu clase de matematicas");
            fuerza = 19;
        }
        return fuerza;
    }
    /**
     * Este metodo ejecuta la defensa personalizada de JigglyPuff
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
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
