import java.util.ArrayList;
import java.util.Scanner;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-04 13:43
 */
public class Mod3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);
        int count = 1;
        while (list.size() != 1){
            for(int i = 0; i < list.size(); i++){
                if(count > 3)
                    count = 1;
                if(count == 3){
                    list.remove(i);
                    i--;
                }
                count++;
            }
        }
        System.out.println(list);
    }
}
