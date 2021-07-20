package devideandcouquer;

import java.util.Arrays;

public class MergeSort {
    public int[] sortArray(int[] nums) {
        return mergeSortSlice(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);
        mergeHalves(nums, temp, left, right);
    }

    private void mergeHalves(int[] nums, int[] temp, int left, int right) {
        int leftStart = left;
        int leftEnd = (left + right) / 2;
        int rightStart = leftEnd + 1;
        int rightEnd = right;

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int sortedIndex = leftStart;
        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temp[sortedIndex] = nums[leftIndex];
                leftIndex++;
            } else {
                temp[sortedIndex] = nums[rightIndex];
                rightIndex++;
            }
            sortedIndex++;
        }

        System.arraycopy(nums, leftIndex, temp, sortedIndex, leftEnd - leftIndex + 1);
        System.arraycopy(nums, rightIndex, temp, sortedIndex, rightEnd - rightIndex + 1);
        System.arraycopy(temp, left, nums, left, right - left + 1);
    }

    public int[] mergeSortSlice(int[] nums, int left, int right) {
        if (left == right)
            return Arrays.copyOfRange(nums, left, left+1);
        int mid = (left + right) / 2;
        int[] larr = mergeSortSlice(nums, left, mid);
        int[] rarr = mergeSortSlice(nums, mid + 1, right);
        return mergeHalvesSlice(larr, rarr);
    }

    private int[] mergeHalvesSlice(int[] larr, int[] rarr) {
        var result = new int[larr.length + rarr.length];
        int mergedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < larr.length || rightIndex < rarr.length) {
            int value;
            if(leftIndex == larr.length){
                value = rarr[rightIndex];
                rightIndex ++;
            } else if(rightIndex == rarr.length){
                value = larr[leftIndex];
                leftIndex++;
            } else if(rarr[rightIndex] <= larr[leftIndex]){
                value = rarr[rightIndex];
                rightIndex ++;
            } else{
                value = larr[leftIndex];
                leftIndex++;
            }
            result[mergedIndex] = value;
            mergedIndex ++;
        }
        return result;
    }

    public static void main(String[] args) {
        var result = (new MergeSort()).sortArray(new int[] { 5, 1, 1, 2, 0, 0 });
    }
}
