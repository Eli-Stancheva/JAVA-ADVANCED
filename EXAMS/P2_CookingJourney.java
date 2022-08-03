package ADVANCED.EXAMS.Exam_5_14_April_2021;

import java.util.Scanner;

public class P2_CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int ourRow = 0;
        int ourCol = 0;

        int firstPillarRow = 0;
        int firstPillarCol = 0;

        int secondPillarRow = 0;
        int secondPillarCol = 0;

        boolean isFirstPillar = false;
        for (int r = 0; r < matrix.length; r++) {
            String[] inputRows = scanner.nextLine().split("");
            for (int c = 0; c < matrix.length; c++) {
                matrix[r][c] = inputRows[c];

                if (matrix[r][c].equals("S")) {
                    ourRow = r;
                    ourCol = c;
                }

                if (matrix[r][c].equals("P") && !isFirstPillar) {
                    firstPillarRow = r;
                    firstPillarCol = c;
                    isFirstPillar = true;
                }

                if (matrix[r][c].equals("P") && isFirstPillar) {
                    secondPillarRow = r;
                    secondPillarCol = c;
                }
            }
        }

        int money = 0;
        while (money < 50) {
            String commands = scanner.nextLine();
            int oldRow = ourRow;
            int oldCol = ourCol;

            if (commands.equals("left")) {
                //Движим се наляво
                ourCol--;
            } else if (commands.equals("right")) {
                //надясно
                ourCol++;
            } else if (commands.equals("up")) {
                //нагоре
                ourRow--;
            } else if (commands.equals("down")) {
                ourRow++;
                //надолу
            }

            if (ourRow < 0 || ourRow >= matrix.length || ourCol < 0 || ourCol >= matrix.length){
                matrix[oldRow][oldCol] = "-";
                break;
            }

            if (ourRow == firstPillarRow && ourCol == firstPillarCol){
                ourRow = secondPillarRow;
                ourCol = secondPillarCol;
                matrix[oldRow][oldCol] = "-";
                matrix[firstPillarRow][firstPillarCol] = "-";
                matrix[ourRow][ourCol] = "S";
            } else if (ourRow == secondPillarRow && ourCol == secondPillarCol){
                ourRow = firstPillarRow;
                ourCol = firstPillarCol;
                matrix[oldRow][oldCol] = "-";
                matrix[secondPillarRow][secondPillarCol] = "-";
                matrix[ourRow][ourCol] = "S";
            } else if (matrix[ourRow][ourCol].equals("-")){
                matrix[oldRow][oldCol] = "-";
                matrix[ourRow][ourCol] = "S";
            } else {
                money += Integer.parseInt(matrix[ourRow][ourCol]);
                matrix[oldRow][oldCol] = "-";
                matrix[ourRow][ourCol] = "S";
            }
        }

        if (money >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
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
