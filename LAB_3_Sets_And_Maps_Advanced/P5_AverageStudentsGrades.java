package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.util.*;

public class P5_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> map = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] student = scanner.nextLine().split(" ");
            String name = student[0];
            double grade = Double.parseDouble(student[1]);

            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(grade);
        }

        Map<String, Double> avgGradeMap = new TreeMap<>();
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Double> grade = entry.getValue();
            avgGradeMap.put(name, avg(grade));
        }

        map.entrySet().stream().forEach(e -> {
            System.out.printf("%s -> ", e.getKey());
            for (double g : e.getValue()) {
                System.out.printf("%.2f ", g);
            }
            System.out.printf("(avg: %.2f)\n", avgGradeMap.get(e.getKey()));
        });
    }

    private static double avg(List<Double> grade) {
        double sum = 0;
        for (double element : grade) {
            sum += element;
        }
        return sum / grade.size();
    }
}
