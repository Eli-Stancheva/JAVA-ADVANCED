package ADVANCED.LAB_3_Sets_And_Maps_Advanced;

import java.util.*;

public class P6_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopProduct = new TreeMap<>();


        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] info = input.split(", ");
            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            if (!shopProduct.containsKey(shop)) {
                shopProduct.put(shop, new LinkedHashMap<>());
            }
            shopProduct.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        for(Map.Entry<String, Map<String, Double>> entry : shopProduct.entrySet()){
            System.out.printf("%s->\n", entry.getKey());
            for(Map.Entry<String, Double> entry2 : entry.getValue().entrySet()){
                System.out.printf("Product: %s, Price: %.1f\n", entry2.getKey(), entry2.getValue());
            }
        }
    }
}
