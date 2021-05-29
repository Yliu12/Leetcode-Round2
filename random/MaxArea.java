package random;

import java.util.*;

public class MaxArea {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        var one = findMaxUncut(horizontalCuts, h);
        var two = findMaxUncut(verticalCuts, w);
        return (int) ((one * two) % 1000000007);
    }

    public long findMaxUncut(int[] cuts, int end) {
        Arrays.sort(cuts);
        if (cuts == null)
            return 0;
        if (cuts.length == 0)
            return end;
        long max = Math.max(cuts[0], end - cuts[cuts.length - 1]);
        for (int i = 1; i < cuts.length; i++) {
            max = Math.max(cuts[i] - cuts[i - 1], max);
        }
        return max;
    }
}
