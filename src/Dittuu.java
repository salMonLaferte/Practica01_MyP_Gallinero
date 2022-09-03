import java.util.Random;

public class Dittuu extends Peleador implements Transformable{

    @Override
    public void cambiaTransformacion() {
        Random rand = new Random();
        float randomIndicator = rand.nextFloat();
        if(randomIndicator < .33f){
            transformacion = new Evee(this);
            return;
        }
        
    }
    
}
