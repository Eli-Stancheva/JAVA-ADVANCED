package ADVANCED.EXERCISE_8_Iterators_Comparators.P3_StackIterator;

import java.util.*;

public class MyStack implements Iterable<Integer> {
    ArrayDeque<Integer> stack;

    public MyStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int element) {
        this.stack.push(element);
    }

    public void push(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            this.stack.push(elements[i]);
        }
    }

    public void pop() {
        if (this.stack.isEmpty()) {
            System.out.println("No elements");
            return;
        }
        this.stack.pop();
    }

    @Override
    public Iterator<java.lang.Integer> iterator() {
        return new Iterator<Integer>() {
            private ArrayDeque<Integer> tempStack = new ArrayDeque<>(stack);

            @Override
            public boolean hasNext() {
                return !tempStack.isEmpty();
            }

            @Override
            public Integer next() {
                return tempStack.pop();
            }
        };
    }
}
