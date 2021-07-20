package search;

import java.util.*;

public class BinarySearch {
    public static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2; // (left+left-right)/2
            if (arr.get(mid) == target)
                return mid;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        
        return -1;
    }


    public static int peakOfMountainArray(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2; // (left+left-right)/2
            if ( (mid-1<0 || arr.get(mid)> arr.get(mid-1)) && (mid+1>= arr.size() || arr.get(mid)>arr.get(mid+1)) )
                return mid;
            if (mid-1<0 || (arr.get(mid)> arr.get(mid-1))) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }

    public static int findBoundary(boolean[] arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        
        int left = 0;
        int right = arr.length - 1;
        int boundary = -1;
        while (left <= right) {
            int mid = (left + right) / 2; // (left-right)/2 +left
            if (arr[mid]) {
                left = mid + 1;
                boundary = mid;
            } else {
                right = mid -1;
            }
        }
        return boundary;
    }


    public static int firstNotSmaller(List<Integer> arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int left = 0;
        int right = arr.size() - 1;
        int boundary = -1;

        while (left <= right) {
            int mid = (left + right) / 2; // (left+left-right)/2
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                boundary = mid;
                right = mid -1;
            }
        }
        return boundary;
    }

    public static int squareRoot(int n) {
        // WRITE YOUR BRILLIANT CODE HERE
        int left = 0;
        int right = n;
        while(left<= right){
            int mid = (left+right)/2;
            if(mid * mid<=n && (mid+1)*(mid+1) >n)return mid;
            if(mid * mid<n){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return 0;
    }

    public static int findMinRotated(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2; // (left+left-right)/2
            if(arr.get(mid) > arr.get(mid -1)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid -1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        BinarySearch.binarySearch(List.of(1,2,3,4,5,6,7), 0);
        BinarySearch.findBoundary(new boolean[]{true, false});
        BinarySearch.squareRoot(8);
        BinarySearch.findMinRotated(List.of(10, 20, 30, 40, 50));
    }
}
