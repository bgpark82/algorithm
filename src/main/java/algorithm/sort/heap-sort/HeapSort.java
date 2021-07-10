public class HeapSort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 7 };
        int[] ans = heapSort(arr);
        for (int a : ans) {
            System.out.println(a);
        }
    }

    static int[] heapSort(int[] arr) {
        int size = arr.length;

        for(int i = size/2-1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        for(int i = size-1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }

        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void heapify(int[] arr, int size, int root) {
        int parent = root; 
        int left = 2*root+1;
        int right = 2*root+2;

        if(left < size && arr[parent] < arr[left]) {
            parent = left;
        }        
        if(right < size && arr[parent] < arr[right]) {
            parent = right;
        }
        if(parent != root) {
            int tmp = arr[root];
            arr[root] = arr[parent];
            arr[parent] = tmp;

            heapify(arr, size, parent);
        }
    }
    
}
