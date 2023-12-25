package TestCompany;

import java.util.*;

public class MainHuawei {
    // public static void main(String[] args) {
    //     Scanner cin = new Scanner(System.in);
    //     int n = cin.nextInt();
    //     int[][] nums = new int[n][2];
    //     int maxTime = 0, minTime = Integer.MAX_VALUE;
    //     for (int i = 0; i < n; i++) {
    //         nums[i][0] = cin.nextInt();
    //         nums[i][1] = cin.nextInt();
    //         minTime = Math.min(minTime, nums[i][0]);
    //         maxTime = Math.max(maxTime, nums[i][1]);
    //     }
    //     Arrays.sort(nums, (v1, v2) -> v1[0] - v2[0]);
    //     ArrayList<int[]> mergeList = new ArrayList<>();
    //     int cost = 0;
    //     int flag = 0;
    //     int numOfTask = 0;
    //
    //     // for (int i = 0; i < nums.length; i++) {
    //     //     int left = nums[i][0], right = nums[i][1];
    //     //     if (i == 0) {
    //     //         cost += left;
    //     //     } else if (mergeList.size() == 0 || mergeList.get(mergeList.size() - 1)[1] < left) {
    //     //         mergeList.add(new int[]{left, right});
    //     //         cost += (right - left + 1) * 3;
    //     //     } else {
    //     //
    //     //         cost += (Math.min(mergeList.get(mergeList.size() - 1)[1], right) - Math.max(mergeList.get(mergeList.size() - 1)[0], left) + 1) * 4;
    //     //         // mergeList.get(mergeList.size() - 1)[1] = Math.max(mergeList.get(mergeList.size() - 1)[1], right);
    //     //     }
    //     // }
    //     for (int time = minTime; time <= maxTime; time++) {
    //         numOfTask = 0;
    //         for (int i = 0; i < n; i++) {
    //             if (time >= nums[i][0] && time <= nums[i][1]){
    //                 numOfTask++;
    //             }
    //         }
    //         switch (numOfTask){
    //             case 0:
    //                 cost += 1;
    //                 break;
    //             case 1:
    //                 cost += 3;
    //                 break;
    //             default:
    //                 cost += 4;
    //                 break;
    //         }
    //     }
    //     System.out.println(cost);
    // }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int edge = cin.nextInt();
        int[][] matrix = new int[n][n];
        int u, v;
        for (int i = 0; i < edge; i++) {
            u = cin.nextInt();
            v = cin.nextInt();
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
        int block = cin.nextInt();
        boolean[] isblock = new boolean[n];
        for (int i = 0; i < block; i++) {
            int x = cin.nextInt();
            isblock[x] = true;
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] preNode = new int[n]; // 表示可到达节点的前一个节点
        Arrays.fill(preNode, -1);
        Deque<Integer> que = new LinkedList<>();
        que.offer(0);
        distance[0] = 0;
        if (!BFS(que, matrix, isblock, distance, preNode, n)) {
            System.out.println("NULL");
        }

    }

    private static boolean BFS(Deque<Integer> que, int[][] matrix, boolean[] isblock, int[] distance, int[] preNode, int n) {
        // BFS
        while (!que.isEmpty()) {
            int i = que.poll();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !isblock[j] && distance[i] + 1 < distance[j]) {
                    distance[j] = distance[i] + 1;
                    preNode[j] = i;
                    que.offer(j);
                }
            }
            if (i != 0 && isOverLeaf(matrix, i)) {
                StringBuilder str = new StringBuilder();
                str.append(i);
                while (preNode[i] != -1) {
                    str.insert(0, preNode[i] + "->");
                    i = preNode[i];
                }
                System.out.println(str);
                return true;
            }
        }
        return false;
    }

    private static boolean isOverLeaf(int[][] matrix, int i) {
        int cnt = 0;
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 1)
                cnt++;
        }
        return cnt == 1;
    }
}
