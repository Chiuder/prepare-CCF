package TestCompany;

import java.util.*;

public class MainHongshu2 {
    /*
    static int n;
    static int minDiff;
    static int minCount;
    static List<Integer>[] tree;
    static int[] size;
    static int[] diffCount;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            tree[x].add(y);
            tree[y].add(x);
        }
        size = new int[n + 1];
        diffCount = new int[n + 1];
        minDiff = Integer.MAX_VALUE;
        dfs(1,0);
        System.out.println(minDiff + " " + minCount);
    }

    private static void dfs(int x, int xFa) {
        size[x] = 1;
        diffCount[x] = 0;
        for (int y : tree[x]) {
            if (y != xFa){
                dfs(y, x);
                size[x] += size[y];
                diffCount[x] += diffCount[y] + Math.abs(n - 2 * size[y]);
            }
        }
        if (xFa != 0){
            int diff = Math.abs(n - 2 * size[x]);
            if (diff < minDiff){
                minDiff = diff;
                minCount = 1;
            } else if (diff == minDiff) {
                minCount++;
            }
        }
    }

     */
    static int n, Z, C;
    static int[][] dp;
    static int[] x;
    static int[] y;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        Z = cin.nextInt();
        C = cin.nextInt();
        x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = cin.nextInt();
        }

        y = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            y[i] = cin.nextInt();
        }

        dp = new int[C + 1][Z + 1];
        for (int i = 1; i <= C; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = C; j >= x[i]; j--) {
                for (int k = Z; k >= 0; k--) {
                    int tmp = k + (j == x[i] ? y[i] : 0);
                    if (tmp > Z) {
                        continue;
                    }
                    dp[j][k] = Math.max(dp[j][k], dp[j - x[i]][tmp] + y[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= Z; i++) {
            res = Math.max(res, dp[C][i]);
        }
        System.out.println(res);
    }
}
