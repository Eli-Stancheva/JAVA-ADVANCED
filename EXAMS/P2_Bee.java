package ADVANCED.EXAMS.Exam_8_19_August_2020;

import java.util.Scanner;

public class P2_Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int beeRow = 0;
        int beeCol = 0;
        for (int r = 0; r < size; r++) {
            String[] inputRows = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = inputRows[c];

                if (matrix[r][c].equals("B")) {
                    beeRow = r;
                    beeCol = c;
                }
            }
        }

        boolean isOut = false;
        int pollinatesFlower = 0;
        String commend = scanner.nextLine();
        while (!commend.equals("End")) {
            matrix[beeRow][beeCol] = "."; // starata poziciq ni e weche .

            switch (commend) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }

            if (beeRow < 0 || beeRow >= matrix.length || beeCol < 0 || beeCol >= matrix.length) {
                isOut = true;
                break;
            }

            if (matrix[beeRow][beeCol].equals("f")) {
                pollinatesFlower++;
            } else if (matrix[beeRow][beeCol].equals("O")) {
                continue;
            }

            matrix[beeRow][beeCol] = "B";
            commend = scanner.nextLine();
        }

        if (isOut) {
            System.out.println("The bee got lost!");
        }

        if (pollinatesFlower < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinatesFlower);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatesFlower);
        }
        print(matrix);
    }

    private static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
