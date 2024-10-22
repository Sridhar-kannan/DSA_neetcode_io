package arrays_and_hashing.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoIntegerSum {
    public static int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int compliment = target - num;
            
            if(map.containsKey(compliment)){

                int idx = map.get(compliment);
                return new int[] { Math.min(i,idx), Math.max(i,idx)};

            }

            map.put(num, i);

        }

        return new int[] {0,0};


    }

    public static void main(String[] args) {
        
        int[][] testCase = {{3,4,5,6},{7}};

        System.out.println(
            Arrays.toString(twoSum(testCase[0], testCase[1][0]))
        );


    }
}
