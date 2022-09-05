import java.lang.invoke.MethodHandle;
import java.util.Random;

public class Peleador {
    protected int vida = 100;
    protected FormaDePelear formaDePelear;
    protected String nombre = "";

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
    }

    public void cambiaTransformacion(){
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        if(numeroAleatorio <.3){
            if(this instanceof Korby){
                WaddleDee waddleDee = new WaddleDee();
                formaDePelear = waddleDee;
                waddleDee.personajeBase = this;
            }
            else if(this instanceof MeganMan){
                Zero zero = new Zero();
                formaDePelear = zero;
                zero.personajeBase = this;
            }
            else if(this instanceof Dittuu){
                Evee evee = new Evee();
                formaDePelear = evee;
                evee.personajeBase = this;
            }
        }
        else if(numeroAleatorio <.6){
            if(this instanceof Korby){
                ReyDeDeDe reyDeDeDe = new ReyDeDeDe();
                formaDePelear = reyDeDeDe;
                reyDeDeDe.personajeBase = this;
            }
            else if(this instanceof MeganMan){
                Omega omega = new Omega();
                formaDePelear = omega;
                omega.personajeBase = this;
            }
            else if(this instanceof Dittuu){
                JigglyPuff jigglyPuff = new JigglyPuff();
                formaDePelear = jigglyPuff;
                jigglyPuff.personajeBase = this;
            }
        }
        else{
            if(this instanceof Korby){
                MetaKnight metaKnight = new MetaKnight();
                formaDePelear = metaKnight;
                metaKnight.personajeBase = this;
            }
            else if(this instanceof MeganMan){
                Bass bass = new Bass();
                formaDePelear = bass;
                bass.personajeBase = this;
            }
            else if(this instanceof Dittuu){
                Mimikyu mimikyu = new Mimikyu();
                formaDePelear = mimikyu;
                mimikyu.personajeBase = this; 
            }
        }
        return;
    }
}
