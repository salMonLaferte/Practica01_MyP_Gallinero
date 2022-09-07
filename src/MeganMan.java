import java.util.Random;

/**
 * Representacion del peleador MeganMan.
 */
public class MeganMan implements Peleador{
    /**Habilidad especial actual de MeganMan */
    MeganManPoder poder;
    /**Vida de MeganMan */
    int vida;

    /**
     * Constructor de la clase MeganMan
     */
    public MeganMan(){
        poder = new MeganManBase();
        vida = 100;
    }

    /**
     * Metodo que registra el ataque de MeganMan, sobre quien lo efectua,
     * con cuanta fuerza y la defensa del objetivo.
     * @param objetivo El objetivo sobre el cual se ejecutará el ataque.
     */
    @Override
    public void ejecutarAtaque(Peleador objetivo) {
        Bitacora.registrarAtaque(this, objetivo);
        int fuerza = poder.ejecutarAtaque();
        objetivo.ejecutarDefensa(this, fuerza);
    }

    /**
     * Metodo que ejecuta y regista en la bitacora la defensa de MeganMan
     * @param atacante Quien golpeo a MeganMan
     * @param fuerza  Que recibe, dice con cuanta fuerza lo golpeo
     */
    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        int golpeRecibido = poder.ejecutarDefensa( fuerza);
        vida -= golpeRecibido;
        if(vida < 0)
            vida = 0;
        Bitacora.registrarAccionDePelea(obtenerNombre() + " recibio un golpe por : " + golpeRecibido + ". Su vida restante es " + vida + "\n");
    }

    /**
     * Metodo que obtiene el nombre de MeganMan
     * @return El nombre de MeganMan
     */
    @Override
    public String obtenerNombre() {
        return "MeganMan";
    }

    /**
     * Metodo que escoje que transformacion tomara MeganMan, ocupa el azar.
     */
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

    /**
     * Metodo que indica si MeganMan ha sido derrotado.
     * @return verdadero si su vida es <= 0, falso en el caso contrario.
     */
    @Override
    public boolean haSidoDerrotado() {
        return vida <=0;
    }

}
