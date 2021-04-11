import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * 1.0
 */
class PascalsTriangle2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return result;
        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            var row = new ArrayList<Integer>();
            result.add(row);
            row.add(0, 1);
            for (int j = 1; j < i; j++) {
                var prevRow = result.get(i - 1);
                row.add(j, prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(i, 1);
        }

        return result;
    }

    public static void main(String[] args) {

        var solution = new PascalsTriangle();
        var result = solution.generate(5);
        System.out.println(result);

    }
}