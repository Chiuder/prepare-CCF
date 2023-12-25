import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-16 10:14
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0)
            return res.toArray(new int[0][]);
        int i = 0;
        while (i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && right >= intervals[i+1][0]){
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left,right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
