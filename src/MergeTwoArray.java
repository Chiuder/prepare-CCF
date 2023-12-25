import java.util.Arrays;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-04 14:09
 */
public class MergeTwoArray {
    public static void main(String[] args) {
        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        mergeTwoArray.merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
