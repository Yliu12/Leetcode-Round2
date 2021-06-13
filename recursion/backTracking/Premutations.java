package recursion.backTracking;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Premutations {
    public static List<List<Character>> permute(char[] letters) {
        var result = new  ArrayList<List<Character>>();
        var set = new HashSet<Character>();
        IntStream.range(0, letters.length).forEach(i->set.add(letters[i]));
        permute(result, set, new ArrayList<>());
        return result;
    }

    public static void permute(List<List<Character>> result, Set<Character> left, List<Character> path) {
        if (left.isEmpty()) {
            result.add(new ArrayList<Character>(path));
            return;
        }
        var copy = new HashSet<>(left);
        for (var c : left) {
            copy.remove(c);
            path.add(c);
            permute(result, copy, path);
            path.remove(path.size() - 1);
            copy.add(c);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        scanner.close();
        List<List<Character>> permutations = permute(input);
        System.out.println(
            permutations.stream()
                .map(chars -> chars.stream().map(String::valueOf).collect(Collectors.joining()))
                .collect(Collectors.joining(" "))
        );
    }
}
