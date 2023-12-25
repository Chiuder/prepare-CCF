package TestCompany;

import java.util.*;

public class MainWeBank2 {
    // public static void main(String[] args) {
    //     Scanner cin = new Scanner(System.in);
    //     int n = cin.nextInt();
    //     int[] nums = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         nums[i] = cin.nextInt();
    //     }
    //     Set<Integer> res = new LinkedHashSet<>();
    //     for (int i = n-1; i >= 0; i--) {
    //         res.add(nums[i]);
    //     }
    //     List<Integer> resList = new ArrayList<>();
    //     resList.addAll(res);
    //     Collections.reverse(resList);
    //     StringBuilder sb = new StringBuilder();
    //     for (int num: resList){
    //         sb.append(num).append(" ");
    //     }
    //
    //     System.out.println(sb.toString().trim());
    // }
    // public static void main(String[] args) {
    //     Scanner cin = new Scanner(System.in);
    //     int n = cin.nextInt();
    //     List<Integer> songList = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         songList.add(cin.nextInt());
    //     }
    //     List<Integer> songPlayOrder = new ArrayList<>();
    //     while (!songList.isEmpty()){
    //         songPlayOrder.add(songList.get(0));
    //         songList.remove(0);
    //         if (!songList.isEmpty()){
    //             int firstToLastSong = songList.get(0);
    //             songList.remove(0);
    //             songList.add(firstToLastSong);
    //         }
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     for (int song : songPlayOrder){
    //         sb.append(song).append(" ");
    //     }
    //     System.out.println(sb.toString().trim());
    // }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int s = cin.nextInt();
        int t = cin.nextInt();
        List<Integer>[] island = new ArrayList[n+1];
        boolean[] visitedIsland = new boolean[n+1];
        int[] res = new int[1];

        for (int i = 1; i <= n; i++) {
            island[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            island[x].add(y);
            island[y].add(x);
        }
        dfs(island, visitedIsland, res, s, t);
        System.out.println(res[0]);
    }

    public static void dfs(List<Integer>[] island, boolean[] visitedIsland, int[] res, int s, int t){
        visitedIsland[s] = true;
        if (s == t){
            visitedIsland[s] = false;
            res[0]++;
            return;
        }
        for (int nextIsland : island[s]){
            if (!visitedIsland[nextIsland]){
                dfs(island,visitedIsland,res,nextIsland,t);
            }
        }
        visitedIsland[s] = false;
    }
}
