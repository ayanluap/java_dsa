package L2_ArraysAndStrings;

import java.util.*;
import java.io.*;

// 1. You are given a m*n grid where 1's represent land and 0's represent water. 
// 2. Assume every cell is linked to it's north, east, west and south cell.
// 3. You are required to find maximum area of an island in the grid.
// 4. If there are no island present in the grid, return 0.

// Constraints
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] is either 0 or 1.

public class Q180_MaxAreaOfIsland {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        int maxArea = maxAreaOfIsland(arr);
        System.out.println(maxArea);
    }

    public static int maxAreaOfIsland(int[][] arr) {
        // write your code here
        int m = arr.length;
        int n = arr[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    int area = findArea(arr, i, j, visited);
                    res = Math.max(res, area);
                }

                visited[i][j] = true;
            }
        }
        return res;
    }

    static int[] di = { -1, 0, 1, 0 };
    static int[] dj = { 0, 1, 0, -1 };

    public static int findArea(int[][] arr, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length)
            return 0;
        if (arr[r][c] != 1 || visited[r][c])
            return 0;
        int res = 0;
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            res += findArea(arr, r + di[d], c + dj[d], visited);
        }

        return res + 1;
    }
}
