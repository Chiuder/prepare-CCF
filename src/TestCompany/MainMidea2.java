package TestCompany;

import java.util.*;

public class MainMidea2 {
    public static void main(String[] args) {
        // Scanner cin = new Scanner(System.in);
        // String inStr = cin.nextLine();
        // StringBuilder stringBuilder = new StringBuilder();
        // char preChar = inStr.charAt(0);
        // int count = 1;
        // for (int i = 1; i < inStr.length(); i++) {
        //
        //     char curChar = inStr.charAt(i);
        //     if (preChar == curChar) {
        //         count++;
        //     } else {
        //         stringBuilder.append(preChar);
        //         if (count > 1) {
        //             stringBuilder.append(count);
        //         }
        //         preChar = curChar;
        //         count = 1;
        //     }
        // }
        // stringBuilder.append(preChar);
        // if (count > 1){
        //     stringBuilder.append(count);
        // }
        // System.out.println(stringBuilder);

        // Scanner cin = new Scanner(System.in);
        // String inStr = cin.nextLine();
        // String[] inputNum = inStr.split(",");
        // List<Integer> list = new ArrayList<>();
        // for (int i = 0; i < inputNum.length; i++) {
        //     list.add(Integer.parseInt(inputNum[i]));
        // }
        // Set<Integer> set = new HashSet<>(list);
        // int[] nums = new int[set.size()];
        // int i = 0;
        // for (Integer num : set){
        //     nums[i] = num;
        //     i++;
        // }
        // Arrays.sort(nums);
        // int n = nums.length;
        // System.out.println(nums[n - 2] * nums[n - 1]);

        Scanner cin = new Scanner(System.in);
        String inStr = cin.nextLine();

        int comboCnt = 0;
        int missCnt = 0;
        int score = 0;
        for (int i = 0; i < inStr.length(); i++) {
            char curRes = inStr.charAt(i);
            if (curRes == 'P'){
                score += 10;
                comboCnt++;
                if (comboCnt > 3){
                    score += 5;
                }
            }
            else if (curRes == 'G'){
                score += 5;
                comboCnt = 0;
            }
            else {
                missCnt++;
                comboCnt = 0;
                if (missCnt == 3){
                    break;
                }
            }
        }
        System.out.println(score);
    }
}
