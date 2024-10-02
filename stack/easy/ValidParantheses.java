package stack.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ValidParantheses {

    public static boolean isValid(String input){
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();    
        map.put(')','(');
        map.put(']', '[');
        map.put('}', '{');
        
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            if ( c == '[' |  c == '{' | c == '('){
                stack.push(c);
            }
            if(c == ']' |  c == '}' | c == ')'){
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();
                char opening_pair = map.get(c);
                if (top != opening_pair) {
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }

    public static void main(String[] args) {

        ArrayList<String> testCases = new ArrayList<String>();

        testCases.add("[]");
        testCases.add("([{}])");
        testCases.add("[(])");

        for (String testCase : testCases) {
            System.out.printf("testCase %s : %b\n", testCase, isValid(testCase));
        }

        
    }
}
