package two_pointers.hard;

import java.util.Arrays;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int total_water = 0;

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLR = new int[height.length];
        int[] water = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = i == 0 ? 0 : Math.max(maxLeft[i - 1], height[i - 1]);
        }

        for (int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = i == (height.length - 1) ? 0 : Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        for (int i = 0; i < height.length; i++) {
            water[i] = Math.max(minLR[i] - height[i], 0);
            total_water += Math.max(minLR[i] - height[i], 0);
        }

        System.out.println(
                "left ==> " + Arrays.toString(maxLeft) + "\nRight ==> " + Arrays.toString(maxRight) + "\nMinLR ==> "
                        + Arrays.toString(minLR) + "\nWater ==> " + Arrays.toString(water));

        return total_water;
    }

    public static void main(String[] args) {

        int[] heights = { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 };

        System.out.println(
                trap(heights));

    }

}