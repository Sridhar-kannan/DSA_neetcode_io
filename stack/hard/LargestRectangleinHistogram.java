package stack.hard;

import java.util.Stack;

public class LargestRectangleinHistogram {

    public static int largestRectangleArea(int[] heights) {

        Stack<int[]> stack = new Stack<>(); // index , height
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            
            int start = i;

            while( !stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[] {start, heights[i]});
        }

        for(int[] pair : stack){
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }


        return maxArea;
    }




    @SuppressWarnings("unused")
    public static void main(String[] args) {

        int[] testCase1 = { 2, 1, 5, 6, 2, 3 };
        int[] testCase2 = { 2, 4 };
        int[] testCase3 = { 7,1,7,2,2,4 };

        System.out.println(largestRectangleArea(testCase1));

    }
}
