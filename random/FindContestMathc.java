package random;
import java.util.*;


public class FindContestMathc {
    public static String findContestMatch(int n) {
        List<String> matches = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            matches.add(String.valueOf(i));
        while (matches.size() != 1) {
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < matches.size() / 2; i++) {
                newList.add("("+matches.get(i)+ ","+ matches.get(matches.size()-1 -i) + ")");
            }
            matches = newList;

        }
        return matches.get(0);
    }

}
