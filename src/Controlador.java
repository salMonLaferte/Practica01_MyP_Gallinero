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
        ArrayList<Peleador> peleadoresCombatiendo = new ArrayList<>();
        
        KorbyBase korbyBase = new KorbyBase();
        Korby korby = new Korby(100, korbyBase);
        korbyBase.peleadorBase = korby;

        DittuuBase dittuBase = new DittuuBase();
        Dittuu dittuu = new Dittuu(100, dittuBase);
        dittuBase.peleadorBase = dittuu;

        MeganManBase meganManBase = new MeganManBase();
        MeganMan meganMan = new MeganMan(100, meganManBase);
        meganManBase.peleadorBase = meganMan;

        //Mete a los peleadores en una lista
        peleadoresCombatiendo.add(korby);
        peleadoresCombatiendo.add(meganMan);
        peleadoresCombatiendo.add(dittuu);

        //Registra a los espectadores
        Bitacora.bitacora.registrarObservador(new EspectadorDavid(korby));
        Bitacora.bitacora.registrarObservador(new EspectadorMonse(meganMan));
        Bitacora.bitacora.registrarObservador(new EspectadorJatziri(dittuu));
        Bitacora.bitacora.registrarObservador(new EspectadorRosa(korby));

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
            if(objetivo.vida <= 0){
                Bitacora.registrarAccionDePelea( peleadoresCombatiendo.get(indicesAleatoriosDistintos[0]) , peleadoresCombatiendo.get(indicesAleatoriosDistintos[1]).obtenerNombre() + " ha quedado fuera de la pelea. " );
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
