/**
 * Poder de Dittuu la cual representa a Dittuu sin transformacion.
 */
public class DittuuBase implements DittuuPoder {

    /**
     * Constructor
     */
    public DittuuBase() {
        super();
    }

    /**
     * Ejecuta el ataque base de Dittu
     * 
     * @return regresa el danio
     */
    @Override
    public int ejecutarAtaque() {
        Bitacora.registrarAccionDePelea("Dittuu ataco en su forma gelatinosa y dio un poco de asco.");
        return 1;
    }

    /**
     * Ejecuta la defensa base de Dittu
     * 
     * @param con cuanta fuerza fue golpeado
     * @return el danio total que recibio
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
