package random;

import java.util.*;

class PowerSet {
    public static List<List<Integer>> powerSet(int[] nums) {
       
        Set<List<Integer>> resultSet = new HashSet<>();
        for(var i = 0; i < nums.length; i++){
            helper(nums, i, new LinkedList<>(), resultSet);
        }
        return new ArrayList<List<Integer>>(resultSet);
    }

    public static void helper(int[] nums, int index, LinkedList<Integer> current, Set<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        System.out.println(current.toString());
        if (index == nums.length) {
            return;
        }
        
        for(var i = index  ; i < nums.length; i++){
            current.add(nums[i]);
            helper(nums, i+1, current, result);
            current.pollLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(powerSet(new int[] {1, 2, 3}));
    }
}