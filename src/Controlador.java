import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que implementa metodos para reproducir combates
 */
public class Controlador {

    /**
     * Reproduce un combate aleatorio y registra en la Bitacora al 
     * peleador ganador
     */
    public static void reproducirCombateAleatorio(){
        //Crea a los peleadores.
        Korby korby = new Korby();
        Dittuu dittuu = new Dittuu();
        MeganMan meganMan = new MeganMan();

        //Mete a los peleadores en una lista
        ArrayList<Peleador> peleadoresCombatiendo = new ArrayList<>();
        peleadoresCombatiendo.add(korby);
        peleadoresCombatiendo.add(meganMan);
        peleadoresCombatiendo.add(dittuu);

        //Registra a los espectadores y asigna aleatoriamente un peleador favorito
        Random rand = new Random();
        Bitacora.bitacora.registrarObservador(new EspectadorDavid(peleadoresCombatiendo.get(rand.nextInt(3))));
        Bitacora.bitacora.registrarObservador(new EspectadorMonse(peleadoresCombatiendo.get(rand.nextInt(3))));
        Bitacora.bitacora.registrarObservador(new EspectadorJatziri(peleadoresCombatiendo.get(rand.nextInt(3))));
        Bitacora.bitacora.registrarObservador(new EspectadorRosa(peleadoresCombatiendo.get(rand.nextInt(3))));

        //Cada 4 turnos los peleadores cambian de transformacion
        int turno = 1;
        int turnosParaCambiarTransformacion = 4;

        //Ejecuta peleas aleatorias hasta que solo uno de los peleadores quede en pie.
        while( peleadoresCombatiendo.size() >= 2){
            //Selecciona aleatoriamente dos peleadores
            int[] indicesAleatoriosDistintos = obtenerNumerosAleatoriosDistintos(2, peleadoresCombatiendo.size());
            Peleador atacante = peleadoresCombatiendo.get(indicesAleatoriosDistintos[0]);
            Peleador objetivo = peleadoresCombatiendo.get(indicesAleatoriosDistintos[1]);
            //Uno de los peleadores seleccionados ataca al otro y si este se quedo sin vida lo sacos de la pelea
            atacante.ejecutarAtaque(objetivo);
            if(objetivo.haSidoDerrotado()){
                Bitacora.registrarAccionDePelea( "¡¡¡¡¡¡" + peleadoresCombatiendo.get(indicesAleatoriosDistintos[1]).obtenerNombre() + " ha quedado fuera de la pelea. " + "!!!!!!" );
                peleadoresCombatiendo.remove(indicesAleatoriosDistintos[1]);
            }
            turno++;
            //Se verifica si es hora de cambiar las transformaciones
            if(turno % turnosParaCambiarTransformacion == 0 ){
                for (Peleador p : peleadoresCombatiendo) {
                    p.cambiaTransformacion();
                }
            }
        }
        //Se registra el ultimo peleador en pie, es decir el ganador.
        Bitacora.registrarGanador(peleadoresCombatiendo.get(0));
    }

    /**
     * Regresa k numeros aleatorios distintos en el intervalo [0,n]
     * @param k Cantidad de numero aleatorios distintos
     * @param n Rango
     * @return k numeros aleatorios distintos no ordenados
     */
    static public int[] obtenerNumerosAleatoriosDistintos(int k, int n){
        int[] numeros = new int[n];
        int[] respuesta = new int[k];
        for(int i=0; i<numeros.length; i++){
            numeros[i] = i;
        }
        Random rand= new Random();
        int contador = 0;
        while(contador < k){
            int valorAleatorio = rand.nextInt(n-contador) + contador;//Genera un numero aleatorio en [contador, n]
            respuesta[contador] = numeros[valorAleatorio];//Agrega el numero en el indice generado a la respuesta 
            numeros[valorAleatorio] = numeros[contador];//Recorre el primer numero del intervalo restante a la derecha
            contador++;//Reduce el intervalo del arreglo de donde se seleccionan numeros
        }
        return respuesta;
    }
}
