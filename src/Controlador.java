import java.util.ArrayList;
import java.util.Random;

public class Controlador {

    /**
     * 
     */
    public static void reproducirCombateAleatorio(){
        //Crea a los peleadores.
        ArrayList<Peleador> peleadoresCombatiendo = new ArrayList<>();
        
        KorbyBase korbyBase = new KorbyBase();
        Korby korby = new Korby(100, korbyBase);
        korbyBase.personajeBase = korby;

        DittuuBase dittuBase = new DittuuBase();
        Dittuu dittuu = new Dittuu(100, dittuBase);
        dittuBase.personajeBase = dittuu;

        MeganManBase meganManBase = new MeganManBase();
        MeganMan meganMan = new MeganMan(100, meganManBase);
        meganManBase.personajeBase = meganMan;
        
        peleadoresCombatiendo.add(korby);
        peleadoresCombatiendo.add(meganMan);
        peleadoresCombatiendo.add(dittuu);

        int turno = 1;
        int turnosParaCambiarTransformacion = 3;
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
            turno++;
            if(turno % turnosParaCambiarTransformacion == 0 ){
                for (Peleador p : peleadoresCombatiendo) {
                    p.cambiaTransformacion();
                }
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
