package ADVANCED.EXERCISE_1_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P5_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> opened = new ArrayDeque<>();
        String input = scanner.nextLine();

        boolean areBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currBracket = input.charAt(i);

            if (currBracket == '(' || currBracket == '{' || currBracket == '['){
                opened.push(currBracket);
            } else if (currBracket == ')' || currBracket == '}' || currBracket == ']'){
                if (opened.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char last = opened.pop();
                if (last == '(' && currBracket == ')'){
                    areBalanced = true;
                } else if (last == '{' && currBracket == '}'){
                    areBalanced = true;
                } else if (last == '[' && currBracket == ']'){
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
