package dynamicprogramming;

public class NumberRollsToTarget {
    public int numRollsToTarget(int d, int f, int target) {
        return (int) numRollsToTargetHelper(d, f, target, new Long[target], 0);
    }

    public long numRollsToTargetHelper(int d, int f, int target, Long[] memo, int sum) {
        if(d ==1){
            if(target - sum <=f) return 1;
            return 0;
        }
        
        long counter = 0;
        for (int i = 1; i <= f; i++) {
            long ways = memo[sum] == null ? numRollsToTargetHelper(d - 1, f, target, memo, sum+i) : memo[sum];
            if (ways != 0)
                memo[sum+i] = ways;
            counter += ways;
        }
        return counter;
    }

    public static void main(String[] args) {
       System.out.println( (new NumberRollsToTarget()).numRollsToTarget(30, 30, 500));
    }
}
