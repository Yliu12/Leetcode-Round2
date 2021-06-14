package twopointers.slidingwindow;

import java.util.*;

public class LengthOfLongestSubstringTwoDisdinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length()< 1){
            return 0;
        }
        int result = 1;
        int left = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int right = 0; right < s.length(); right ++) {
            char charAtRight = s.charAt(right);
            while (!hs.containsKey(charAtRight) && hs.size() ==2) {
                var lastLeftIndex = hs.get(s.charAt(left));
                if(lastLeftIndex == left){
                    hs.remove(s.charAt(left));
                }
                left ++;
            }
            result = Math.max(result, right - left +1);
            hs.put(charAtRight, right);
        }
        return result;
    }
}
