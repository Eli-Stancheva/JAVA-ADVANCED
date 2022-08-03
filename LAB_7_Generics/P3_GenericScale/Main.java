package ADVANCED.LAB_7_Generics.P3_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("a", "c");
        System.out.println(scale.getHeavier());

        Scale<Integer> intScale = new Scale<>(1, 20);
        System.out.println(intScale.getHeavier());

    }
}
