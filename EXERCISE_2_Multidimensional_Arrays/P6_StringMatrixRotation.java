package ADVANCED.EXERCISE_2_Multidimensional_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P6_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int rotationAngle = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        List<String> listForMatrix = new ArrayList<>();
        int maxLen = 0;
        while (true) {
            String string = scanner.nextLine();
            if (string.equals("END")) {
                break;
            }
            listForMatrix.add(string);
            if (string.length() > maxLen) {
                maxLen = string.length();
            }
        }

        int rows = listForMatrix.size();
        int cols = maxLen;

        char[][] matrix = new char[rows][cols];

        //пълним матрицата
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (c < listForMatrix.get(r).length()) {
                    matrix[r][c] = listForMatrix.get(r).charAt(c);
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }

        rotate(rotationAngle, rows, cols, matrix);
    }

    private static void rotate(int rotationAngle, int rows, int cols, char[][] matrix) {
        if (rotationAngle == 90) {
            for (int c = 0; c < cols; c++) {
                for (int r = rows - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 180) {
            for (int r = rows - 1; r >= 0; r--) {
                for (int c = cols - 1; c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 270) {
            for (int c = cols - 1; c >= 0; c--) {
                for (int r = 0; r < rows; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }
}
