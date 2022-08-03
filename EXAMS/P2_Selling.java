package ADVANCED.EXAMS.Exam_7_16_December_2020;

import java.util.Scanner;

public class P2_Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int meRow = 0;
        int meCol = 0;

        int firstPillarRow = 0;
        int firstPillarCol = 0;
        int secondPillarRow = 0;
        int secondPillarCol = 0;

        boolean isFirst = false;
        for (int r = 0; r < size; r++) {
            String[] input = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("S")) {
                    meRow = r;
                    meCol = c;
                }

                if (matrix[r][c].equals("O") && !isFirst) {
                    firstPillarRow = r;
                    firstPillarCol = c;
                    isFirst = true;
                }

                if (matrix[r][c].equals("O") && isFirst) {
                    secondPillarRow = r;
                    secondPillarCol = c;
                }
            }
        }

        int money = 0;
        while (money < 50) {
            int oldRow = meRow;
            int oldCol = meCol;

            String directions = scanner.nextLine();
            switch (directions) {
                case "up":
                    meRow--;
                    break;
                case "down":
                    meRow++;
                    break;
                case "left":
                    meCol--;
                    break;
                case "right":
                    meCol++;
                    break;
            }

            if (meRow < 0 || meRow >= matrix.length || meCol < 0 || meCol >= matrix.length) {
                matrix[oldRow][oldCol] = "-";
                break;
            }

            if (meRow == firstPillarRow && meCol == firstPillarCol) {
                meRow = secondPillarRow;
                meCol = secondPillarCol;
                matrix[oldRow][oldCol] = "-";
                matrix[firstPillarRow][firstPillarCol] = "-";
                matrix[meRow][meCol] = "S";
            } else if (meRow == secondPillarRow && meCol == secondPillarCol) {
                meRow = firstPillarRow;
                meCol = firstPillarCol;
                matrix[oldRow][oldCol] = "-";
                matrix[secondPillarRow][secondPillarCol] = "-";
                matrix[meRow][meCol] = "S";
            } else if (matrix[meRow][meCol].equals("-")) {
                matrix[oldRow][oldCol] = "-";
                matrix[meRow][meCol] = "S";
            } else {
                money += Integer.parseInt(matrix[meRow][meCol]);
                matrix[oldRow][oldCol] = "-";
                matrix[meRow][meCol] = "S";
            }
        }
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + money);
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

