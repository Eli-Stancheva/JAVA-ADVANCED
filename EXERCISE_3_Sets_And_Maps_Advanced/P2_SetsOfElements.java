package ADVANCED.EXERCISE_3_Sets_And_Maps_Advanced;

import java.util.*;

public class P2_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();
        List<Integer> listOfSet =  new ArrayList<>();

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstSetSize = input[0];
        int secondSetSize = input[1];

        for (int i = 0; i < firstSetSize; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            setOne.add(num);
        }
        for (int i = 0; i < secondSetSize; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            setTwo.add(num);
        }
        for (Integer integer : setOne) {
            for (Integer integer1 : setTwo) {
                if (integer.equals(integer1)){
                    listOfSet.add(integer);
                }
            }
        }
        for (Integer integer : listOfSet) {
            System.out.print(integer + " ");
        }
    }
}
