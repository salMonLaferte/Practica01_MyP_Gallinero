/**
 * Representa una transformacion aplicada a un peleador base.
 */
public class Transformacion {
    protected Peleador peleadorBase;//Sobre quien se aplica la transformacion.

    public Transformacion(){
        this.peleadorBase = null;
    }

    /**
     * Asocia un peleador a esta transformacion.
     * @param peleador
     */
    public void establecerPeleadorBase(Peleador peleador){
        peleadorBase = peleador;
    }

    
}
