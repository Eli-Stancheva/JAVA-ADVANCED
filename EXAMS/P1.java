package ADVANCED.EXAMS.EXAM_12_19_February_2022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vowels = scanner.nextLine().split(" ");
        String[] consonant = scanner.nextLine().split(" ");

        ArrayDeque<String> queueVowel = new ArrayDeque<>();
        ArrayDeque<String> stackConsonant = new ArrayDeque<>();

        for (String vowel : vowels) {
            queueVowel.offer(vowel);
        }

        for (String cons : consonant) {
            stackConsonant.push(cons);
        }

        List<String> listWord = new ArrayList<>();
        String pear = "pear";
        String flour = "flour";
        String pork = "pork";
        String olive = "olive";
        listWord.add(pear);
        listWord.add(flour);
        listWord.add(pork);
        listWord.add(olive);

        int words = 0;
        while (!stackConsonant.isEmpty()) {
            String currVowel = queueVowel.peek();
            String currCons = stackConsonant.peek();

            if (pear.contains(currVowel)) {
                pear = pear.replace(currVowel, "");
            }
            if (pear.contains(currCons)) {
                pear = pear.replace(currCons, "");
            }


            if (flour.contains(currVowel)) {
                flour = flour.replace(currVowel, "");
            }
            if (flour.contains(currCons)) {
                flour = flour.replace(currCons, "");
            }


            if (pork.contains(currVowel)) {
                pork = pork.replace(currVowel, "");
            }
            if (pork.contains(currCons)) {
                pork = pork.replace(currCons, "");
            }


            if (olive.contains(currVowel)) {
                olive = olive.replace(currVowel, "");
            }
            if (olive.contains(currCons)) {
                olive = olive.replace(currCons, "");
            }

            stackConsonant.pop();
            queueVowel.poll();
            queueVowel.offer(currVowel);
        }
        List<String> finalWords = new ArrayList<>();

        if (pear.equals("")) {
            words++;
        } else {
            listWord.remove("pear");
        }

        if (flour.equals("")) {
            words++;
        } else {
            listWord.remove("flour");
        }

        if (pork.equals("")) {
            words++;
        } else {
            listWord.remove("pork");
        }
        if (olive.equals("")) {
            words++;
        } else {
            listWord.remove("olive");
        }

        System.out.println("Words found: " + words);
        for (String string : listWord) {
            System.out.println(string);
        }
    }
}
