package ADVANCED.EXERCISE_2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P3_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimension][dimension];
        for (int r = 0; r < dimension; r++) {
            int[] rowLines = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = rowLines;
        }

        int firstSum = primaryDiagonal(matrix);
        int secondSum = secondaryDiagonal(matrix);
        System.out.println(Math.abs(firstSum - secondSum));
    }

    private static int primaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r] == matrix[c]) {
                    sum += matrix[r][c];
                }
            }
        }
        return sum;
    }

    private static int secondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (c == matrix.length - r - 1){
                    sum += matrix[r][c];
                }
            }
        }
        return sum;
    }
}
