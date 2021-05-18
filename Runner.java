import java.util.*;
class Runner {

    /*
     * Complete the 'itemsSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY items as parameter.
     */

    public static int fourthBit(int number) {
        String str = Integer.toBinaryString(number);
        try{
            System.out.println(str);
            if(str.length() < 4){
                return 0;
            }
            System.out.println(str.charAt(str.length() - 4)+"");

           return Integer.parseInt(str.charAt(str.length() - 4)+"");

        }catch(Exception e){
            return 0;
        }
  
      }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valIndexMap = new HashMap<>();
         for(int i = 0; i < nums.length; i++) {
            valIndexMap.put(nums[i], i);
 
             int two = nums[i];
             int one = target-two;
 
             if(valIndexMap.get(one) != null){
                 return new int[]{valIndexMap.get(one), i};
             }
 
        }
         return new int[]{0, 0};
 
     }
     public static void main(String[] args) {
        // new Runner().twoSum(new int[]{3,2,4}, 6);
        // new Runner().lengthOfLongestSubstring("aabaab!bb");
    }
}