public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 7 };
        int[] ans = quickSort(arr, 0, 4);
        for (int a : ans) {
            System.out.println(a);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {

            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++; right--;
            }
        }

        return left;
    }

    static int[] quickSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = partition(arr, left, right);

            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }

        return arr;
    }
}
