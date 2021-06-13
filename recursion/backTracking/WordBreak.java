package recursion.backTracking;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> words) {
        return wordBreakHelper(s, new HashSet<String>(words), new HashSet<String>());
    }

    public static boolean wordBreakHelper(String s, Set<String> words, Set<String> notWord) {
        if (s.length() == 0)
            return true;
        for (int i = 0; i < s.length() + 1; i++) {
            String first = s.substring(0, i);
            if (words.contains(first)) {
                String rest = s.substring(i, s.length());
                if (notWord.contains(rest))
                    continue;
                boolean isWord = words.contains(rest) ? true : wordBreakHelper(rest, words, notWord);
                if (isWord) {
                    words.add(rest);
                    words.add(s);
                    return true;
                }
                notWord.add(rest);
                notWord.add(s);
            }
        }
        return false;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }
}
