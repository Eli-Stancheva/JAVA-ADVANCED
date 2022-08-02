package ADVANCED.EXERCISE_2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P4_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = elements;
        }

        int max = Integer.MIN_VALUE;
        int[][] subMatrix = new int[3][3];
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                int sum = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2] +
                        matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2] +
                        matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];
                if (sum > max) {
                    max = sum;
                    subMatrix[0][0] = matrix[r][c];
                    subMatrix[0][1] = matrix[r][c + 1];
                    subMatrix[0][2] = matrix[r][c + 2];

                    subMatrix[1][0] = matrix[r + 1][c];
                    subMatrix[1][1] = matrix[r + 1][c + 1];
                    subMatrix[1][2] = matrix[r + 1][c + 2];

                    subMatrix[2][0] = matrix[r + 2][c];
                    subMatrix[2][1] = matrix[r + 2][c + 1];
                    subMatrix[2][2] = matrix[r + 2][c + 2];
                }
            }
        }
        System.out.println("Sum = " + max);
        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[1].length; col++) {
                System.out.print(subMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
