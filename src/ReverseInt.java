/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-05 16:16
 */
public class ReverseInt {
    public static void main(String[] args) {
        ReverseInt reverseInt = new ReverseInt();
        System.out.println(reverseInt.reverse(123456));
    }

    public int reverse(int x) {
        long num = 0;
        while (x != 0){
            num = num * 10 + x % 10;
            x/= 10;
        }
        return (int)num == num ? (int)num : 0;
    }
}
