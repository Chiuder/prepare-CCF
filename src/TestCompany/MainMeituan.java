package TestCompany;

import java.util.Scanner;

public class MainMeituan {

    /*
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.next();
        int n = str.length();
        char right = str.charAt(0);
        int res = 0;
        for (int i = 1; i < n; i++){
            if (str.charAt(i) == right){
                res++;
                right = 'c';
            }
            else{
                right = str.charAt(i);
            }
        }
        System.out.println(res);
    }

     */

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int k = cin.nextInt();
        char[][] flag = new char[n + 1][m + 1];
        String[] color = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            color[i] = cin.next();
        }
        for (int i = 1; i <= n; i++) {
            char[] tempChar = color[i].toCharArray();
            for (int j = 1; j <= m; j++) {
                flag[i][j] = tempChar[j - 1];
            }
        }
        int[][] coin = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                coin[i][j] = cin.nextInt();
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = coin[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int tempA = 0, tempB = 0;
                int resA = 0, resB = 0;
                //dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + (flag[i][j] != flag[i-1][j-1] ? coin[i][j]-k : coin[i][j]);

                if (dp[i - 1][j] < k && dp[i][j - 1] < k)
                    break;
                if (dp[i - 1][j] < dp[i][j - 1] && dp[i][j-1] >= k) {
                    if (flag[i][j - 1] - '0' == flag[i][j] - '0') {
                        tempA = dp[i][j - 1] + coin[i][j] - k;
                        //System.out.println(tempA);
                    } else {
                        tempB = dp[i][j - 1] + coin[i][j];
                    }
                    resA = Math.max(tempA, tempB);
                    System.out.println(resA);
                }
                if (dp[i - 1][j] >= dp[i][j - 1] && dp[i][j-1] >= k) {
                    if (flag[i][j - 1] - '0' == flag[i][j] - '0') {
                        tempA = dp[i - 1][j] + coin[i][j] - k;
                        //System.out.println(tempA);
                    } else {
                        tempB = dp[i - 1][j] + coin[i][j];
                    }
                    resB = Math.max(tempA, tempB);
                    System.out.println(resB);
                }
                dp[i][j] = Math.max(resA, resB);
                if (dp[i][j] < 0) {
                    dp[i][j] = 0;
                }


            }
        }
        System.out.println(dp[n][m]);

    }


    /*
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++){
            s[i] = cin.nextInt();
        }

        for (int i = 0; i < n; i++){
            t[i] = cin.nextInt();
        }
        Arrays.sort(s);;
        Arrays.sort(t);
        int maxNum = 0; //最佳时刻个数
        int maxCount = 0;//最多观测到的流行数量
        int count = 0;//当前时刻观测到的流行数量
        int deleteCnt = 0;

        for (int i = 0; i < n; i++){
            while (deleteCnt < n && t[deleteCnt] < s[i]){
                deleteCnt++;
                count--;
            }
            count++;
            if (count > maxCount){
                maxCount = count;
                maxNum = 1;
            }
            else if (count == maxCount){
                maxNum++;
            }
        }
        maxNum += 2;
        System.out.println(maxCount + " " + maxNum);

    }

     */

}
