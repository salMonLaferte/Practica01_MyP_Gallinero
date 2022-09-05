

public class Main{
    public static void main(String args[]){

        //
        JigglyPuff puff = new JigglyPuff( 10, 15);
        Peleador dittu = new Dittuu(100, puff);
        puff.setPeleadorBase(dittu);
        dittu.ejecutarAtaque(dittu);
        /*int[] numerosAl = Controlador.obtenerNumerosAleatoriosDistintos(2, 2);
        for(int i=0; i<numerosAl.length; i++){
            System.out.print(numerosAl[i] + ", ");
        }*/
        Controlador.reproducirCombateAleatorio();
    
    }



}