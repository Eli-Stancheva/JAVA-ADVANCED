package ADVANCED.EXERCISE_7_Generics.Generic_Box;

import ADVANCED.EXERCISE_7_Generics.Generic_Box.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //задача 1
        /*
        Box<String> stringBox = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            stringBox.add(string);
        }
        System.out.println(stringBox);
        */

        //задача 2
       /*
        Box<Integer> integerBox = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int integer = Integer.parseInt(scanner.nextLine());
            integerBox.add(integer);
        }
        System.out.println(integerBox);
        */

        //задача 3
        /*
        Box<String> stringBox = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            stringBox.add(string);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        stringBox.swap(firstIndex, secondIndex);
        System.out.println(stringBox.toString());
        */

        //задача 4
        /*
        Box<Integer> integerBox = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int integer = Integer.parseInt(scanner.nextLine());
            integerBox.add(integer);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        integerBox.swap(firstIndex, secondIndex);
        System.out.println(integerBox.toString());
        */

        //задача 5
        /*
        Box<String> stringBox = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            stringBox.add(string);
        }
        String toCompare = scanner.nextLine();
        System.out.println(stringBox.countElementsGreaterThan(toCompare));
        */

        //задача 6

        Box<Double> doubleBox = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            double dou = Double.parseDouble(scanner.nextLine());
            doubleBox.add(dou);
        }
        double toCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(doubleBox.countElementsGreaterThan(toCompare));
    }
}
