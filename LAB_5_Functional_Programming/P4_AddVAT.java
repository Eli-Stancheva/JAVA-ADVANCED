package ADVANCED.LAB_5_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P4_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        UnaryOperator<Double> vat = price -> price * 1.2;
        Consumer<Double> print = e -> System.out.printf("%.2f\n", e);

        System.out.println("Prices with VAT: ");
        Arrays.stream(input)
                .map(Double::parseDouble)
                .map(vat)
                .forEach(print);
    }
}
