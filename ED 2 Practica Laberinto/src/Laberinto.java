public class Laberinto {

    private final int TAMAÑO;
    private char[][] tablero;
    private Coordenada entrada, salida;
    private Pila pilaCaminos;
    private boolean[][] visitados;


    public Laberinto(int tamaño, char[][] tablero, Coordenada entrada, Coordenada salida) {
        this.TAMAÑO = tamaño;
        this.tablero = tablero;
        this.entrada = entrada;
        this.salida = salida;
        this.pilaCaminos = new Pila();
        this.visitados = new boolean[TAMAÑO][TAMAÑO];
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                this.visitados[i][j] = false;
            }
        }
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



        Pila pilaCaminos = new Pila();
        pilaCaminos.apilar(entrada);
        visitados[entrada.getFila()][entrada.getColumna()] = true;
        while(existeCamino && !salidaEncontrada){
            coordenadaActual = pilaCaminos.desapilar();
            coordenadaActual.mostrar();
            Coordenada[] posicionesAExplorar = {coordenadaActual.arriba(),coordenadaActual.abajo(),coordenadaActual.izquierda(), coordenadaActual.derecha()};
            for(int i = 0; i < posicionesAExplorar.length; i++){
               Coordenada posicionAComprobar = posicionesAExplorar[i];
               if(esCaminoValidoNuevo(posicionAComprobar)){
                   pilaCaminos.apilar(posicionAComprobar);
                   visitados[posicionAComprobar.getFila()][posicionAComprobar.getColumna()] = true;
               }

            }

            if(pilaCaminos.getNumElementos() == 0){ // Si en la pila no hay elementos apìlados significa que no existe camino posible
                existeCamino = false;
            }

         /*   if(visitados[salida.getFila()][salida.getColumna()] == true){ // Como al apilar elementos a la vez los consideramos como visitados, en caso de que la salida esté en la matriz de visitados, existirá
                salidaEncontrada = true;
                salida.mostrar();
            } */

            if(coordenadaActual.iguales(salida)){
                salidaEncontrada = true;
             //   salida.mostrar();
            }


        }



        return existeCamino;
    }


}
