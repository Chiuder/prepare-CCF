/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-04 21:16
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindromeStr("ababba"));
    }

    public String longestPalindromeStr(String s){
        if (s == null || s.length() < 2){
            return s;
        }

        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];//boolean dp[l][r] 表示字符串从 l 到 r 这段是否为回文。

        for (int r = 1; r < strLen; r++){
            for (int l = 0; l < r; l++){
                //r - l <= 2是为了bab这种
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(maxLen < r - l + 1){
                        maxLen = r- l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }
}
