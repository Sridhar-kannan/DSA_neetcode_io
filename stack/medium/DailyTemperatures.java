package stack.medium;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<ArrayList<Integer>> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek().get(0) < temperatures[i]) {
                ArrayList<Integer> top = stack.pop();
                result[top.get(1)] = i-top.get(1);
            }
            stack.push(
                    new ArrayList<>(List.of(
                            temperatures[i], i)));

        }

        return result;
    }

    public static int[] dailyTemperaturesFasterSolution(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int max = Integer.MIN_VALUE;

        for (int i =  temperatures.length-1; i >=0; i--) {

            if (max < temperatures[i]){
                max = temperatures[i];
                continue;
            }

            int days = 1;
            while(temperatures[i+days] < temperatures[i]){
                days += result[i+days];
            }

            result[i] = days;

        }


        return result;

    }

    

    public static void main(String[] args) {

        int[] testCase = { 30,40,50,60 };

        System.out.println(
                Arrays.toString(dailyTemperaturesFasterSolution(testCase)));
    }
}
