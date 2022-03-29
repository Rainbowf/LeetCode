package leetcode;

import java.util.*;

//offer2q037

class Solution0735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + ast < 0){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek() < 0 || ast > 0){
                stack.push(ast);
            }else if(!stack.isEmpty() && stack.peek() > 0 && stack.peek() + ast == 0){
                stack.pop();
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
