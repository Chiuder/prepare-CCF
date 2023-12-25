import java.util.*;
public class QuickSortRandom {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r){
        //递归退出条件
        if (l >= r)
            return;
        //随机选取主元
        int randomIndex = new Random().nextInt(r-l+1) + l;
        //将主元与数组区间最左位置交换,这样主元就是nums[l]
        swap(nums, l, randomIndex);

        int pivot = nums[l];
        int less = l; //less表示比主元小的元素下标
        int more = r + 1;//more表示比主元大的元素下标
        // 循环不变量：这里是左闭右闭区间
        // 小于nums[pivot]区间：[left + 1, less]
        // 等于nums[pivot]区间：[less + 1, i]
        // 大于nums[pivot]区间：[more, right]
        int i = l + 1;//i用来指向数组区间中的各个元素，从主元右边第一个元素开始（nums[l+1]）
        while (i < more){
            if (nums[i] < pivot){
                less--;
                swap(nums, i, less);
                i++;
            }
            else if (nums[i] == pivot){
                i++;
            }
            else {
                more--;
                swap(nums, i, more);
            }
        }
        //less最后指向的一定是小于nums[pivot]的元素
        swap(nums, l, less);
        //同理more指向大于nums[pivot]的元素
        quickSort(nums, l, less - 1);
        quickSort(nums, more, r);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}