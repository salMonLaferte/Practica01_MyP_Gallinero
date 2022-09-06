public interface Sujeto {
    public void registrarObservador(Observador observador);
    public void removerObservador(Observador observador);
    public void notificarObservadores();
}
