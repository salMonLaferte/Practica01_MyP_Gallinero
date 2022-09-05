/**
 * 
 */
public class Transformacion {
    protected Peleador personajeBase;//a quien transforme

    public Transformacion(){
        this.personajeBase = null;
    }

    public void establecerPeleadorBase(Peleador peleador){
        personajeBase = peleador;
    }

    
}
