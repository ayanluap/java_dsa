import java.util.*;

public class cpp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        int k = 0;
        while (k < tc) {

            int n = sc.nextInt();
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextLong();

            System.out.println(solve(a));

            k++;
        }

    }

    private static long solve(long[] a) {
        int[] bit = new int[50];
        for (long i : a) {
            int j = 0;
            while (i > 0) {
                j++;
                i = i >> 1;
            }
            bit[j]++;
        }
        long cnt = 0;
        for (long s : bit) {
            cnt += s * (s - 1) / 2;
        }
        return cnt;
    }
}
