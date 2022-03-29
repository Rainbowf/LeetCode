package leetcode;

import java.util.*;

//offer2q036

class Solution0150 {
    public int evalRPN(String[] tokens) {


        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(caculate(num2, num1, token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private Integer caculate(int num1, int num2, String token) {
        switch (token) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}