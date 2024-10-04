package stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(
        int n
    ) {

        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        backTrack(n, 0, 0, stack,result);        

        return result;

    }

    

    private static void backTrack(int n, int open, int close, Stack<String> stack, List<String> result)  {

        if (open == close && close == n){
            StringBuilder sb = new StringBuilder();
            for(String valid : stack){
                sb.append(valid);
            }
            result.add(sb.toString());
            return;
        }

        if (open < n){
            stack.push("(");
            backTrack(n, open+1, close, stack, result);
            stack.pop();
        }
        if (close < open){
            stack.push(")");
            backTrack(n, open, close+1, stack, result);
            stack.pop();
        }

    }  


    

    public static void main(String[] args) {
     
        System.err.println(
            generateParenthesis(3)
        );
    }
}
