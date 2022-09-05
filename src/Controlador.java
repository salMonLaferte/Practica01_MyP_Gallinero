import java.util.ArrayList;
import java.util.Random;

public class Controlador {

    /**
     * 
     */
    public static void reproducirCombateAleatorio(){
        //Crea a los peleadores.
        ArrayList<Peleador> peleadoresCombatiendo = new ArrayList<>();
        Peleador korby = new Korby(100, new KorbyBase(1, 1));
        peleadoresCombatiendo.add(new Korby(100, new KorbyBase(1, 1)));
        
        peleadoresCombatiendo.add(new MeganMan(100, new MeganManBase(1, 1)));
        peleadoresCombatiendo.add(new Dittuu(100, new DittuuBase(1, 1)));
        //Ejecuta peleas aleatorias hasta que solo uno de los peleadores quede en pie.
        while( peleadoresCombatiendo.size() >= 2){
            //Selecciona aleatoriamente dos peleadores
            int[] indicesAleatoriosDistintos = obtenerNumerosAleatoriosDistintos(2, peleadoresCombatiendo.size());
            Peleador atacante = peleadoresCombatiendo.get(indicesAleatoriosDistintos[0]);
            Peleador objetivo = peleadoresCombatiendo.get(indicesAleatoriosDistintos[1]);
            //Uno de los peleadores seleccionados ataca al otro y si este se quedo sin vida lo sacos de la pelea
            atacante.ejecutarAtaque(objetivo);
            if(objetivo.vida <= 0){
                peleadoresCombatiendo.remove(indicesAleatoriosDistintos[1]);
            }
        }
        System.out.println("Gano el peleador " + peleadoresCombatiendo.get(0) );

    }

    static public int[] obtenerNumerosAleatoriosDistintos(int k, int n){
        int[] numeros = new int[n];
        int[] respuesta = new int[k];
        for(int i=0; i<numeros.length; i++){
            numeros[i] = i;
        }
        Random rand= new Random();
        int contador = 0;
        while(contador < k){
            int valorAleatorio = rand.nextInt(n-contador) + contador;
            respuesta[contador] = numeros[valorAleatorio]; 
            numeros[valorAleatorio] = numeros[contador];
            contador++;
        }
        return respuesta;
    }
}
