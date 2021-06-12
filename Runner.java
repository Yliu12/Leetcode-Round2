import java.util.*;

import recursion.TreeNode;

class Runner {



    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int i = 0;
        int ibound = 0;

        int j = 0;
        int jBound = n - 1;
        int direction = 0;
        // 0 right
        // 1 down
        // 2 left
        // 3 up
        boolean increaseJ = true;
        for (int x = 1; x <= n * n; x++) {
          result [i][j] = x;
          if(direction == 0){
              if(getIJ(i, j, direction)[3])
          }
        }

    }

    int changeDirection(int direction) {
        if (direction == 3)
            return 0;
        return direction++;
    }

    int[] getIJ(int i, int j,int direction){
        // 0 right
        // 1 down
        // 2 left
        // 3 up
        switch(direction){
            case 0:
            return new int[]{i, j+1  };
            case 1:
            return new int[]{i+1, j };
            case 2:
            return new int[]{i, j-1 };
            case 3:
            return new int[]{i-1, j };
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.print((new Runner()).gcdOfStrings("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM",
                "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"));
    }
}