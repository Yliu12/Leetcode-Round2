package slidingwindow;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i ++){
            char now = s.charAt(i);

            if(lastIndexMap.get(now)!= null){
                start = Math.max((lastIndexMap.get(now) +1), start);
            }
            int currentLength = i - start +1;
            max = Math.max(currentLength, max);
            lastIndexMap.put(now, i);
        }
        return max;
    }
}
