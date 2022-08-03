package ADVANCED.EXAMS.Exam_10_22_Feb_2020;

import java.util.Scanner;

public class P2_ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int playerRow = 0;
        int playerCol = 0;
        for (int r = 0; r < matrix.length; r++) {
            String[] rowInput = scanner.nextLine().split("");
            for (int c = 0; c < matrix.length; c++) {
                matrix[r][c] = rowInput[c];

                if (matrix[r][c].equals("f")) {
                    playerRow = r;
                    playerCol = c;
                }
            }
        }

        boolean isFinish = false;
        for (int i = 0; i < countCommands; i++) {
            int oldRow = playerRow;
            int oldCol = playerCol;
            matrix[oldRow][oldCol] = "-";

            String directions = scanner.nextLine();
            switch (directions) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            if (playerRow < 0 || playerRow >= matrix.length) {
                if (playerRow < 0) {
                    playerRow = matrix.length - 1;
                }
                if (playerRow >= matrix.length) {
                    playerRow = 0;
                }
            }

            if (playerCol < 0 || playerCol >= matrix.length) {
                if (playerCol < 0) {
                    playerCol = matrix.length - 1;
                }
                if (playerCol >= matrix.length) {
                    playerCol = 0;
                }
            }
            if (matrix[playerRow][playerCol].equals("F")) {
                matrix[playerRow][playerCol] = "f";
                isFinish = true;
                break;
            }
            if (matrix[playerRow][playerCol].equals("T")) {
                playerRow = oldRow;
                playerCol = oldCol;
            } else if (matrix[playerRow][playerCol].equals("B")) {
                if (playerRow > 0 && playerRow <= matrix.length - 1 && playerCol > 0 && playerCol < matrix.length) {
                    if (directions.equals("up")) {
                        playerRow--;
                    } else if (directions.equals("down")) {
                        playerRow++;
                    } else if (directions.equals("left")) {
                        playerCol--;
                    } else if (directions.equals("right")) {
                        playerCol++;
                    }
                } else {
                    if (directions.equals("up")) {
                        playerRow = matrix.length - 1;
                    } else if (directions.equals("down")) {
                        playerRow = 0;
                    } else if (directions.equals("left")) {
                        playerCol = matrix.length - 1;
                    } else if (directions.equals("right")) {
                        playerCol = 0;
                    }
                }
            }

            matrix[playerRow][playerCol] = "f";
        }
        if (isFinish) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        print(matrix);

    }

    private static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c] + "");
            }
            System.out.println();
        }
    }
}
