package leetcode;

import java.util.*;

//offer2q071

class Solution0528 {
    private int sum;
    private int[] temp;

    public Solution0528(int[] w) {
        temp = new int[w.length];
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            temp[i] = sum;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int p = random.nextInt(sum);
        //查找,
        int i = 0;
        int j = temp.length - 1;
        while(i <= j){
            int m = i + (j - i)/2;
            if(temp[m] > p){
                if(m == 0 || temp[m - 1]<= p){
                    return m;
                }
                j = m - 1;
            }else{
                i = m + 1;
            }
        }
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
