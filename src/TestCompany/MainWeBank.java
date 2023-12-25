package TestCompany;

import java.util.*;

public class MainWeBank {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int l, r, x, y, res;
        int count1;
        while (n-- > 0) {
            l = cin.nextInt();
            r = cin.nextInt();
            x = cin.nextInt();
            y = cin.nextInt();
            res = 0;
            int t = Math.max(x,y);
            for (int i = 0; i <= t; i++) {
                count1 = Integer.bitCount(i);

                if (((i & x) == x) && (i | y) == y) {
                    if (count1 >= l && count1 <= r) {
                        res++;
                    }
                }
            }
            System.out.println(res);
        }

    }
}
