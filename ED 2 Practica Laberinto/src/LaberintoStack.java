import java.util.Stack;

public class LaberintoStack {
    private final int TAMAÑO;
    private char[][] tablero;
    private Coordenada entrada, salida;
    private boolean[][] visitados;
    Stack<Pila> pilaCaminos;

//lol
    public LaberintoStack(int tamaño, char[][] tablero, Coordenada entrada, Coordenada salida) {
        this.TAMAÑO = tamaño;
        this.tablero = tablero;
        this.entrada = entrada;
        this.salida = salida;
        this.visitados = new boolean[TAMAÑO][TAMAÑO];
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                this.visitados[i][j] = false;
            }
        }
        
        this.pilaCaminos = new Stack<>();
    }

    public void mostrar() {
        for (int i = 0; i <= TAMAÑO + 1; i++) {
            System.out.print("X");
        }
        System.out.println();
        for (int i = 0; i < TAMAÑO; i++) {
            if (i != entrada.getFila()) {
                System.out.print("X");
            } else {
                System.out.print(" ");
            }
            for (int j = 0; j < TAMAÑO; j++) {
                System.out.print(tablero[i][j]);
            }
            if (i != salida.getFila()) {
                System.out.println("X");
            } else {
                System.out.println(" ");
            }
        }
        for (int i = 0; i <= TAMAÑO + 1; i++) {
            System.out.print("X");
        }
        System.out.println();
        System.out.println();
    }

    private boolean esCaminoValidoNuevo(Coordenada coordenada) {
        boolean caminoValido = false;

        if(coordenada.getColumna() < TAMAÑO && coordenada.getColumna() >= 0 && coordenada.getFila() >= 0 && coordenada.getFila() < TAMAÑO ){ // Primer requisito para que sea un camino valido

            if(tablero[coordenada.getFila()][coordenada.getColumna()] == ' '){ // La coordenada es camino ya que es un espacio en blanco

                if(!visitados[coordenada.getFila()][coordenada.getColumna()]){ // Si la coordenada no ha sido visitada
                    caminoValido = true;
                }
            }

        }



        return caminoValido;
    }


    public boolean existeCamino() {
        boolean existeCamino = true;
        boolean salidaEncontrada = false;
        Coordenada coordenadaActual;



        Stack<Coordenada> pilaCaminos = new Stack<>();
        pilaCaminos.push(entrada);
        visitados[entrada.getFila()][entrada.getColumna()] = true;
        while(existeCamino && !salidaEncontrada){
            coordenadaActual = pilaCaminos.pop();
            coordenadaActual.mostrar();
            Coordenada[] posicionesAExplorar = {coordenadaActual.arriba(),coordenadaActual.abajo(),coordenadaActual.izquierda(), coordenadaActual.derecha()};
            for(int i = 0; i < posicionesAExplorar.length; i++){
                Coordenada posicionAComprobar = posicionesAExplorar[i];
                if(esCaminoValidoNuevo(posicionAComprobar)){
                    pilaCaminos.push(posicionAComprobar);
                    visitados[posicionAComprobar.getFila()][posicionAComprobar.getColumna()] = true;
                }

            }

           if(pilaCaminos.isEmpty()){ // Si en la pila no hay elementos apìlados significa que no existe camino posible
                existeCamino = false;
            }


            if(coordenadaActual.iguales(salida)){ //Si la coordenada actual coincide con la coordenada de salida, el laberinto tendrá salida.
                salidaEncontrada = true;

            }



        }

        return existeCamino;
    }


}