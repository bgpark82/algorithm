class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 7 };
        int[] ans = bubbleSort(arr);
        for (int a : ans) {
            System.out.println(a);
        }
    }

    static int[] bubbleSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {

            for (int j = i; j < size; j++) {

                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }
}