package arrays_and_hashing.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String temp1 = new String(temp);
        
            if (map.containsKey(temp1)){
                map.get(temp1).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(temp1, list);
            }
        }


        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
        
    }
    

    public static void main(String[] args) {
        

        String[] testCase1 = {"eat","tea","tan","ate","nat","bat"};
        String[] testCase2 = {""};
        String[] testCase3 = {"a"};

        System.out.println(groupAnagrams(testCase3));

    }
}