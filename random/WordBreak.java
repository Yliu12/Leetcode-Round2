package random;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return isWord(s, wordSet, 0, new Boolean[s.length()]);

    }

    public boolean isWord(String s, Set<String> wordSet,int start, Boolean[] result){
        if(start == s.length())return true;
        if(result[start] != null) return result[start];
        for(int i = start+1; i <= s.length(); i++){
            if(wordSet.contains(s.substring(start, i)) && isWord(s, wordSet, i, result)){
                result[start] = true;
                return true;
            }
        }
        result[start] = false;
        return false;
    }
}
