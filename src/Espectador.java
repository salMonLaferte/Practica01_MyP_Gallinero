import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Clase para que cada entidad de espectador tenga ciertos atributos comunes.
 */
public class Espectador {
    protected String nombre;
    protected Peleador peleadorFavorito;
    protected String bitacora = "";

    public Espectador(Peleador favorito){
        peleadorFavorito = favorito;
    }
    
    /**Escribe la bitacora a un archivo de texto.
     */
    public  void escribirBitacoraEnArchivo() throws FileNotFoundException {
        String nombreDelArchivo = "bitacora" + nombre + ".txt";
        try (PrintStream fout = new PrintStream(nombreDelArchivo)) {
            fout.println(bitacora);
        } catch (FileNotFoundException fnfe) {
            System.err.println("No se encontró el archivo");
        } catch (SecurityException se) {
            System.err.println("no.");
        }
    }
}
