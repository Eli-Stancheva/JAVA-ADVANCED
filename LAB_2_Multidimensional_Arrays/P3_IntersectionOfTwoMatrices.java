package ADVANCED.LAB_2_Multidimensional_Arrays;

import java.util.Scanner;

public class P3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = new char[rows][cols];
        char[][] matrix2 = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] elements = String.join("", scanner.nextLine().split(" ")).toCharArray();
            matrix1[row] = elements;
        }
        for (int row = 0; row < rows; row++) {
            char[] elements = String.join("", scanner.nextLine().split(" ")).toCharArray();
            matrix2[row] = elements;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix1[row][col] == matrix2[row][col]){
                    System.out.print(matrix1[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
