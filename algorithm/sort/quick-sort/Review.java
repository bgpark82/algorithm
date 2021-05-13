public class Review {
    
    public static void main(String[] args) {
        int[] arr = {6,1,3,5,9,4};
        quickSort(arr, 0, arr.length-1);

    }

    static void quickSort(int[] arr, int left, int right) {
        int mid = partition(arr, left, right);

        // 왜 mid -1이지??
        quickSort(arr, left, mid-1);
        quickSort(arr, mid+1, right);
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = (left+right)/2;

        while(left <= right) {
            while(arr[left] < arr[pivot]) left++;
            while(arr[right] > arr[pivot]) right--;
            if(left <= right) {
                swap(arr, left, right);
                left++; right--;
            }
        }

        return left;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
