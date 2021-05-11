public class MergeSort {
    
    public static int[] arr = { 5, 2, 1, 3, 7 };
    
    public static void main(String[] args) {
        
        mergeSort(arr, 4);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    static void mergeSort(int[] arr, int size) {
        if(size < 2) {
            return;
        }

        int mid = size/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[size - mid];

        for(int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for(int j = mid; j < size; j++) {
            rightArr[j-mid] = arr[j];
        }

        mergeSort(leftArr, mid);
        mergeSort(rightArr, size-mid);

        merge(arr, leftArr, rightArr, mid, size-mid);
    }

    static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0, j = 0, k = 0;

        while(i < left && j < right) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];       
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while(i < left) {
            arr[k++] = leftArr[i++];
        }

        while(j < right) {
            arr[k++] = rightArr[j++];
        }
    }
}
