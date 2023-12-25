/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-08 14:53
 */
public class BinarySearchXuanzhuanSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r){
            int mid = l + ((r - l) >> 1);
            if(nums[mid] == target)
                return mid;
            if (nums[0] <= nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && target <= nums[n - 1]){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
