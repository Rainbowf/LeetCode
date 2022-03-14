package leetcode;

class Solution004 {
    //1.二进制
    public int singleNumber(int[] nums) {
        //1、bit位计数数组，0~31高到低
        int[] bitCnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitCnt[i] += (num >> (31 - i)) & 1;
            }
        }
        //2、取模进位求和
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + bitCnt[i] % 3;
        }
        return res;
    }
    //哈希表，空间换时间
    //数字电路异或运算
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}