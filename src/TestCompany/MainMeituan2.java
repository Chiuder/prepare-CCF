package TestCompany;

import java.util.*;

public class MainMeituan2 {
    //        public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        int a = cin.nextInt();
//        int b = cin.nextInt();
//        int[][] peo = new int[n][2];
//        for(int i = 0; i < n; i++){
//            peo[i][0] = cin.nextInt();
//            peo[i][1] = cin.nextInt();
//        }
//        Arrays.sort(peo, (peo1,peo2) -> peo1[0] - peo2[0]);
//        int res = 0;
//        for (int i = 0; i < n-1; i++){
//            int count = 1;
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(peo[i][1]);
//            for (int j = i+1; j < n; j++){
//                if (peo[i][0] - peo[j][0] >= -a){
//                    list.add(peo[j][0]);
//                    count++;
//                }
//            }
//            Collections.sort(list);
//            int tmp = list.get(0);
//            for (int k = 0; k < list.size(); k++){
//                if (tmp - list.get(k) < -b){
//                    count--;
//                }
//            }
////            int l = peo[i][0];
////            int r = peo[i][1];
////            for (int j = i + 1; j < n; j++){
////                if (Math.abs(l - peo[j][0]) <= a && Math.abs(r - peo[j][1]) <= b){
////                    count++;
////                }
////            }
//            res = Math.max(res, count);
//        }
//        System.out.println(res);
//    }
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        int k = cin.nextInt();
//        int[] colors = new int[n];
//        for (int i = 0; i < n; i++) {
//            colors[i] = cin.nextInt();
//        }
//        int l = 0, r = 0;
//        int res = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        while (r < n) {
//            map.put(colors[r], map.getOrDefault(colors[r], 0) + 1);
//            while (map.size() > k) {
//                map.put(colors[l], map.get(colors[l]) - 1);
//                if (map.get(colors[l]) == 0) {
//                    map.remove(colors[l]);
//                }
//                l++;
//            }
//            res = Math.max(res, r - l + 1);
//            r++;
//        }
//        System.out.println(res);
//    }
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        String str = cin.nextLine();
//        int n = str.length();
//        if (n == 1){
//            System.out.println(str);
//            return;
//        }
//        int l = 0, r = n - 1;
//        char[] sc = str.toCharArray();
//        while (l < r){
//            if (str.charAt(l) != str.charAt(r)){
//                char c1 = str.charAt(l), c2 = str.charAt(r);
//                sc[l] = 'a';
//                sc[r] = 'a';
//                if (isPalindRome(sc)) {
//                    System.out.println(new String(sc));
//                    return;
//                }
//                sc[l] = c1;
//                sc[r] = 'a';
//                if (isPalindRome(sc)){
//                    System.out.println(new String(sc));
//                    return;
//                }
//                sc[l] = 'a';
//                sc[r] = c2;
//                if (isPalindRome(sc)){
//                    System.out.println(new String(sc));
//                    return;
//                }
//
////                if (isPalindRome(str.substring(l, r))){
////                    System.out.println(str.substring(0,l)+str.charAt(r)+str.substring(l+1,r)+str.charAt(l)+str.substring(r+1));
////                    return;
////                }
////                if (isPalindRome(str.substring(l+1,r+1))){
////                    System.out.println(str.substring(0,r)+str.charAt(l)+str.substring(l+1,r)+str.charAt(r)+str.substring(r+1));
////                    return;
////                }
//            }
//            l++;
//            r--;
//        }
//        System.out.println(str);
//    }
//
//    private static boolean isPalindRome(char[] sc){
//        int l = 0, r = sc.length - 1;
//        while (l < r){
//            if (sc[l] != sc[r]){
//                return false;
//            }
//            l++;
//            r--;
//        }
//        return true;
//    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int x = cin.nextInt();
        int y = cin.nextInt();
        int[][] prices = new int[n][2];
        for (int i = 0; i < n; i++) {
            prices[i][0] = cin.nextInt();
            prices[i][1] = cin.nextInt();
        }
        Arrays.sort(prices,(o1, o2) -> o1[1] - o2[1]);
        int count = 0;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i][1] <= x){
                count++;
                cost = cost+prices[i][1];
                x = x-prices[i][1];
            }
            else if (y > 0 && prices[i][0] <= x + y){
                count++;
                cost = cost+prices[i][0];
                y--;
                x = x-prices[i][0];
            }
        }
        System.out.println(count + " " + cost);
    }
}
