public class Korby extends Peleador implements Transformable {



    public Korby(int vida, FormaDePelear transformacion) {
        super(vida, transformacion);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void cambiaTransformacion(FormaDePelear t) {
       transformacion = t;
    }
    
    
}
