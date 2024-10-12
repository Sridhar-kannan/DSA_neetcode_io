package stack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {


    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<ArrayList<Integer>> stack = new Stack<>();



        for (int i = 0; i < result.length; i++) {
            
            while (!stack.isEmpty() && stack.peek().getFirst() < temperatures[i]){
                ArrayList<Integer> cell = stack.pop();
                result[cell.getLast()] = i - cell.getLast();
                
            } 
            stack.push(
                new ArrayList<>(List.of(
                    temperatures[i],i
                ))
            );
        }

        return result;
    }

    public static int[] dailyTemperatures_n_sqr_solution(int[] temperatures){
        int[] result = new int[temperatures.length];
    
        for (int i = 0; i < result.length; i++) {
            int count = 1;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] <= temperatures[i]){
                    count++;
                }
                else {
                    result[i] = count;
                    break;
                }
            }
        }

        return result;
    }

    

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        int[] testCase1 = {30,38,30,36,35,40,28};
        int[] testCase2 = {22,21,20};

        System.out.println(
            Arrays.toString(testCase1) + "\n" + 
            Arrays.toString(dailyTemperatures(testCase1))
        );

    }

}
