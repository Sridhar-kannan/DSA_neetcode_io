package arrays_and_hashing.easy;

import java.util.HashMap;

public class ContainsDuplicates {

    public static boolean hasDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            count = map.getOrDefault(nums[i], 0) + 1;

            if (count > 1) {
                return true;
            }
            map.put(nums[i], count);

        }

        return false;
    }

    public static void main(String[] args) {
        int[] testCase = { 1, 2, 3, 4 };

        System.out.println(hasDuplicate(testCase));
    }
}
