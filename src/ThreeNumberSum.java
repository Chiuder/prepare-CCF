import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-07 16:38
 */
public class ThreeNumberSum {
    public static void main(String[] args) {
        ThreeNumberSum threeNumberSum = new ThreeNumberSum();
        System.out.println(threeNumberSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length; k++){
            if (nums[k] > 0)
                break;
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0){
                    while (i < j && nums[i] == nums[++i]);
                }
                else if (sum > 0){
                    while (i < j && nums[j] == nums[--j]);
                }
                else {
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
