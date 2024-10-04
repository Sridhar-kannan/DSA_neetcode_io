package stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static Integer evaluate(ArrayList<String> input){
    
        
        ArrayList<String> operators = new ArrayList<>(List.of("+","-","*","/"));

        Stack<Integer> stack = new Stack<>();
        
        
        for (int i = 0; i < input.size(); i++) {
            if(operators.contains(input.get(i))){
                int element2 = stack.pop();
                int element1 = stack.pop();

                switch (input.get(i)) {
                    case "+":
                        stack.push(element1 + element2);
                        break;
                        case "*":
                        stack.push(element1 * element2);
                        break;
                        case "/":
                        stack.push(element1 / element2);
                        break;
                        case "-":
                        stack.push(element1 - element2);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.parseInt(input.get(i)));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        

        ArrayList<String> testCase = new ArrayList<>(
            List.of("10","6","9","3","+","-11","*","/","*","17","+","5","+")
        );

        System.out.println("result = " + evaluate(testCase));
    }

}
