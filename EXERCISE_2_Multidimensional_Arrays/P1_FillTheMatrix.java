package ADVANCED.EXERCISE_2_Multidimensional_Arrays;

import java.util.Scanner;

public class P1_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int dimension = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimension][dimension];

        if (pattern.equals("A")) {
            patternA(matrix);
        } else if (pattern.equals("B")) {
            patternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void patternA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[1].length; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }

    private static void patternB(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix[1].length; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }

            } else {
                for (int row = matrix[1].length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[1].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
