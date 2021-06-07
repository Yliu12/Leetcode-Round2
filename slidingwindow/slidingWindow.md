


Sliding Window Template:
```
    public int SlidingWindow(String s) {

        Set<Character> uniqChars = new HashSet<>(); // set map or a sum, 
        int result = 0; // init result;
        int left = 0;   // start
        for (int right = 0; right < s.length(); right++) { // increase right pointer.
            while (uniqChars.contains(s.charAt(right))) { // move left pointer until condition satisfies.
                uniqChars.remove(s.charAt(left));
                left ++;
            }
            uniqChars.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

```





[sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem](https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/)