package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charIndext = new HashMap<>();
        for (var c : s1.toCharArray()) {
            if (charIndext.containsKey(c)) {
                charIndext.put(c, charIndext.get(c) + 1);
            } else {
                charIndext.put(c, 1);
            }
        }
        int left = 0;
        int diff = s1.length();
        for (int right = 0; right < s2.length(); right++) {
            if (right - left + 1 > s1.length()) {
                var charLeft = s2.charAt(left);
                if (charIndext.containsKey(charLeft)) {
                    if (charIndext.get(charLeft) >= 0) {
                        diff ++;
                    }
                    charIndext.put(charLeft, charIndext.get(charLeft) + 1);
                }
                left++;
            }
            var charRight = s2.charAt(right);
            if (charIndext.containsKey(charRight)) {
                var rightCount = charIndext.get(charRight);
                charIndext.put(charRight, rightCount - 1);

                if(rightCount > 0){
                    diff --;
                }
                if(diff == 0) return true;
            }
        }

        return false;
    }
}
