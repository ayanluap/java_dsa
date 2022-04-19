package L2_ArraysAndStrings;

import java.util.*;

public class Q187_BestMeetingPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int arr[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(BestPoint(arr, m, n));
    }

    public static int BestPoint(int[][] arr, int m, int n) {
        ArrayList<Integer> hori = new ArrayList<>();
        ArrayList<Integer> vert = new ArrayList<>();

        // horizontal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1)
                    hori.add(i);
            }
        }
        // vertical
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (arr[i][j] == 1)
                    vert.add(j);
            }
        }

        // mid
        int mid = hori.size() / 2;
        int x = hori.get(mid);
        int y = vert.get(mid);

        int dist = 0;
        for (int i = 0; i < hori.size(); i++) {
            dist += Math.abs(x - hori.get(i)) + Math.abs(y - vert.get(i));
        }

        return dist;
    }
}
