package random;

import java.util.*;

class TreeSum {
    public List<List<Integer>> threeSum(int[] nums, int target) {
            Arrays.sort(nums);
            Set<List<Integer>> resultSet = new HashSet<>();
            
            for(int i = 0; i < nums.length - 2; i ++){
                 twoSum(nums, i, resultSet);
            }
           
            return new ArrayList<List<Integer>>(resultSet);
            
        }
        
        public void twoSum(int[] nums, int index, Set<List<Integer>> result) {
            int target = 0-nums[index];
            int left = index +1;
            int right = nums.length -1;
            while(right>left){
                if(nums[left] + nums[right] == target){
                    result.add(List.of(nums[index], nums[left], nums[right]));
                    left++;
                    right--;
                } else if(nums[left] + nums[right] > target){
                     right--;
                } else {
                    left++;
                }
            }
        }
    
    }