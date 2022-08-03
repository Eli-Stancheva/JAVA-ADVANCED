package ADVANCED.LAB_2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = elements;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row] == matrix[col]) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        //for (int row = 0; row < n; row++) {
        //    System.out.print(matrix[row][row] + " ");
        //}
        System.out.println();
        for (int col = 0; col < n; col++) {
            System.out.print(matrix[n - 1 - col][col] + " ");
        }
    }
}
