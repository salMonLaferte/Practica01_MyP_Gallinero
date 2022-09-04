public class Main{
    public static void main(String args[]){

        //
        JigglyPuff puff = new JigglyPuff( 10, 15);
        Peleador dittu = new Dittuu(100, puff);
        puff.setPeleadorBase(dittu);
        dittu.ejecutarAtaque(dittu);

        

    }
}