package programagauss;

// clase que agrupa los algoritmos de resolución
public class MetodoGauss {

    // paso 1: eliminacion "hacia adelante" (la triangulación superior)
    // recibe la matriz aumentada y la modifica
    public static void eliminacionGaussiana(double[][] matriz) {
        // n es el número de ecuaciones (las filas). en el ejemplo, n =3
        int n = matriz.length;

        // bucle i (el pivote): recorre cada fila pivote y columna de referencia (de 0 a n-1)
        for (int i = 0; i < n; i++) {

            // bucle j (las filas inferiores): recorre las filas que están por debajo del pivote
            // para eliminar los elementos debajo de la diagonal principal
            for (int j = i + 1; j < n; j++) {

                // calcula el multiplicador necesario para anular matriz[j][i]
                // factor = elemento_a_eliminar / elemento_pivote
                double factor = matriz[j][i] / matriz[i][i];

                // bucle k (operación por fila): aplica resta fila[j] = fila[j] - factor * fila[i]
                // va desde la columna 'i' hasta 'n' (la última columna con el término independiente)
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }

    // paso 2: la sustitucion "hacia atras" (el cálculo de incógnitas)
    // recibe la matriz ya triangulada y devuelve ls solución (x1, x2, etc)
    public static double[] sustitucionRegresiva(double[][] matriz) {
        int n = matriz.length;

        // se guardan las soluciones finales: x[0], x[1]...
        double[] x = new double[n];

        // bucle i: recorre las ecuaciones de abajo hacia arriba
        for (int i = n - 1; i >= 0; i--) {
            // variable auxiliar para sumar términos de las incógnitas ya calculadas
            double suma = 0;

            // bucle j: suma los productos de los coeficientes por las variables ya conocidas a la derecha
            // para la última ecuación no se ejecuta porque j = n no cumple j < n
            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * x[j];
            }

            // despeje de la x[i]
            // x[i] = (término_independiente - suma_variables_conocidas) / coeficiente_diagonal
            // matriz[i][n] es el valor del término independiente en la columna aumentada
            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        // retorna el arreglo con los valores resueltos
        return x;
    }
}
