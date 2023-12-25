import java.util.Arrays;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-07 15:35
 */
public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLarge(new int[]{1, 3, 5, 6, 8, 1, 10}, 3));
    }

    public int findKthLarge(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    private void swap(int[] arr , int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void quickSort(int[] num, int l, int r){
        if(l >= r)
            return;
        int i = l, j = r;
        while (i < j){
            while (i < j && num[j] >= num[l]){
                j--;
            }
            while (i < j && num[i] <= num[l]){
                i++;
            }
            swap(num, i ,j);
        }
        swap(num, i, l);
        quickSort(num, l,i - 1);
        quickSort(num,i + 1, r);
    }
}
