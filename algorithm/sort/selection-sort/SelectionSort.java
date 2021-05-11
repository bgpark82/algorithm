/**
 * 1. 가장 작은 요소를 '선택' 2. 교체
 */
class SelectionSort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 7 };
        int[] ans = selectionSort(arr);
        for (int a : ans) {
            System.out.println(a);
        }
    }

    static int[] selectionSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            int min = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

        return arr;
    }
}