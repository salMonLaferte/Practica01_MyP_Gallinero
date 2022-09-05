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
        
        if( numeroAleatorio >.3f )
        {
            //tira un ataque
            Bitacora.registerEvent(personajeBase, "Empezó cantando bien bonito");
            Bitacora.registerEvent(personajeBase, " " + 40 );
            return 10;
        }
        else{
            //mejor tira otro ataque
            return 3;
        }
    }


    /**
     * Aqui vamos a hacer el calculo de daño.
     * Siempre se reciba alemnos 1 de daño.
     */
    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        Bitacora.registerEvent(personajeBase, "Se prepara para defenderse"); 
        Bitacora.registerEvent(personajeBase, "Se defendió chido");
        int daño =  fuerza -2;
        if(daño <= 0)
            daño = 1;
        personajeBase.reducirVida(daño);
        Bitacora.registerEvent(personajeBase, "Perdió " + daño + " puntos de vida");//termine
    }
    




}
