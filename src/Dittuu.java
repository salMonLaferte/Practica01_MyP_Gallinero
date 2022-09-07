import java.util.Random;

/**
 * Representacion del peleador Dittuu.
 */
public class Dittuu implements Peleador {
    /** Habilidad especial actual de Dittuu */
    DittuuPoder poder;
    /** Vida de Dittuu */
    int vida;

    /**
     * Constructor de la clase Dittuu
     */
    public Dittuu() {
        poder = new DittuuBase();
        vida = 100;
    }

    /**
     * Metodo que registra el ataque de Dittu, sobre quien lo efectua,
     * con cuanta fuerza y la defensa del objetivo
     * @param objetivo El objetivo sobre el cual se ejecutará el ataque
     */
    @Override
    public void ejecutarAtaque(Peleador objetivo) {
        Bitacora.registrarAtaque(this, objetivo);
        int fuerza = poder.ejecutarAtaque();
        objetivo.ejecutarDefensa(this, fuerza);
    }

    /**
     * Metodo que ejecuta y regista en la bitacora la defensa de Dittu
     * @param atacante Quien golpeo a Dittu
     * @param fuerza Que recibe, dice con cuanta fuerza lo golpeo
     */
    @Override
    public void ejecutarDefensa(Peleador atacante, int fuerza) {
        int golpeRecibido = poder.ejecutarDefensa(fuerza);
        vida -= golpeRecibido;
        if (vida < 0)
            vida = 0;
        Bitacora.registrarAccionDePelea(
                obtenerNombre() + " recibio un golpe por : " + golpeRecibido + ". Su vida restante es " + vida + " \n");
    }

    /**
     * Metodo que obtiene el nombre de Dittu
     * @return El nombre de Dittu
     */
    @Override
    public String obtenerNombre() {
        return "Dittuu";
    }

    /**
     * Metodo que escoje que transformacion tomara Dittu, ocupa el azar.
     */
    @Override
    public void cambiaTransformacion() {
        Random rand = new Random();
        float numeroAleatorio = rand.nextFloat();
        Bitacora.registrarAccionDePelea(":::  " + obtenerNombre() + " se comio una Dittuu-gelatina " + "  :::");
        if (numeroAleatorio < .33f) {
            poder = new Evee();
            Bitacora.registrarAccionDePelea("::: Dittuu se transformo en Evee :::\n");
        } else if (numeroAleatorio < .66f) {
            poder = new Mimikyu();
            Bitacora.registrarAccionDePelea("::: Dittuu se transformo en Mimikyu :::\n");
        } else {
            poder = new JigglyPuff();
            Bitacora.registrarAccionDePelea("::: Dituu se transformo un JigglyPuff :::\n");
        }
    }

    /**
     * Metodo que indica si Dittu ha sido derrotado
     * @return verdadero si su vida es <= 0, falso en el caso contrario.
     */
    @Override
    public boolean haSidoDerrotado() {
        return vida <= 0;
    }
}
