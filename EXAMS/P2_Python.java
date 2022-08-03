package ADVANCED.EXAMS.Exam_4_26_June_2021;

import java.util.Scanner;

public class P2_Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        String[][] matrix = new String[size][size];

        int pythonLen = 1;
        int countFood = 0;

        int pythonRow = 0;
        int pythonCol = 0;

        for (int r = 0; r < size; r++) {
            String[] rowInput = scanner.nextLine().split(" ");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = rowInput[c];

                if (matrix[r][c].equals("s")) {
                    pythonRow = r;
                    pythonCol = c;
                }

                if (matrix[r][c].equals("f")) {
                    countFood++;
                }
            }
        }

        boolean isDead = false;
        for (String command : commands) {
            matrix[pythonRow][pythonCol] = "*";
            switch (command) {
                case "up":
                    pythonRow--;
                    break;
                case "down":
                    pythonRow++;
                    break;
                case "left":
                    pythonCol--;
                    break;
                case "right":
                    pythonCol++;
                    break;
            }

            if (pythonRow < 0 || pythonRow >= matrix.length) {
                if (pythonRow < 0) { // излиза отгоре
                    pythonRow = matrix.length - 1;
                }
                if (pythonRow >= matrix.length) { //излиза отдолу
                    pythonRow = 0;
                }
            }

            if (pythonCol < 0 || pythonCol >= matrix.length) {
                if (pythonCol < 0) { // излиза отляво
                    pythonCol = matrix.length - 1;
                }
                if (pythonCol >= matrix.length) { //излиза отдясно
                    pythonCol = 0;
                }
            }

            if (countFood == 0){
                break;
            }

            if (matrix[pythonRow][pythonCol].equals("f")) {
                pythonLen++;
                countFood--;
            }

            if (matrix[pythonRow][pythonCol].equals("e")) {
                isDead = true;
                break;
            }
            matrix[pythonRow][pythonCol] = "s"; //в тази задача тази стъпка не е задължителна
        }

        if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (countFood == 0) {
            System.out.printf("You win! Final python length is %d", pythonLen);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }
    }
}
