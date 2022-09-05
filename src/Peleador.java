
public class Peleador {
    protected int vida = 100;
    protected FormaDePelear formaDePelear;

    public Peleador(int vida, FormaDePelear transformacion){
        this.vida = vida;
        this.formaDePelear = transformacion;
    }

    /**
     * Ataca al peleador objetivo
     * @param objetivo
     */
    public void ejecutarAtaque(Peleador objetivo){
        int fuerza = formaDePelear.ejecutarAtaque(objetivo);
        objetivo.ejecutarDefensa(objetivo, fuerza);
    }

    /**
     * Se defiende de atacante, que lo ataca con tal fuerza
     * @param atacante
     * @param fuerza
     */
    public void ejecutarDefensa(Peleador atacante,int fuerza){
        formaDePelear.ejecutarDefensa(atacante, fuerza);
    }

    /**
     * 
     */
    public void reducirVida(int cantidad){
        vida -= cantidad;
        if( vida <= 0 )
        {
            //Hacer algo que avise al controlador
        }
    }
}
