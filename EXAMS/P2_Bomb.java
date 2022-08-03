package ADVANCED.EXAMS.Exam_6_20_February_2021;

import java.util.Scanner;

public class P2_Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        String[][] matrix = new String[size][size];

        int sapperRow = 0;
        int sapperCol = 0;

        int countBombs = 0;
        for (int r = 0; r < matrix.length; r++) {
            String[] rowInput = scanner.nextLine().split(" ");
            for (int c = 0; c < matrix.length; c++) {
                matrix[r][c] = rowInput[c];

                if (matrix[r][c].equals("s")) {
                    sapperRow = r;
                    sapperCol = c;
                }

                if (matrix[r][c].equals("B")){
                    countBombs++;
                }
            }
        }

        boolean isEnd = false;
        for (String command : commands) {
            int oldRow = sapperRow;
            int oldCol = sapperCol;
            matrix[sapperRow][sapperCol] = "+";
            switch (command) {
                case "up":
                    sapperRow--;
                    break;
                case "down":
                    sapperRow++;
                    break;
                case "left":
                    sapperCol--;
                    break;
                case "right":
                    sapperCol++;
                    break;
            }

            if (sapperRow < 0 || sapperRow >= matrix.length){
                sapperRow = oldRow;
            }

            if (sapperCol < 0 || sapperCol >= matrix.length){
                sapperCol = oldCol;
            }

            if (matrix[sapperRow][sapperCol].equals("B")){
                System.out.println("You found a bomb!");
                countBombs--;
            }

            if (matrix[sapperRow][sapperCol].equals("e")){
                isEnd = true;
                break;
            }

            if (countBombs == 0){
                break;
            }
            matrix[sapperRow][sapperCol] = "s";
        }
        if (isEnd){
            System.out.printf("END! %d bombs left on the field", countBombs);
        } else if (countBombs == 0){
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countBombs, sapperRow, sapperCol);
        }
    }
}
