import java.util.*;

/**
 * @BelongsPackage: TestCompany
 * @Description: 输出所有最长不含重复字符的子串
 * @author: Chiuder
 * @create: 2023-04-12 14:26
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();

        Map<Character, Integer> dic = new HashMap<>();
        ArrayList<String> ss = new ArrayList<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            if (res <= j - i) {
                res = Math.max(res, j - i); // 更新结果
                ss.add(s.substring(i + 1, j + 1));
            }
        }
        for (String ans : ss) {
            if (ans.length() == res)
                System.out.println(ans);
        }
    }
}
