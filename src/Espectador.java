import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Clase que representa un espectador de la pelea
 */
public class Espectador {
    protected String nombre;
    protected Peleador peleadorFavorito;
    protected String bitacora = "";

    /**
     * Crea un espectador asignandole un peleador preferido.
     * 
     * @param favorito Peleador preferido del espectador, se le notificara de manera
     *                 personalizada si gano o perdio.
     */
    public Espectador(Peleador favorito) {
        peleadorFavorito = favorito;
    }

    /**
     * Escribe la bitacora a un archivo de texto.
     */
    public void escribirBitacoraEnArchivo() throws FileNotFoundException {
        String nombreDelArchivo = "bitacora" + nombre + ".txt";
        try (PrintStream fout = new PrintStream(nombreDelArchivo)) {
            fout.println(bitacora);
        } catch (FileNotFoundException fnfe) {
            System.err.println("No se encontro el archivo");
        } catch (SecurityException se) {
            System.err.println("no.");
        }
    }
}
