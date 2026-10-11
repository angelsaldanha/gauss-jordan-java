package programagaussjordan;

public class Main {

    public static void main(String[] args) {

        // la matriz aumentada del sistema
        double[][] matriz = Matriz.defmatriz();

        // usamos gauss-jordan
        MetodoGaussJordan.resolverGaussJordan(matriz);

        // usamos las respuestas de la columna aumentada
        double[] soluciones = MetodoGaussJordan.extraerSoluciones(matriz);

        System.out.println("Soluciones del sistema (Método de Gauss-Jordan):");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.println("x" + (i + 1) + " = " + soluciones[i]);
        }
    }
}
