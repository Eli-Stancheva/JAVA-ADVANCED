package ADVANCED.EXERCISE_2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P2_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];
        char letter = 'a';

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String palindromes = "" + letter + (char)(letter + c) + letter;
                matrix[r][c] = palindromes;
            }
            letter = (char)(letter + 1);
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
