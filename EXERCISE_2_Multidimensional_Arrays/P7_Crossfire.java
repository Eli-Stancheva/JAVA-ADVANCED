package ADVANCED.EXERCISE_2_Multidimensional_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P7_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] rowColRadius = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = rowColRadius[0];
            int col = rowColRadius[1];
            int radius = rowColRadius[2];

            //destroy up, down
            for (int currR = row - radius; currR <= row + radius; currR++) {
                if (isValid(currR, col, matrix) && currR != row) {
                    matrix.get(currR).remove(col);
                }
            }

            //destroy left, right
            for (int currC = col + radius; currC >= col - radius; currC--) {
                if (isValid(row, currC, matrix)) {
                    matrix.get(row).remove(currC);
                }
            }

            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        print(matrix);
    }

    private static boolean isValid(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(number++);
            }
        }
    }

    private static void print(List<List<Integer>> matrix) {
        for (List<Integer> rows : matrix) {
            for (Integer element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
