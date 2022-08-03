package ADVANCED.LAB_2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P5_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = elements;
        }

        int max = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > max) {
                    max = sum;
                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col + 1];
                    subMatrix[1][0] = matrix[row + 1][col];
                    subMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }
        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[1].length; col++) {
                System.out.print(subMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
    }
}
