package twopointers;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveDuplicats {
    public static int removeDuplicates(List<Integer> arr) {
        return removeDuplicatesReturnList(arr).size();
    }

    public static List<Integer> removeDuplicatesReturnList(List<Integer> arr) {
        if (arr == null || arr.size() < 0)
            return null;
        if (arr.size() == 1)
            return arr;

        int i = 0;
        for (int j = 0; j < arr.size(); j++) {
            if (arr.get(i) != arr.get(j)) {
                i++;
                arr.set(i, arr.get(j));
            }  
        }
        return arr.subList(0, i + 1);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = removeDuplicates(arr);
        System.out.println(arr.stream().limit(res).map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
