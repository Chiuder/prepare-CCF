package TestCompany;

import java.util.*;

public class MainZhaoYinBank {

//    public static void main(String[] args) {
////        Scanner cin = new Scanner(System.in);
////        int num = cin.nextInt();
////        ArrayList<Integer> res = new ArrayList<>();
////        while (num > 10){
////            if(isOK(num))
////                res.add(num);
////            num--;
////        }
////        for (int i = 0; i < res.size(); i++) {
////            System.out.println(res.get(i));
////        }
////    }
////
////    private static boolean isOK(int num){
////        String str = String.valueOf(num);
////        int len = str.length();
////        int sum = 0;
////        for (int i = 0; i < len; i++) {
////            sum += Math.pow((str.charAt(i)-'0'), len);
////        }
////        if (sum == num)
////            return true;
////        return false;
////    }

    public double get_max_profit (double M, int N, double[] historyPrices, int K) {
        // write code here
        K = Math.min(K, N / 2);
        double[][] buy = new double[N][K+1];
        double[][] sell = new double[N][K+1];

        buy[0][0] = -M;
        sell[0][0] = 0;
        for (int i = 1; i <= K; i++) {
            sell[0][i] = Double.MIN_VALUE / 2;
            buy[0][i] = sell[0][i];
        }
        for (int i = 1; i < N; i++) {
//            buy[i][0] = Math.max(buy[i-1][0], sell[i-1][0] - historyPrices[i]);
            buy[i][0] = Math.max(buy[i-1][0], sell[i-1][0] - (sell[i-1][0] / historyPrices[i-1]) * historyPrices[i]);
            for (int j = 1; j <= K; j++) {
//                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j] - historyPrices[i]);
//                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j-1] + historyPrices[i]);
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j] - (sell[i-1][0] / historyPrices[i-1]) * historyPrices[i]);
                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j-1] + (sell[i-1][0] / historyPrices[i-1]) * historyPrices[i]);
            }
        }
        return Arrays.stream(sell[N-1]).max().getAsDouble();
    }
}
