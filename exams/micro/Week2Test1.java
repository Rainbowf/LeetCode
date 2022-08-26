package exams.micro;

import java.util.Scanner;
import java.util.*;

public class Week2Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//    int[] x = {1,1,2};
//    int[] y = {3,2,3};

        int[] x = {1, 1, 1};
        int[] y = {2, 2, 2};
        System.out.println(solution(x));
    }

    public static int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        PriorityQueue<Double> queue = new PriorityQueue<>((q1, q2) -> Double.compare(q2, q1));
        int cnt = 0;
        double sum = 0;
        for (int a: A) {
            queue.offer((double)a);
            sum += a;
        }

        double target = sum / 2.0;
        while (sum - target > 0.000001) {
            double head = queue.poll();
            double temp = head / 2.0;
            sum -= temp;
            cnt++;
            queue.offer(temp);
        }
        return cnt;
    }

    public static int getCount(int[] X, int[] Y) {
        int n = X.length;

        HashMap<String, Integer> m = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int son = X[i];
            int father = Y[i];
            if (father < son) {
                continue;
            }
            int other = father - son;
            int tmp = gcd(other, father);
            father /= tmp;
            other /= tmp;
            son /= tmp;
            String key = other + "," + father;
            sum += m.getOrDefault(key, 0);

            String key2 = son + "," + father;
            m.put(key2, m.getOrDefault(key2, 0) + 1);
        }

        return sum;

    }

    private static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}