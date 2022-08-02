package ADVANCED.EXERCISE_2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P5_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (!validate(command, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                String[] commandParts = command.split(" ");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String first = matrix[row1][col1];
                String second = matrix[row2][col2];

                matrix[row1][col1] = second;
                matrix[row2][col2] = first;

                print(matrix, rows, cols);
            }
            command = scanner.nextLine();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String[] inputRows = scanner.nextLine().split(" ");
            matrix[r] = inputRows;
        }
    }

    private static void print(String[][] matrix, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validate(String command, int rows, int cols) {
        String[] commandParts = command.split(" ");

        if (commandParts.length != 5) {
            return false;
        }
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 >= rows || row1 < 0 || row2 >= rows || row2 < 0 || col1 >= cols || col1 < 0 || col2 >= cols || col2 < 0) {
            return false;
        }
        return true;
    }
}
