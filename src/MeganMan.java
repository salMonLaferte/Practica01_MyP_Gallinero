public class MeganMan extends Peleador implements Transformable {

    public MeganMan(int vida, FormaDePelear transformacion) {
        super(vida, transformacion);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void cambiaTransformacion(FormaDePelear t) {
       formaDePelear = t;
    }
    
    
}
