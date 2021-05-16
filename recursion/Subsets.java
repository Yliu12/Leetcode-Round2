import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> powerSet = new HashSet<List<Integer>>();
        List<Integer> startSet = IntStream.of(nums).boxed().collect(Collectors.toList());
        findSubsets(startSet, powerSet);
        return powerSet.stream().collect(Collectors.toList());
    }

    public void findSubsets(List<Integer> subset, Set<List<Integer>> powerSet) {
        powerSet.add(subset);
        if (subset.isEmpty()) {
            return;
        }

        for (int i = 0; i < subset.size(); i++) {
            ArrayList<Integer> copy = (new ArrayList<Integer>(subset));
             copy.remove(copy.get(i));
            findSubsets(copy, powerSet);
        }
    }

    public static void main(String[] args) {
        (new Subsets()).subsets(new int[] { 1, 2, 3 });
    }
}
