package Class07;

import java.util.Arrays;
import java.util.HashSet;

public class Code04_Power2Diffs {

    public static int diff1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int cur : arr) {
            set.add(cur * cur);
        }
        return set.size();
    }

    public static int diff2(int[] arr) {
        int N = arr.length;
        int L = 0;
        int R = N - 1;
        int count = 0;
        int leftAbs = 0;
        int rightAbs = 0;
        while (L <= R) {
            count++;
            leftAbs = Math.abs(arr[L]);
            rightAbs = Math.abs(arr[R]);
            if (leftAbs < rightAbs) {
                while (R >= 0 && Math.abs(arr[R]) == rightAbs) {
                    R--;
                }
            } else if (leftAbs > rightAbs) {
                while (L < N && Math.abs(arr[L]) == leftAbs) {
                    L++;
                }
            } else {
                while (L < N && Math.abs(arr[L]) == leftAbs) {
                    L++;
                }
                while (R >= 0 && Math.abs(arr[R]) == rightAbs) {
                    R--;
                }
            }
        }
        return count;
    }

    public static int[] randomSortedArray(int len, int value) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * value) - (int) (Math.random() * value);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void printArray(int[] arr) {
        for (int cur : arr) {
            System.out.print(cur + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int len = 100;
        int value = 500;
        int testTime = 200000;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomSortedArray(len, value);
            int ans1 = diff1(arr);
            int ans2 = diff2(arr);
            if (ans1 != ans2) {
                printArray(arr);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("test finish");
    }
}
