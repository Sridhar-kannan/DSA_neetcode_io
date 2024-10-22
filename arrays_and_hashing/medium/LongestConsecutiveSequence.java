package arrays_and_hashing.medium;

import java.util.HashSet;

public class LongestConsecutiveSequence{

    public static int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 1;
        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            
            int num = nums[i];
            int prev = num-1;

            if(! set.contains(prev)){
                while (set.contains(num+1)){
                    result++;
                    num++;
                }
            }
            longest = Math.max(longest, result);
            result = 1;

        }

        return longest;
    }

    public static void main(String[] args) {
        

        int[] testCase = {2,20,4,10,3,4,5};

        System.out.println(
            longestConsecutive(testCase)
        );
    }
}