package ADVANCED.EXAMS.EXAM_12_19_February_2022;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        int whiteRow = 0;
        int whiteCol = 0;
        int blackRow = 0;
        int blackCol = 0;
        for (int r = 0; r < matrix.length; r++) {
            String[] input = scanner.nextLine().split("");
            for (int c = 0; c < matrix.length; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("w")) {
                    whiteRow = r;
                    whiteCol = c;
                }

                if (matrix[r][c].equals("b")) {
                    blackRow = r;
                    blackCol = c;
                }
            }
        }

        while (true) {
            if (isValidIndex(whiteRow - 1, whiteCol - 1, matrix) && matrix[whiteRow - 1][whiteCol - 1].equals("b")) {
                    String position = SetPosition(whiteRow - 1, whiteCol - 1, matrix);
                    System.out.printf("Game over! White capture on %s.", position);
                    break;
            } else if (isValidIndex(whiteRow - 1, whiteCol + 1, matrix) && matrix[whiteRow - 1][whiteCol + 1].equals("b")) {
                    String position = SetPosition(whiteRow - 1, whiteCol + 1, matrix);
                    System.out.printf("Game over! White capture on %s.", position);
                    break;
            } else {
                matrix[whiteRow][whiteCol] = "-";
                whiteRow--;
                matrix[whiteRow][whiteCol] = "w";
                if (whiteRow == 0) {
                    String position = SetPosition(whiteRow, whiteCol, matrix);
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.", position);
                    break;
                }
            }


            if (isValidIndex(blackRow + 1, blackCol - 1, matrix) && matrix[blackRow + 1][blackCol - 1].equals("w")) {
                    String position = SetPosition(blackRow + 1, blackCol - 1, matrix);
                    System.out.printf("Game over! Black capture on %s.", position);
                    break;
            } else if (isValidIndex(blackRow + 1, blackCol + 1, matrix) && matrix[blackRow + 1][blackCol + 1].equals("w")) {
                    String position = SetPosition(blackRow + 1, blackCol + 1, matrix);
                    System.out.printf("Game over! Black capture on %s.", position);
                    break;
            } else {
                matrix[blackRow][blackCol] = "-";
                blackRow++;
                matrix[blackRow][blackCol] = "b";
                if (blackRow == matrix.length - 1) {
                    String position = SetPosition(blackRow, blackCol, matrix);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s.", position);
                    break;
                }
            }
        }
    }

    private static String SetPosition(int r, int c, String[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = matrix.length; i >= 0; i--) {
            if (c == i) {
                sb.append((char) (i + 97));
            }
        }

        int counter = 8;
        for (int i = 0; i < 8; i++) {
            if (r == i) {
                sb.append(counter);
            }
            counter--;
        }
        return sb.toString();
    }

    public static boolean isValidIndex(int r, int c, String[][] matrix) {
        return r >= 0 && r <= matrix.length && c >= 0 && c <= matrix.length;
    }
}
