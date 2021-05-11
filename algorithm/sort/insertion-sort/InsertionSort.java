public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 7 };
        int[] ans = insertionSort(arr);
        for (int a : ans) {
            System.out.println(a);
        }
    }

    static int[] insertionSort(int[] arr) {
        int size = arr.length;

        for (int i = 1; i < size; i++) {
            int curr = arr[i];

            int j = i - 1;
            for (; j >= 0 && curr < arr[j]; --j) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = curr;
        }

        return arr;
    }
}
