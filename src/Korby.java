import java.util.Random;

/**
 * Representa al peleador Korby
 */
public class Korby implements Peleador{
    /**Habilidad especial actual de Korby */
    KorbyPoder poder;
    /**Vida de Korby */
    int vida;

    public Korby(){
        poder = new KorbyBase();
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
        return "Korby";
    }

    @Override
    public void cambiaTransformacion() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        Bitacora.registrarAccionDePelea(":::  " + obtenerNombre() + " se comio una Korby-galleta " + "  :::");
        if(numeroAleatorio < .33f){
            poder = new MetaKnight();
            Bitacora.registrarAccionDePelea("::: Korby se transformo en Meta-Knight :::\n");
        }
        else if(numeroAleatorio < .66f){
            poder = new ReyDeDeDe();
            Bitacora.registrarAccionDePelea("::: Korby se transformo en el Rey Dedede :::\n");
        }else{
            poder = new WaddleDee();
            Bitacora.registrarAccionDePelea("::: Korby se transformo un Waddle Dee :::\n");
        }
    }

    @Override
    public boolean haSidoDerrotado() {
        return vida <= 0;
    }
    
}
