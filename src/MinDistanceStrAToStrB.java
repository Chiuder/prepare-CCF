/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-14 19:53
 */
public class MinDistanceStrAToStrB {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0)
            return n + m;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i < m+1; i++){
            dp[0][i] = i;
        }
        int left = 0, up = 0, left_up = 0;
        //计算所有dp值
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                left = dp[i][j-1] + 1;
                up = dp[i-1][j] + 1;
                left_up = dp[i-1][j-1];
                if (word1.charAt(i) != word2.charAt(j))
                    left_up += 1;
                dp[i][j] = Math.min(left, Math.min(up, left_up));
            }
        }
        return dp[n][m];
    }

}
