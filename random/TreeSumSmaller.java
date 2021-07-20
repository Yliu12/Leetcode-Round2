package random;

import java.util.*;

public class TreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            result += twoSum(nums, i, target);

        }
        return result;
    }

    public int twoSum(int[] nums, int index, int target) {
        int left = index + 1;
        int right = nums.length - 1;
        int twoSumTarget = target - nums[index];
        int result = 0;
        while (right > left) {
            int sum = nums[left] + nums[right];
            if (sum >= twoSumTarget) {
                right--;
            } else {
                left++;
                result += right - left + 1;
            }
        }
        return result;
    }
}
