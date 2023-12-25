package TestCompany;

import java.util.*;

public class MainTencent {
//    private static int cnt = 0;
//    private static LinkedList<LinkedList<Character>> list = new LinkedList<>();
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        String[] str = new String[n];
//        for (int i = 0; i < n; i++) {
//            str[i] = cin.next();
//        }
//        for (int i = 0; i < n; i++) {
//            str[i] = delSame(str[i]);
//        }
//        backStrak(new LinkedList<>(), n, 0, str);
//        System.out.println(cnt);
//
//
//    }
//
//    private static void backStrak(LinkedList<Character> res, int n, int level, String[] str){
//        if (res.size() == n){
//            cnt++;
//            return;
//        }
//        for (int i = 0; i < str[level].length(); i++) {
//            if (res.contains(str[level].charAt(i))){
//                continue;
//            }
//            res.add(str[level].charAt(i));
//            backStrak(res, n, level+1, str);
//            res.removeLast();
//        }
//    }
//    private static String delSame(String str){
//        StringBuffer stringBuffer = new StringBuffer();
//        List list = new ArrayList();
//        char[] sc = str.toCharArray();
//        for (int i = 0; i < sc.length; i++) {
//            if (!list.contains(sc[i])){
//                stringBuffer.append(sc[i]);
//                list.add(sc[i]);
//            }
//        }
//        return stringBuffer.toString();
//    }

    //    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        int[] A = new int[n];
//        int[] B = new int[n];
//        for (int i = 0; i < n; i++) {
//            A[i] = cin.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            B[i] = cin.nextInt();
//        }
//        Arrays.sort(A);
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < n; i++) {
//            pq.offer(B[i]);
//        }
//        Set<Integer> used = new HashSet<>();
//        int[] C = new int[n];
//        for (int i = 0; i < n; i++) {
//            int b = pq.poll();
//            int ind = -1;
//            for (int j = 0; j < n; j++) {
//                if (!used.contains(j) && b == B[j] && (ind == -1 || A[j] < A[ind])){
//                    ind = j;
//                }
//            }
//            C[ind] = i + 1;
//            used.add(ind);
//        }
//        int x = 0;
//        for (int i = 0; i < n; i++) {
//            x += Math.abs(C[i]-A[i]);
//        }
//        System.out.println(x);
//    }
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = cin.nextInt();
//        }
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            int yihuo = nums[i];
//            int prod = nums[i];
//            for (int j = i + 1; j < n; j++) {
//                yihuo ^= nums[j];
//                prod *= nums[j];
//                if (yihuo == prod){
//                    cnt++;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        int[] b = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % k == 0) {
                b[cnt++] = a[i];
            }
        }
        long mod = 1000000007;
        int max_b = Arrays.stream(b).max().getAsInt();
        int[][] dp = new int[cnt + 1][max_b + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= cnt; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            for (int j = 1; j <= k; j++) {
                if (j % gcd(j, b[i-1]) == 0){
                    dp[i][j] = (int) ((dp[i][j] + dp[i-1][j/gcd(j,b[i-1])])%mod);
                }
            }
        }
        System.out.println(dp[cnt][k]);
    }
    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
