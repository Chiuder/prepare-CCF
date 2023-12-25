/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-05 20:45
 */
public class MaxAreaOfWater {
    public static void main(String[] args) {
        MaxAreaOfWater maxAreaOfWater = new MaxAreaOfWater();
        System.out.println(maxAreaOfWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                res = Math.max(res, (r - l) * height[l]);
                l++;
            } else {
                res = Math.max(res, (r - l) * height[r]);
                r--;
            }
        }
        return res;
    }
}
