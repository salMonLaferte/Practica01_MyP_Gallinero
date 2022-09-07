/**
 * Poder de Dittuu la cual representa a Dittuu sin transformacion.
 */
public class DittuuBase implements DittuuPoder {

    public DittuuBase() {
        super();
    }

    @Override
    public int ejecutarAtaque() {
        Bitacora.registrarAccionDePelea( "Dittuu atacó en su forma gelatinosa y dió un poco de asco.");
        return 1;
    }

    @Override
    public int ejecutarDefensa(int fuerza) {
        Bitacora.registrarAccionDePelea( "Dittuu esta gelatinoso y fue un poco complicado golpearlo.");
        int golpeRecibido = fuerza - 3;
        if(golpeRecibido <= 0)
            golpeRecibido = 1;
        return golpeRecibido;
    }
    
}
