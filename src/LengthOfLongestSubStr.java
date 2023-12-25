import java.util.HashMap;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-04 18:18
 */
public class LengthOfLongestSubStr {
    public static void main(String[] args) {
        LengthOfLongestSubStr lengthOfLongestSubStr = new LengthOfLongestSubStr();
        System.out.println(lengthOfLongestSubStr.lengthOfLongestSubString("asdsfasfdsf"));
    }

    /*
     * @description: 最长不含重复字符的子串
     * @date: 2023/4/13 14:13
     * @param: [s]
     * @return: java.lang.String
     **/
    public String lengthOfLongestSubString(String s){
        if (s.length() == 0)
            return "";
        //用一个hashmap记录每个字符是否出现过以及其索引下标
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        StringBuilder longestSub = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            if (ans < i - left + 1){
                ans = i - left + 1;
                longestSub.replace(0,longestSub.length(),s.substring(left, i + 1)) ;
            }
        }
        return longestSub.toString();
    }
}
