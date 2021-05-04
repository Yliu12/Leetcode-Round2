import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * 1.0
 */
class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return result;
        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            var row = Arrays.asList(new Integer[i+1]);
            result.add(row);
            row.set(0, 1);
            for (int j = 1; j <= Math.floor(i / 2); j++) {
                var prevRow = result.get(i - 1);
                var numb = prevRow.get(j - 1) + prevRow.get(j);
                row.set(j, numb);
                row.set(i - j, numb);
            }
            row.set(i, 1);
        }

        return result;
    }

    public static void main(String[] args) {

        var solution = new PascalsTriangle();
        var result = solution.generate(5);
        System.out.println(result);

    }
}