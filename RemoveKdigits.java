// Time Complexity : O(n) where n is the length of the input string num
// Space Complexity : O(n) where n is the length of the input string num
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The idea is to use a stack to keep track of the digits in the number.
//  We iterate through each digit in the input string and compare it with the top of the stack.
//  If the current digit is smaller than the top of the stack and we still have k digits to remove, we pop the stack.
//  This ensures that we are removing larger digits before smaller ones, which helps in forming the smallest possible number. 
// After processing all digits, if we still have k digits to remove, we pop from the stack until k becomes 0. 
// Finally, we construct the resulting number from the stack and remove any leading zeros before returning it.

import java.util.*;

class Solution {

    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > c) {

                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        int index = 0;

        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }

        String result = sb.substring(index);

        return result.length() == 0 ? "0" : result;
    }
}