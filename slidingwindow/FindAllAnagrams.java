package slidingwindow;

import java.util.*;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        var result = new ArrayList<Integer>();

        HashMap<Character, Integer> mapOfP = new HashMap<>();
        for (var c : p.toCharArray()) {
            if (mapOfP.containsKey(c)) {
                mapOfP.put(c, mapOfP.get(c) + 1);
            } else {
                mapOfP.put(c, 1);
            }
        }
        HashSet<String> memory = new HashSet<>();
        memory.add(p);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (isAnagram(new HashMap<>(mapOfP), memory, s.substring(i, i + p.length()))) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isAnagram(Map<Character, Integer> map, Set<String> memory, String s) {
        if (memory.contains(s))
            return true;
        for (var c : s.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            if (map.get(c) == 1)
                map.remove(c);
            else
                map.put(c, map.get(c) - 1);
        }
        if (map.isEmpty()) {
            memory.add(s);
            return true;
        }
        return false;
    }

    public List<Integer> findAnagramsSlidingWindow(String s, String p) {
        var result = new ArrayList<Integer>();
        int[] dict = new int[26];
        for (var c : p.toCharArray()) {
            dict[c - 'a'] = dict[c - 'a'] + 1;
        }
        int diff = p.length();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if(right - left >= p.length()){
                dict[s.charAt(left) - 'a'] ++;
                if(dict[s.charAt(left) - 'a']>0) diff ++;
                left++;
            }
            
            dict[s.charAt(right) - 'a'] --;
            if (dict[s.charAt(right) - 'a'] >= 0) {
                diff --;
            };
            if (diff == 0)
                result.add(left);
        }

        return result;
    }

    public static void main(String[] args) {
        (new FindAllAnagrams()).findAnagramsSlidingWindow("ababababab", "aab");
    }
}
