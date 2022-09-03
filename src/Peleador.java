public class Peleador {
    static final int VIDA_INICIAL = 100;
    protected int vida = VIDA_INICIAL;
    protected FormaDePelear transformacion;
    String name;

    public void ejecutarAtaque(Peleador objetivo){
        transformacion.ejecutarAtaque(objetivo);
    }

    public void ejecutarDefensa(Peleador atacante,int fuerza){
        transformacion.ejecutarDefensa(atacante, fuerza);
    }

    public void reducirVida(int cantidad){
        vida -= cantidad;
    }

}
