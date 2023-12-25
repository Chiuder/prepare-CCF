/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-11 15:54
 */
public class PickUpRain {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax < rightMax){
                res += leftMax - height[left];
                left++;
            }
            else{
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
