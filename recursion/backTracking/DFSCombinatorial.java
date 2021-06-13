package recursion.backTracking;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DFSCombinatorial {
    private static final Map<Character, char[]> KEYBOARD = Map.of('2', "abc".toCharArray(), '3', "def".toCharArray(),
            '4', "ghi".toCharArray(), '5', "jkl".toCharArray(), '6', "mno".toCharArray(), '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(), '9', "wxyz".toCharArray());

    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
      var result = new ArrayList<String>();
      letterCombinationsOfPhoneNumberHelper(digits.toCharArray(), 0, new StringBuilder(), result);
      return result;
    }

    public static void letterCombinationsOfPhoneNumberHelper(char[] digits, int digitIndex, StringBuilder path,
            List<String> result) {
        if (digitIndex == digits.length) {
            result.add(path.toString());
            return;
        }
        for(char c: KEYBOARD.get(digits[digitIndex])){
            path.append(c);
            letterCombinationsOfPhoneNumberHelper(digits, digitIndex+1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
