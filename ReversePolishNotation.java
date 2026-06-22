// Time Complexity : O(n) where n is the length of the input array tokens
// Space Complexity : O(n) where n is the length of the input array tokens
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The idea is to use a stack to keep track of the operands in the expression.
// We iterate through each token in the input array and check if it is an operator or an operand. 
// If it is an operand, we push it onto the stack. 
// If it is an operator, we pop the top two operands from the stack, perform the operation, and push the result back onto the stack. 
// After processing all tokens, the final result will be the only element left in the stack, which we return.   

import java.util.*;

class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")) {

                int a = stack.pop();
                int b = stack.pop();

                stack.push(b + a);

            } else if (token.equals("-")) {

                int a = stack.pop();
                int b = stack.pop();

                stack.push(b - a);

            } else if (token.equals("*")) {

                int a = stack.pop();
                int b = stack.pop();

                stack.push(b * a);

            } else if (token.equals("/")) {

                int a = stack.pop();
                int b = stack.pop();

                stack.push(b / a);

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}