package ADVANCED.EXAMS.Exam_1_15_December_2021;

import java.util.Scanner;

public class P2_ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];

        //попълваме матрицата
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int parisRow = 0;
        int parisCow = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'P') {
                    parisRow = r;
                    parisCow = c;
                }
            }
        }

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            int spawnRow = Integer.parseInt(input[1]);
            int spawnCow = Integer.parseInt(input[2]);

            matrix[parisRow][parisCow] = '-';
            matrix[spawnRow][spawnCow] = 'S';

            switch (command) {
                case "up":
                    if (parisRow - 1 >=  0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < matrix.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCow - 1 >= 0) {
                        parisCow--;
                    }
                    break;
                case "right":
                    if (parisCow + 1 < matrix.length) {
                        parisCow++;
                    }
                    break;
            }
            //след преместване
            //1. намаляме енергията с 1
            energy--;
            //2. проверка дали е умрял
            if (energy <= 0) {
                parisDead(matrix, parisRow, parisCow);
                return;
            }
            //3. има ли спартанец там където се е преместил
            if (matrix[parisRow][parisCow] == 'S') {
                //3.1. победа над спартанеца -> намаляме енергията с 2
                energy -= 2;
                //3.2 проверка дали е умрял -> ако енергията <= 0
                if (energy <= 0) {
                    parisDead(matrix, parisRow, parisCow);
                    return;
                } else {
                    matrix[parisRow][parisCow] = '-';
                }
            } else if (matrix[parisRow][parisCow] == 'H'){  //4. има ли Елена там където се е преместил
                matrix[parisRow][parisCow] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                print(matrix);
                return;
            }
        }

    }

    private static void print(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void parisDead(char[][] matrix, int parisRow, int parisCow) {
        //Парис умира
        //1. там където е бил слагаме X
        matrix[parisRow][parisCow] = 'X';
        //2. отпечатване -> къде е умрял
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCow);
        //3. отпечатваме матрицата
        print(matrix);
    }
}
