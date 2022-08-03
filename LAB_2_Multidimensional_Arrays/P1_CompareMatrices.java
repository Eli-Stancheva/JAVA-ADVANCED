package ADVANCED.LAB_2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows1 = dimension1[0];
        int cols1 = dimension1[1];
        int[][] matrix1 = new int[rows1][cols1];

        for (int row = 0; row < rows1; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix1[row] = elements;
        }

        int[] dimension2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows2 = dimension2[0];
        int cols2 = dimension2[1];
        int[][] matrix2 = new int[rows2][cols2];

        for (int row = 0; row < rows2; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix2[row] = elements;
        }

        if(isEqual(matrix1, matrix2)){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean isEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int row = 0; row < matrix1.length; row++) {
            if (matrix1[row].length != matrix2[row].length) {
                return false;
            }
            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
