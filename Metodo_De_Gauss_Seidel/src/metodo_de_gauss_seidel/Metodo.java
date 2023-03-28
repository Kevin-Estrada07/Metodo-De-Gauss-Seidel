/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodo_de_gauss_seidel;

import java.util.Scanner;

/**
 *
 * @author estra
 */
public class Metodo {

    String letra[] = {"a", "b", "c", "z"};
    Scanner leer = new Scanner(System.in);

    public void encabezado() {
        System.out.println("--------------------------------------------------");
        System.out.println("n |    X1    |    X2    |    X3    |    EaX1    |    EaX2    |    EaX3    ");
    }

    public void Inicia() {
        int noValores = 4;
        double ecuaciones[][] = Ecuaciones(noValores);
        encabezado();
        Resolucion(ecuaciones);
    }

    public double[][] Ecuaciones(int noValores) {
        double ecu[][] = new double[3][noValores];
        for (int i = 0; i < 3; i++) {
            System.out.println("Ecuacion " + (i + 1));
            for (int j = 0; j < noValores; j++) {
                System.out.print(letra[j] + ": ");
                ecu[i][j] = leer.nextDouble();
            }
        }
        return ecu;
    }

    public void Resolucion(double ecu[][]) {
        double X = 0;
        double Y = 0;
        double Z = 0;

        for (int i = 0; i < 10; i++) {

            double x = X;
            double y = Y;
            double z = Z;
            
            X = (ecu[0][3] - (ecu[0][1] * Y) - (ecu[0][2] * Z)) / ecu[0][0];
            Y = (ecu[1][3] - (ecu[1][0] * X) - (ecu[1][2] * Z)) / ecu[1][1];
            Z = (ecu[2][3] - (ecu[2][0] * X) - (ecu[2][1] * Y)) / ecu[2][2];

            double EaX = ((X - x) / X) * 100;
            double EaY = ((Y - y) / Y) * 100;
            double EaZ = ((Z - z) / Z) * 100;

            System.out.println(+(i + 1) + "  |  " + String.format("%.4f", X) + "  |  " + String.format("%.4f", Y) + "  |  " + String.format("%.4f", Z) + "  |  " + String.format("%.4f", EaX) + "  |  " + String.format("%.4f", EaY) + "  |  " + String.format("%.4f", EaZ));

        }
    }
}
