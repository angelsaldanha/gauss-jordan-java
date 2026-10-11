package programagaussjordan;

// reutilizacion de codigo: importamos la clase del paquete anterior
import programagauss.MetodoGauss;

public class MetodoGaussJordan {

    public static void resolverGaussJordan(double[][] matriz) {
        int n = matriz.length;

        // en lugar de volver a programar la triangulación inferior, invocamos el metodo ya existente
        // deja ceros debajo de la diagonal principal
        MetodoGauss.eliminacionGaussiana(matriz);

        // recorremos los renglones de abajo hacia arriba (desde n-1 hasta 0)
        for (int i = n - 1; i >= 0; i--) {

            // normalización del pivote:
            // Ggardamos el valor actual del pivote diagonal matriz[i][i]
            double pivote = matriz[i][i];

            // dividimos toda la fila entre el pivote para convertir matriz[i][i] en 1
            // se actualiza desde la columna i hasta n (incluyendo el término independiente)
            for (int k = i; k <= n; k++) {
                matriz[i][k] /= pivote;
            }

            // El "barrido" hacia arriba:
            // se hacen ceros en las filas superiores (j va desde i-1 hacia arriba hasta la fila 0)
            for (int j = i - 1; j >= 0; j--) {
                // factor para anular el elemento que está arriba del pivote actual
                double factor = matriz[j][i];

                // Fila[j] = Fila[j] - factor * Fila[i]
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
        // al terminar estos ciclos, la parte izquierda de la matriz es la matriz identidad
    }

    // a diferencia de Gauss simple, aquí no se necesita sustitución regresiva ni despejes
    // los resultados ya están listos en la última columna (matriz[i][n]).
    public static double[] extraerSoluciones(double[][] matriz) {
        int n = matriz.length;
        double[] x = new double[n];

        for (int i = 0; i < n; i++) {
            // como 1 * xi = matriz[i][n], se toma el valor de forma directa
            x[i] = matriz[i][n];
        }

        return x;
    }
}
