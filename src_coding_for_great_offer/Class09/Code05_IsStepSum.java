package Class09;

import java.util.HashMap;

public class Code05_IsStepSum {

    public static boolean isStepSum(int stepSum) {
        //在0 ~ stepSum范围进行二分
        int L = 0;
        int R = stepSum;
        int M = 0;
        int cur = 0;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            cur = stepSum(M);
            if (cur == stepSum) {
                return true;
            } else if (cur < stepSum) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return false;
    }

    public static int stepSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num;
            num /= 10;
        }
        return sum;
    }

    //for test
    //哈希表键是某个数的数位累加和，值是对应的原始数
    public static HashMap<Integer, Integer> generateStepNumBerMap(int numMax) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= numMax; i++) {
            map.put(stepSum(i), i);
        }
        return map;
    }

    public static void main(String[] args) {
        int max = 1000000;
        int maxStepSum = stepSum(max);
        HashMap<Integer, Integer> ans = generateStepNumBerMap(max);
        System.out.println("test begin");
        for (int i = 0; i <= maxStepSum; i++) {
            if (isStepSum(i) ^ ans.containsKey(i)) {
                System.out.println("Oops");
            }
        }
        System.out.println("test finish");
    }
}
