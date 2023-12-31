/**
 * @author ${USER}
 * @BelongsPackage:
 * @Description: 力扣209.长度最小的子数组
 * @create ${YEAR}-${MONTH}-${DAY} ${TIME}
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int result = MinSubArrayLen.minSubArrayLen(7, array);
        System.out.println(result);
    }

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * 示例：
     * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     **/
    // 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= s){
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}