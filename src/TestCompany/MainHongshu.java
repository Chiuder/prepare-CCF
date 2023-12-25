package TestCompany;

import java.util.*;
/*
 给出一个数组。你需要求出按顺序对其进行一系列区间操作后最终所得的数组。

操作有三种：

1. 将下标在L到R之间的元素全部或上X。

2. 将下标在L到R之间的元素全部与上X。

3. 将下标在L到R之间的元素全部设为X。



输入描述
第一行有一个正整数N(1<=N<=100000)，代表数组的长度。

第二行有N个非负整数，范围在0到2^20-1之间，代表数组中的元素。

第三行有一个正整数M(1<=M<=100000)，代表操作次数。

第四行有M个正整数，代表M次操作中的区间左端点L。

第五行有M个正整数，代表M次操作中的区间右端点R。

第六行是一个长度为M的字符串，`|`代表操作1，`&`代表操作2，`=`代表操作3。

第七行有M个正整数，代表M次操作中的参数X。

输出描述
在一行中输出N个数，代表所有操作按顺序完成后最终所得的数组。
 **/
public class MainHongshu {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        int m = cin.nextInt();
        int[] l = new int[m];
        int[] r = new int[m];
        char[] op = new char[m];
        int[] x = new int[m];
        for (int i = 0; i < m; i++) {
            l[i] = cin.nextInt();
        }
        for (int i = 0; i < m; i++) {
            r[i] = cin.nextInt();
        }
        String opStr = cin.next();
        for (int i = 0; i < m; i++) {
            op[i] = opStr.charAt(i);
        }
        for (int i = 0; i < m; i++) {
            x[i] = cin.nextInt();
        }
        for (int i = 0; i < m; i++) {
            for (int j = l[i]-1; j <= r[i]-1; j++) {
                if (op[i] == '|'){
                    arr[j] |= x[i];
                } else if (op[i] == '&') {
                    arr[j] &= x[i];
                }else {
                    arr[j] = x[i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
