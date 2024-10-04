package stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStackSolution {

    public static void main(String[] args) {

        ArrayList<String> instructions = new ArrayList<>(List.of(
                "MinStack", "push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop", "push", "top",
                "getMin", "push", "top", "getMin", "pop", "getMin"));
        ArrayList<Integer> values = new ArrayList<>(List.of(
                0, 2147483646, 2147483646, 2147483647, 0, 0, 0, 0, 0, 0, 2147483647, 0, 0, -2147483648, 0, 0, 0, 0));

        MinStack obj = new MinStack();

        for (int i = 0; i < instructions.size(); i++) {

            switch (instructions.get(i)) {
                case "push":
                    obj.push(values.get(i));
                    break;

                case "getMin":
                    System.out.println(obj.getMin());
                    break;

                case "pop":
                    obj.pop();
                    break;
                default:
                    break;
            }
        }

    }
}

class MinStack {

    private Stack<ArrayList<Integer>> minStack;
    private int minNumber;

    public MinStack() {
        this.minStack = new Stack<>();
        this.minNumber = Integer.MAX_VALUE;
    }

    public void push(int val) {
        this.minNumber = Math.min(minNumber, val);
        ArrayList<Integer> e = new ArrayList<>();
        e.addFirst(val);
        e.addLast(minNumber);
        this.minStack.push(e);

    }

    public void pop() {

        this.minStack.pop();

    }

    public int top() {
        return this.minStack.peek().getFirst();
    }

    public int getMin() {
        return this.minStack.peek().getLast();
    }
}
