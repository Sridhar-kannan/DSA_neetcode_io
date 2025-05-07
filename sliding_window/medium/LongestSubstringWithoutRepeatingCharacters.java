package sliding_window.medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "au";

        System.out.println(
                "answer = " + Solution.lengthOfLongestSubstring(s));
    }

}

/*
 * 
 * Input: s = "zxyzxyz"
 * 
 * Output: 3
 * 
 * ---------------------------------
 * 
 * Input: s = "xxxx"
 * 
 * Output: 1
 * 
 * pwwkew
 * 
 */

class Solution {

    

    public static int lengthOfLongestSubstring(String s) {
            if (s.length() == 0){
                return 0;
            }
            if (s.length() < 2 ){
                return 1;
            }

            int result=0;
            int[] lengths = new int[s.length()];
            Arrays.fill(lengths,1);
            HashSet<Character> set = new HashSet<>();
            

            int l=0,r=1;
            while(l < s.length()-1){
                
                char left = s.charAt(l);
                set.add(left);
                char right = s.charAt(r);
                if (left != right && !set.contains(right) ){
                    
                    lengths[l]++;
                    r++;
                    set.add(right);
                    if(r==s.length()){
                        set.clear();
                        l++;
                        r=l+1;
                    }
                } else {
                    l++;
                    r=l+1;
                    set.clear();
                }
            }
            
            System.out.println(Arrays.toString(lengths));

            for (int i = 0; i < lengths.length; i++) {
                result = Math.max(result, lengths[i]);
            }

            return result;
    }
}
