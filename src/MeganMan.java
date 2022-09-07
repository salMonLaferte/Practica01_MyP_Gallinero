import java.util.Random;

/**
 * Representacion del peleador MeganMan.
 */
public class MeganMan implements Peleador{
    /**Habilidad especial actual de MeganMan */
    MeganManPoder poder;
    /**Vida de MeganMan */
    int vida;

    public MeganMan(){
        poder = new MeganManBase();
        vida = 100;
    }

    @Override
    public void ejecutarAtaque(Peleador objetivo) {
        Bitacora.registrarAtaque(this, objetivo);
        int fuerza = poder.ejecutarAtaque();
        objetivo.ejecutarDefensa(this, fuerza);
    }

    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        int golpeRecibido = poder.ejecutarDefensa( fuerza);
        vida -= golpeRecibido;
        if(vida < 0)
            vida = 0;
        Bitacora.registrarAccionDePelea(obtenerNombre() + " recibio un golpe por : " + golpeRecibido + ". Su vida restante es " + vida + "\n");
    }

    @Override
    public String obtenerNombre() {
        return "MeganMan";
    }

    @Override
    public void cambiaTransformacion() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        Bitacora.registrarAccionDePelea(":::  " + obtenerNombre() + " se comio una MeganMan-bebida " + "  :::");
        if(numeroAleatorio < .33f){
            poder = new Bass();
            Bitacora.registrarAccionDePelea("::: MeganMan se transformo en Bass :::\n");
        }
        else if(numeroAleatorio < .66f){
            poder = new Omega();
            Bitacora.registrarAccionDePelea("::: MeganMan se transformo en Omega :::\n");
        }else{
            poder = new Zero();
            Bitacora.registrarAccionDePelea("::: MeganMan se transformo un Zero :::\n");
        }
    }

    @Override
    public boolean haSidoDerrotado() {
        return vida <=0;
    }

}
