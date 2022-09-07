import java.util.Random;

/**
 * Representacion del peleador Dittuu.
 */
public class Dittuu implements Peleador{
    /**Habilidad especial actual de Dittuu */
    DittuuPoder poder;
    /**Vida de Dittuu */
    int vida;

    public Dittuu(){
        poder = new DittuuBase();
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
        Bitacora.registrarAccionDePelea(obtenerNombre() + " recibio un golpe por : " + golpeRecibido + ". Su vida restante es " + vida + " \n");
    }

    @Override
    public String obtenerNombre() {
        return "Dittuu";
    }

    @Override
    public void cambiaTransformacion() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        Bitacora.registrarAccionDePelea(":::  " + obtenerNombre() + " se comio una Dittuu-gelatina " + "  :::");
        if(numeroAleatorio < .33f){
            poder = new Evee();
            Bitacora.registrarAccionDePelea("::: Dittuu se transformo en Evee :::\n");
        }
        else if(numeroAleatorio < .66f){
            poder = new Mimikyu();
            Bitacora.registrarAccionDePelea("::: Dittuu se transformo en Mimikyu :::\n");
        }else{
            poder = new JigglyPuff();
            Bitacora.registrarAccionDePelea("::: Dituu se transformo un JigglyPuff :::\n");
        }
    }

    @Override
    public boolean haSidoDerrotado() {
        return vida <= 0;
    }
}
