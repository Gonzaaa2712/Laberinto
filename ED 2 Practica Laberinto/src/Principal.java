public class Principal {

    public static void main(String[] args) {
        final int TAMAÑO = 6;
        Coordenada entrada, salida;
        char[][] tabla = new char[TAMAÑO][TAMAÑO];
        String fila0 = "X     ";
        String fila1 = "    X ";
        String fila2 = "X X XX";
        String fila3 = "   XX ";
        String fila4 = " X XX ";
        String fila5 = " X    ";
        tabla[0] = fila0.toCharArray();
        tabla[1] = fila1.toCharArray();
        tabla[2] = fila2.toCharArray();
        tabla[3] = fila3.toCharArray();
        tabla[4] = fila4.toCharArray();
        tabla[5] = fila5.toCharArray();
        entrada = new Coordenada(1,0);
        salida = new Coordenada(3, TAMAÑO - 1);
        System.out.println("USANDO LA CLASE Pila:");
        Laberinto laberinto = new Laberinto(TAMAÑO, tabla, entrada, salida);
        laberinto.mostrar();
        if (laberinto.existeCamino()) {
            System.out.println("Existe camino en el Laberinto desde la entrada a la salida");
        } else {
            System.out.println("No existe camino desde la entrada a la salida \n");
        }

        // TODO Completar el main usando LaberintoStack
        System.out.println("USANDO STACK :\n");
        LaberintoStack laberintoStack = new LaberintoStack(TAMAÑO, tabla, entrada, salida);
        laberintoStack.mostrar();
        if (laberintoStack.existeCamino()) {
            System.out.println("Existe camino en el Laberinto desde la entrada a la salida");
        } else {
            System.out.println("No existe camino desde la entrada a la salida");
        }

    }
}
