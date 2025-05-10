package sliding_window.medium;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AAABABB";
        int k=1;
        
        Solution2 solution = new Solution2();

        System.out.println(
            solution.characterReplacement(s, k)
        );

    }
}

class Solution2 {
    public int characterReplacement(String s, int k) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max=0;

        for(int right=0; right < s.length(); right++){
            
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)+1);
            max = Math.max(max, map.get(s.charAt(right)));
            if (((right-left+1) - max) > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            } 
            result = Math.max(result, right-left+1);
        }


        return result;
    }
}

// AAABABB
// 

