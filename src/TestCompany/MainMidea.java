package TestCompany;

import java.util.*;

/**
 * @BelongsPackage: TestCompany
 * @Description:
 * @author: Chiuder
 * @create: 2023-04-10 14:25
 */
public class MainMidea {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String inStr = cin.nextLine();
        inStr = inStr.substring(1, inStr.length() - 1);
        System.out.println(inStr);
        String[] numStr = inStr.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numStr.length; i++) {
            list.add(Integer.parseInt(numStr[i]));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                list.remove(list.get(i));
            }
            map.put(list.get(i), 1);
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i !=  nums.length - 1){
                System.out.print(",");
            }
        }
    }
}
