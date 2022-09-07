/**
 * Poder de Dittuu la cual representa a Dittuu sin transformacion.
 */
public class DittuuBase implements DittuuPoder {

    /**
     * Constructor de la clase de Dittuu Base
     */
    public DittuuBase() {
        super();
    }

   /**
     * Este metodo ejecuta ataques personalizados de base de Dittuu
     * @return regresa un int con el danio causado al rival
     */
    @Override
    public int ejecutarAtaque() {
        Bitacora.registrarAccionDePelea("Dittuu ataco en su forma gelatinosa y dio un poco de asco.");
        return 1;
    }

    /**
     * Este metodo ejecuta la defensa personalizada de base de Dittuu
     * @param fuerza la fuerza recibida del golpe dado por el rival
     * @return el danio total recibido(danio enemigo - fuerza de defenza)
     */
    @Override
    public int ejecutarDefensa(int fuerza) {
        Bitacora.registrarAccionDePelea("Dittuu esta gelatinoso y fue un poco complicado golpearlo.");
        int golpeRecibido = fuerza - 3;
        if (golpeRecibido <= 0)
            golpeRecibido = 1;
        return golpeRecibido;
    }

}
