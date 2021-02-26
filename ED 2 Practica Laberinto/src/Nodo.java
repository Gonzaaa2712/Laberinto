public class Nodo {

    private Coordenada dato; //Comentario de Gonzalo
    private Nodo siguiente; //Esto es un comentario.
    //Segundo comentario Gonzalo
    /*Este es un comentario
     * múltiple
     */

    public Nodo(Coordenada dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Coordenada getDato() {
        return dato;
    }

    public void setDato(Coordenada dato) {
        this.dato = dato;
    }
}

