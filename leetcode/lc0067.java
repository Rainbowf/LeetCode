package leetcode;

import java.util.*;

//offer2q002
//时间：O(max(a,b))
//空间：O(1)
class Solution0067 {
    public String addBinary(String a, String b) {
        //1、结果
        StringBuilder result = new StringBuilder();
        //2、从右往左写，进位变量
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        //3、遍历。两个索引值在变的写法，注意！
        while (i >= 0 || j >= 0) {
            //取值
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            //计算
            int sum = digitA + digitB + carry;
            //迭代
            carry = sum > 1 ? 1 : 0;
            sum = sum > 1 ? sum -= 2 : sum;
            result.append(sum);//sum可以直接转成char?数字可以
        }
        //4、最后一位进位
        if (carry == 1) result.append(1);
        //5、转成字符串
        return result.reverse().toString();
    }

    //改进版本
    public String addBinary2(String a, String b) {
        //1、结果
        StringBuilder result = new StringBuilder();
        //2、从右往左写，进位变量
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        //3、遍历。两个索引值在变的写法，注意！
        while (i >= 0 || j >= 0) {
            int sum = carry;
            //取值+计算
            sum += i >= 0 ? a.charAt(i--) - '0' : 0;
            sum += j >= 0 ? b.charAt(j--) - '0' : 0;
            //迭代
            result.append(sum % 2);//sum可以直接转成char?数字可以
            carry = sum / 2;
        }
        //4、最后一位进位
        if (carry == 1) result.append(1);
        //5、转成字符串
        return result.reverse().toString();
    }
}