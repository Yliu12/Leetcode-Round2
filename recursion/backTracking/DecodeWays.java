package recursion.backTracking;

import java.util.*;
import java.util.stream.*;

public class DecodeWays {
    private static final List<String> LETTERS = IntStream.range(1, 27).mapToObj(Integer::toString)
            .collect(Collectors.toList());

    public static int decodeWays(String digits) {
        return decodeWaysHelper(digits, new HashMap<String, Integer>());
    }

    public static int decodeWaysHelper(String digits, Map<String, Integer> memo) {
        if (digits == null || digits.length() == 0)
            return 1;
        var num = Integer.parseInt(digits);
        if (num < 27) {
            if (num > 10)
                return 2;
            return 1;
        }
        int counter = 0;
        for (String prefix : LETTERS) {
            if (digits.startsWith(prefix)) {
                String left = digits.substring(prefix.length());
                int ways;
                if (memo.containsKey(left)) {
                    ways = memo.get(left);
                } else {
                    ways = decodeWaysHelper(left, memo);
                    memo.put(left, ways);
                }
                counter += ways;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        scanner.close();
        int res = decodeWays(digits);
        System.out.println(res);
    }
}
