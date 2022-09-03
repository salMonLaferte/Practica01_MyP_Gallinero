
public class Bitacora {
    static String text = "";

    public static void registerEvent(Peleador fuente, String s){
        text += s + "\n";
        System.out.println();
    }
}
