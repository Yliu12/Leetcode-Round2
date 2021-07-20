package random;

import java.util.*;

public class TreeSumClosest {
    int diff = Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {
           Arrays.sort(nums);
           for (int i = 0; i < nums.length - 2; i++) {
               twoSum(nums, i, target);
           }
           return target - diff;
       }
   
       public void twoSum(int[] nums, int index, int target) {
           int left = index + 1;
           int right = nums.length - 1;
           while (right > left) {
               int sum = nums[left] + nums[right] + nums[index];
               if (Math.abs(target - sum) < Math.abs(diff)) {
                   this.diff = target - sum;
               } 
               if(sum < target){
                   left ++;
               } else {
                   right --;
               }
           }
       }
   
}
