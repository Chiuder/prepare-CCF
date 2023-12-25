package TestCompany;

import java.util.*;
public class MainBaidu {
    /*
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        //String[] str = new String[t];
        boolean flag = false;
        for(int i = 0; i < t; i++){
            String str = cin.next();
            flag = canFormBaidu(str);
            if (flag)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    private static boolean canFormBaidu(String str){
        char[] baidu = "Baidu".toCharArray();
        Arrays.sort(baidu);
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.equals(baidu, chars);
    }

     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int x = cin.nextInt();
        StringBuffer str = new StringBuffer();
        int Palinromenumber = 1;
        str.append("r");
        while (Palinromenumber < x){
            StringBuffer left = new StringBuffer(str).append("r");
            StringBuffer right = new StringBuffer("r").append(str);
            if (isPalindrome(right.toString())){
                str = right;
                Palinromenumber++;
            } else if (isPalindrome(left.toString())) {
                str = left;
                Palinromenumber++;

            } else if (str.length() >= x) {

                for (int i = 0; i < str.length(); i++){
                    StringBuffer temp = new StringBuffer(str).insert(i,"r");
                    if (isPalindrome(temp.toString()))
                    str = temp;
                    Palinromenumber++;
                    break;
                }
            }
        }
        System.out.println(str);
    }
    private static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while (left < right && str.charAt(left) == str.charAt(right)){
            left++;
            right--;
        }
        return left >= right;
    }
}
