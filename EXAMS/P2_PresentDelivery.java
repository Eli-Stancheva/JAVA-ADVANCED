package ADVANCED.EXAMS.EXAM_11_17_December_2019;

import java.util.Scanner;

public class P2_PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int present = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int santaRow = 0;
        int santaCol = 0;
        int niceKids = 0;
        int giftedKids = 0;
        for (int r = 0; r < size; r++) {
            String[] input = scanner.nextLine().split(" ");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = input[c];

                if (matrix[r][c].equals("S")) {
                    santaRow = r;
                    santaCol = c;
                }

                if (matrix[r][c].equals("V")) {
                    niceKids++;
                }
            }
        }

        String commands = scanner.nextLine();
        while (!commands.equals("Christmas morning")) {
            matrix[santaRow][santaCol] = "-";
            switch (commands) {
                case "up":
                    santaRow--;
                    break;
                case "down":
                    santaRow++;
                    break;
                case "left":
                    santaCol--;
                    break;
                case "right":
                    santaCol++;
                    break;
            }

            if (santaRow < 0 || santaRow >= matrix.length || santaCol < 0 || santaCol >= matrix.length) {
                break;
            }

            if (matrix[santaRow][santaCol].equals("V")) {
                present--;
                niceKids--;
                giftedKids++;
                matrix[santaRow][santaCol] = "-";
            } else if (matrix[santaRow][santaCol].equals("X")) {
                matrix[santaRow][santaCol] = "-";
            } else if (matrix[santaRow][santaCol].equals("C")) {
                String[] cells = new String[4];
                String up = matrix[santaRow - 1][santaCol];
                String down = matrix[santaRow + 1][santaCol];
                String left = matrix[santaRow][santaCol - 1];
                String right = matrix[santaRow][santaCol + 1];

                cells[0] = up;
                cells[1] = down;
                cells[2] = left;
                cells[3] = right;

                for (String cell : cells) {
                    if (cell.equals("V") || cell.equals("X")) {
                        if (cell.equals("V")) {
                            niceKids--;
                        }
                        giftedKids++;
                        present--;

                        if (present <= 0) {
                            break;
                        }
                    }
                }
                matrix[santaRow - 1][santaCol] = "-";
                matrix[santaRow + 1][santaCol] = "-";
                matrix[santaRow][santaCol - 1] = "-";
                matrix[santaRow][santaCol + 1] = "-";
            }
            matrix[santaRow][santaCol] = "S";

            if (present <= 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }
            commands = scanner.nextLine();
        }
        print(matrix);
        if (niceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", giftedKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKids);
        }
    }

    private static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
