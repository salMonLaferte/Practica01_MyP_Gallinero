
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
                waddleDee.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "Korby se ha comido una WaddleDee-galleta");
            }
            else if(this instanceof MeganMan){
                Zero zero = new Zero();
                formaDePelear = zero;
                zero.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "MegaMan ha bebido una Zero-pocion");
            }
            else if(this instanceof Dittuu){
                Evee evee = new Evee();
                formaDePelear = evee;
                evee.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "Dittuu se ha comido una Evee-sopa");
            }
        }
        else if(numeroAleatorio <.66){
            if(this instanceof Korby){
                ReyDeDeDe reyDeDeDe = new ReyDeDeDe();
                formaDePelear = reyDeDeDe;
                reyDeDeDe.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "Korby se ha comido una reyDeDeDe-galleta");
            }
            else if(this instanceof MeganMan){
                Omega omega = new Omega();
                formaDePelear = omega;
                omega.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "MegaMan ha bebido una Omega-pocion");
            }
            else if(this instanceof Dittuu){
                JigglyPuff jigglyPuff = new JigglyPuff();
                formaDePelear = jigglyPuff;
                jigglyPuff.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "Dittuu se ha comido una JigglyPuff-sopa");
            }
        }
        else{
            if(this instanceof Korby){
                MetaKnight metaKnight = new MetaKnight();
                formaDePelear = metaKnight;
                metaKnight.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "Korby se ha comido una MetaKnight-galleta");
            }
            else if(this instanceof MeganMan){
                Bass bass = new Bass();
                formaDePelear = bass;
                bass.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "MegaMan ha bebido una Bass-pocion");
            }
            else if(this instanceof Dittuu){
                Mimikyu mimikyu = new Mimikyu();
                formaDePelear = mimikyu;
                mimikyu.personajeBase = this;
                Bitacora.registrarAccionDePelea(this, "Dittuu se ha comido una JigglyPuff-sopa");
            }
        }
        return;
    }
}
