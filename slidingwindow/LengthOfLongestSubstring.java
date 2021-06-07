package slidingwindow;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqChars = new HashSet<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (uniqChars.contains(s.charAt(right))) {
                uniqChars.remove(s.charAt(left));
                left ++;
            }
            uniqChars.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        (new LengthOfLongestSubstring()).lengthOfLongestSubstring("abcabcbb");
    }

}
