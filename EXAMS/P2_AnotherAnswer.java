package ADVANCED.EXAMS.Exam_10_22_Feb_2020;

import java.util.Scanner;

public class P2_AnotherAnswer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRows = Integer.parseInt(scanner.nextLine());
        int numberCommands = Integer.parseInt(scanner.nextLine());

        String[][] roadMatrix = readMatrix(numRows, scanner);

        int carRow = 0;
        int carCol = 0;

        for (int row = 0; row < roadMatrix.length; row++) {
            boolean stop = false;
            for (int col = 0; col < roadMatrix[row].length; col++) {
                if (roadMatrix[row][col].equals("f")) {
                    stop = true;
                    carRow = row;
                    carCol = col;
                    break;
                }
            }
            if (stop) {
                break;
            }
        }
        boolean toFinal = false;

        for (int i = 0; i < numberCommands; i++) {
            String command = scanner.nextLine();
            roadMatrix[carRow][carCol] = "-";
            switch (command) {
                case "up":
                    int lastRow = carRow;
                    //dali e v granici
                    carRow = chekForBounds(roadMatrix, carRow, carCol, command);
                    if (roadMatrix[carRow][carCol].equals("B")) {
                        carRow = chekForBounds(roadMatrix, carRow, carCol, command);
                    } else if (roadMatrix[carRow][carCol].equals("T")) {
                        carRow = lastRow;

                    } else if (roadMatrix[carRow][carCol].equals("F")) {
                        toFinal = true;
                    }
//                    roadMatrix[lastRow][carCol] = "-";
//                    roadMatrix[carRow][carCol] = "f";
                    break;
                case "down":
                    int lastRow1 = carRow;
                    carRow = chekForBounds(roadMatrix, carRow, carCol, command);
                    if (roadMatrix[carRow][carCol].equals("B")) {
                        carRow = chekForBounds(roadMatrix, carRow, carCol, command);
                    } else if (roadMatrix[carRow][carCol].equals("T")) {
                        carRow = lastRow1;
                    } else if (roadMatrix[carRow][carCol].equals("F")) {
                        toFinal = true;
                    }
//                    roadMatrix[lastRow1][carCol] = "-";
//                    roadMatrix[carRow][carCol] = "f";
                    break;

                case "left":
                    int lastCol = carCol;
                    carCol = chekForBounds(roadMatrix, carRow, carCol, command);
                    if (roadMatrix[carRow][carCol].equals("B")) {
                        carCol = chekForBounds(roadMatrix, carRow, carCol, command);
                    } else if (roadMatrix[carRow][carCol].equals("T")) {
                        carCol = lastCol;
                    } else if (roadMatrix[carRow][carCol].equals("F")) {
                        toFinal = true;
                    }
//                    roadMatrix[carRow][lastCol] = "-";
//                    roadMatrix[carRow][carCol] = "f";
                    break;
                case "right":
                    int lastCol1 = carCol;
                    carCol = chekForBounds(roadMatrix, carRow, carCol, command);
                    if (roadMatrix[carRow][carCol].equals("B")) {
                        carCol = chekForBounds(roadMatrix, carRow, carCol, command);
                    } else if (roadMatrix[carRow][carCol].equals("T")) {
                        carCol = lastCol1;
                    } else if (roadMatrix[carRow][carCol].equals("F")) {
                        toFinal = true;
                    }
//                    roadMatrix[carRow][lastCol1] = "-";
//                    roadMatrix[carRow][carCol] = "f";
                    break;
            }


            ////
            if (roadMatrix[carRow][carCol].equals("F")) {
                toFinal = true;
            }

            roadMatrix[carRow][carCol] = "f";
            //////////

            if (toFinal) {
                break;
            }
        }
        if (toFinal) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(roadMatrix);
    }


    public static String[][] readMatrix(int rows, Scanner scanner) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
        return matrix;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public static int chekForBounds(String[][] matrix, int currentRow, int currentCol, String command) {
        switch (command) {
            case "up":
                if (currentRow - 1 < 0) {
                    currentRow = matrix.length - 1;
                } else {
                    currentRow = currentRow - 1;
                }
                return currentRow;
            case "down":
                if (currentRow + 1 >= matrix.length) {
                    currentRow = 0;
                } else {
                    currentRow = currentRow + 1;
                }
                return currentRow;
            case "right":
                if (currentCol + 1 >= matrix[currentRow].length) {
                    currentCol = 0;
                } else {
                    currentCol = currentCol + 1;
                }
                return currentCol;

            case "left":
                if (currentCol - 1 < 0) {
                    currentCol = matrix[currentRow].length - 1;
                } else {
                    currentCol = currentCol - 1;
                }
                return currentCol;
        }
        return 0;
    }
}

