package stack.hard;

import java.util.Stack;

public class LargestRectangleinHistogram {

    public static int largestRectangleArea(int[] heights) {

        int minHeight = 0;
        int horizontalArea = 0;
        int rectArea = 0;

        Stack<int[]> stack = new Stack<>(); // height, index, maxArea

        for (int i = 0; i < heights.length; i++) {

            int currentHeight = heights[i];

            if (stack.isEmpty()) {
                minHeight = currentHeight;
                horizontalArea = minHeight * (i + 1);
                rectArea = horizontalArea;

                stack.push(
                        new int[] {
                                currentHeight, i, Math.max(currentHeight, Math.max(horizontalArea, rectArea)),
                                currentHeight
                        });
                continue;
            }

            int topHeight = stack.peek()[0];
            int topIndex = stack.peek()[1];
            int topArea = stack.peek()[2];
            int minStackheight = stack.peek()[3];

            minHeight = Math.min(minHeight, Math.min(currentHeight, topHeight));
            horizontalArea = minHeight * (i + 1);

            rectArea = Math.min(currentHeight,minStackheight) * (i - topIndex + 1);

            if (currentHeight <= topHeight) {
                stack.push(
                        new int[] {
                                currentHeight, i,
                                Math.max(topArea, Math.max(currentHeight, Math.max(horizontalArea, rectArea))),
                                Math.min(currentHeight, minStackheight),
                        });
            } else {

                int height = Math.min(currentHeight, minStackheight);

                if (stack.size() > 1) {
                    stack.clear();

                    height = currentHeight;

                }

                stack.push(
                        new int[] {
                                currentHeight, i,
                                Math.max(topArea, Math.max(currentHeight, Math.max(horizontalArea, rectArea))), height
                        });
            }

        }

        return stack.peek()[2];
    }

    


    @SuppressWarnings("unused")
    public static void main(String[] args) {

        int[] testCase = { 2, 1, 5, 6, 2, 3 };
        int[] testCase2 = { 2, 4 };
        int[] testCase3 = { 7,1,7,2,2,4 };

        System.out.println(largestRectangleArea(testCase3));

    }
}
