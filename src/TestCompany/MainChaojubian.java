package TestCompany;

import java.util.*;

public class MainChaojubian {
    // public static void main(String[] args) {
    //     Scanner cin = new Scanner(System.in);
    //     int num = cin.nextInt();
    //     String strNum = Integer.toBinaryString(num);
    //     int cnt = 0;
    //     int pos = -1;
    //     for (int i = strNum.length() - 1; i >= 2; i--) {
    //         if (strNum.substring(i-2, i+1).equals("101")){
    //             cnt++;
    //             if (pos == -1)
    //                 pos = strNum.length() - i - 1;
    //         }
    //     }
    //     System.out.println(cnt + " " + pos);
    // }
    //

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        List<String> res = new ArrayList<>();
        int len = str.length();
        int cnt = 0;
        int state = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            switch (state) {
                case 0:
                    if (ch == '\"') {
                        state = 2;
                    } else if (ch == ',') {
                        cnt++;
                        res.add("--");
                    } else {
                        sb.append(ch);
                        state = 1;
                    }
                    break;
                case 1:
                    if (ch == ',') {
                        cnt++;
                        res.add(sb.toString());
                        sb = new StringBuilder();
                        state = 0;
                    } else {
                        sb.append(ch);
                    }
                    break;
                case 2:
                    if (ch == '\"') {
                        if (i < len - 1 && str.charAt(i + 1) == '\"') {
                            sb.append(ch);
                            i++;
                        } else {
                            cnt++;
                            res.add(sb.toString());
                            sb = new StringBuilder();
                            state = 0;
                        }
                    } else {
                        sb.append(ch);
                    }
                    break;
            }
        }
        if (sb.length() > 0) {
            cnt++;
            res.add(sb.toString());
        }
        if (res.isEmpty()) {
            System.out.println("ERROR");
        } else {
            System.out.println(cnt);
            for (String re : res) {
                System.out.println(re);
            }
        }

    }
}
