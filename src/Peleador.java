
import java.util.Random;
/**
 * Representacion de un peleador que puede adquirir
 * una forma de pelear.
 */
public class Peleador {
    protected int vida = 100;
    protected FormaDePelear formaDePelear;
    protected String nombre = "";

    public Peleador(int vida, FormaDePelear transformacion){
        this.vida = vida;
        this.formaDePelear = transformacion;
    }

    /**
     * Ataca al peleador objetivo y ejecuta la defensa del peleador objetivo.
     * @param objetivo Peleador enemigo.
     */
    public void ejecutarAtaque(Peleador objetivo){
        Bitacora.registrarAtaque(this, objetivo);
        int fuerza = formaDePelear.ejecutarAtaque(objetivo);
        objetivo.ejecutarDefensa(objetivo, fuerza);
        
    }

    /**
     * Se defiende de atacante, que lo ataca con tal fuerza.
     * @param atacante Peleador que realizó el ataque.
     * @param fuerza Valor de ataque del atacante.
     */
    public void ejecutarDefensa(Peleador atacante,int fuerza){
        formaDePelear.ejecutarDefensa(atacante, fuerza);
        int aux = vida;
        if(aux < 0)
            aux = 0;
        Bitacora.registrarAccionDePelea(this, "A " + obtenerNombre() + " le quedan " + aux + " puntos de vida.");
    }

    /**
     * Reduce la vida del peleador
     * @param cantidad Cantidad de vida a reducir.
     */
    public void reducirVida(int cantidad){
        vida -= cantidad;
    }

    /*
     *Regresa el nombre del peleador.
     */
    public String obtenerNombre(){
        return nombre;
    }

    /**
     * Asigna una transformacion aleatoria al peleador
     * de manera que dicha transformacion corresponda a su franquicia.
     */
    public void cambiaTransformacion(){
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        //Asigna cada una de las respectivas transformaciones con probabilidad 1/3
        if(numeroAleatorio <.33){
            if(this instanceof Korby){
                WaddleDee waddleDee = new WaddleDee();
                formaDePelear = waddleDee;
                waddleDee.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::Korby se ha comido una WaddleDee-galleta::::\n");
            }
            else if(this instanceof MeganMan){
                Zero zero = new Zero();
                formaDePelear = zero;
                zero.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::MegaMan ha bebido una Zero-pocion::::\n");
            }
            else if(this instanceof Dittuu){
                Evee evee = new Evee();
                formaDePelear = evee;
                evee.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::Dittuu se ha comido una Evee-sopa::::\n");
            }
        }
        else if(numeroAleatorio <.66){
            if(this instanceof Korby){
                ReyDeDeDe reyDeDeDe = new ReyDeDeDe();
                formaDePelear = reyDeDeDe;
                reyDeDeDe.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::Korby se ha comido una reyDeDeDe-galleta::::\n");
            }
            else if(this instanceof MeganMan){
                Omega omega = new Omega();
                formaDePelear = omega;
                omega.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::MegaMan ha bebido una Omega-pocion::::\n");
            }
            else if(this instanceof Dittuu){
                JigglyPuff jigglyPuff = new JigglyPuff();
                formaDePelear = jigglyPuff;
                jigglyPuff.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::Dittuu se ha comido una JigglyPuff-sopa::::\n");
            }
        }
        else{
            if(this instanceof Korby){
                MetaKnight metaKnight = new MetaKnight();
                formaDePelear = metaKnight;
                metaKnight.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::Korby se ha comido una MetaKnight-galleta::::\n");
            }
            else if(this instanceof MeganMan){
                Bass bass = new Bass();
                formaDePelear = bass;
                bass.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::MegaMan ha bebido una Bass-pocion::::\n");
            }
            else if(this instanceof Dittuu){
                Mimikyu mimikyu = new Mimikyu();
                formaDePelear = mimikyu;
                mimikyu.peleadorBase = this;
                Bitacora.registrarAccionDePelea(this, "\n::::Dittuu se ha comido una JigglyPuff-sopa::::\n");
            }
        }
        return;
    }
}
