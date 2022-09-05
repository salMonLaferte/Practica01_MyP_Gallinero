public class Korby extends Peleador implements Transformable {



    public Korby(int vida, FormaDePelear transformacion) {
        super(vida, transformacion);
    }

    @Override
    public void cambiaTransformacion(FormaDePelear t) {
       formaDePelear = t;
    }
    
    
}
