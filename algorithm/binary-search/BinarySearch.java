public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int index = binarySearch(arr, 0, 6, 4);
        System.out.println(index);
    }

    static int binarySearch(int[] arr, int left, int right, int target) {
        if(left <= right) {
            int mid = (left + right)/2;

            if(arr[mid] == target) {
                return mid;
            }

            if(arr[mid] > target) {
                return binarySearch(arr, left, mid-1, target);
            }
            binarySearch(arr, mid+1, right, target);
        }

        return -1;
    }
}
