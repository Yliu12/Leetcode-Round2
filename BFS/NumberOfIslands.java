package BFS;

import java.util.HashSet;
import java.util.Set;
// TODO
public class NumberOfIslands {
    private Set<String> seen = new HashSet<>();

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                seen.add(i + "" + j);
            
            }

        }
        return 0;
    }
}
