package ADVANCED.EXAMS.Exam_2_23_October_2021;

import java.util.Scanner;

public class P2_MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int mouseRow = 0;
        int mouseCol = 0;
        for (int r = 0; r < size; r++) {
            String[] rows = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = rows[c];

                if (matrix[r][c].equals("M")) {
                    mouseRow = r;
                    mouseCol = c;
                }
            }
        }

        int eatenCheese = 0;
        String commands = scanner.nextLine();
        while (!commands.equals("end")) {
            matrix[mouseRow][mouseCol] = "-";

            switch (commands) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }

            //преди да поставим мишката на новото и място -> проверка на ред и колоната
            if (mouseRow < 0 || mouseRow >= matrix.length || mouseCol < 0 || mouseCol >= matrix.length) {
                System.out.println("Where is the mouse?");
                break;
            }

            //проверим мястото, на което ще отиде мишката
            if (matrix[mouseRow][mouseCol].equals("c")) {
                eatenCheese++;
            } else if (matrix[mouseRow][mouseCol].equals("B")) {
                //продължава на следващата итерация, пак същата команда, която е подадена, но с вече актуализираните ROW и Col
                continue;
            }
            matrix[mouseRow][mouseCol] = "M";
            commands = scanner.nextLine();
        }
        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - eatenCheese);
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
