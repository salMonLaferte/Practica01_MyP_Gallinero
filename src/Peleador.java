
public class Peleador {
    protected int vida = 100;
    protected FormaDePelear transformacion;

    public Peleador(int vida, FormaDePelear transformacion){
        this.vida = vida;
        this.transformacion = transformacion;
    }

    /**
     * Ataca al peleador objetivo
     * @param objetivo
     */
    public void ejecutarAtaque(Peleador objetivo){
        int fuerza = transformacion.ejecutarAtaque(objetivo);
        objetivo.ejecutarDefensa(objetivo, fuerza);
    }

    /**
     * Se defiende de atacante, que lo ataca con tal fuerza
     * @param atacante
     * @param fuerza
     */
    public void ejecutarDefensa(Peleador atacante,int fuerza){
        transformacion.ejecutarDefensa(atacante, fuerza);
    }
}
