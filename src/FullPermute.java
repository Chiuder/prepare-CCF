import java.time.temporal.Temporal;
import java.util.*;
import java.util.prefs.BackingStoreException;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-08 20:50
 */
public class FullPermute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        backtrack(res, nums, visited, temp);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> temp){
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i])
                continue;
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(res, nums, visited, temp);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
