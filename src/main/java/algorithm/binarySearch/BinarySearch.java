package algorithm.binarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        // int index = binarySearch(arr, 0, 6, 4);
        int index = binarySearch2(arr, 4);
        System.out.println(index);
    }

    // 1. dynamic programming
    static int binarySearch(int[] arr, int left, int right, int target) {
        if(left <= right) {
            int mid = (left + right)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) return binarySearch(arr, left, mid-1, target);
            binarySearch(arr, mid+1, right, target);
        }

        return -1;
    }

    // 2. for
    static int binarySearch2(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] == x) return mid;
            if(arr[mid] < x) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
