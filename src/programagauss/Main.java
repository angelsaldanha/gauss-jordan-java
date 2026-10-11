package programagauss;

public class Main {

    public static void main(String[] args) {

        // paso 1: obtención de los coeficientes del sistema
        // se llama al método estático defmatriz() de Matriz
        // retorna la matriz aumentada de 3x4 (3 ecuaciones, 3 incógnitas + 1 columna términos independientes).
        double[][] matriz = Matriz.defmatriz();

        // paso 2: la eliminación "hacia adelante" (triangulación).
        // se envía la matriz a Gauss.eliminacionGaussiana
        // convirtiéndola en una matriz triangular superior (llena de ceros bajo la diagonal).
        MetodoGauss.eliminacionGaussiana(matriz);

        // paso: despeje y sustitución "hacia atrás"
        // se pasa la matriz triangulada a 'Gauss.sustitucionRegresiva'.
        // calcula los valores de cada variable de abajo hacia arriba y retorna un arreglo con las respuestas
        double[] soluciones = MetodoGauss.sustitucionRegresiva(matriz);

        // paso 4: visualización de resultados
        System.out.println("Soluciones del sistema:");

        // bucle que recorre el vector de resultados elemento por elemento.
        for (int i = 0; i < soluciones.length; i++) {
            // (i + 1) adapta el índice de Java (que empieza en 0) a la notación x1, x2, x3.
            System.out.println("x" + (i + 1) + " = " + soluciones[i]);
        }
    }
}
