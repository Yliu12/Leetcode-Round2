package random;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;

        int currentLeftIndex = 0;
        int currentRightIndex = height.length - 1;
        while (currentLeftIndex < currentRightIndex) {
            int currentLeftVal = height[currentLeftIndex];
            int currentRightVal = height[currentRightIndex];
            area = Math.max( Math.min(currentLeftVal, currentRightVal) * (currentRightIndex - currentLeftIndex), area);

            if (currentLeftVal > currentRightVal) {
                currentRightIndex--;
            } else {
                currentLeftIndex++;
            }
        }
        return area;
    }
    public static void main(String[] args){
      System.out.println( new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
