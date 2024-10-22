package arrays_and_hashing.medium;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeandDecode {
    
    public static String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();

        for (String string : strs) {
            int length = string.length();

            encodedString.append(
                length + "#" + string
            );
            
        }

        return encodedString.toString();
    }

    public static List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        String s = str;
        int left = 0;
        int right = 0;

        while(right < s.length()){
            if(s.charAt(right) == '#'){
                int l = Integer.parseInt(s.substring(left, right));
                result.add(s.substring(right+1, l+right+1));
                s = s.substring(right+l+1, s.length());
                left = 0;
                right = 0;
            } else {
                right ++;
            }
            
        }

        return result;

    }


    @SuppressWarnings("unused")
    public static void main(String[] args) {
        
        List<String> testCase = new ArrayList<>(List.of("neet","code","love","you"));
        List<String> testCase2 = new ArrayList<>(List.of("we","say",":","yes","!@#$%^&*()"));
        List<String> testCase3 = new ArrayList<>(List.of("we","say",":","yes","!@#$%^&*()","2#"));

        System.out.println(
            encode(testCase3)
        );

        System.out.println(
            decode(encode(testCase3))
        );

    }
}
