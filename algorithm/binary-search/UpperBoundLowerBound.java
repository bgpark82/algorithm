public class UpperBoundLowerBound {
    
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,4,5};
        System.out.println(lowerBound(arr, 3));    
        System.out.println(upperBound(arr, 3));
    }

    static int lowerBound(int[] arr, int x) {

        int left = 0;
        int right = arr.length-1;
        int ans = 0;

        while(left <= right) {
            int mid = (left + right)/2;

            if(arr[mid] == x) {
                ans = mid;
                right = mid-1; // 하한의 첫번째값을 찾을 때까지 내려간다 
            } else if(arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static int upperBound(int[] arr, int x) {

        int left = 0;
        int right = arr.length-1;
        int ans = 0;

        while(left <= right) {
            int mid = (left + right)/2;

            if(arr[mid] == x) {
                ans = mid+1; // 일치하는 값보다 한단계 위
                left = mid+1;
            } else if(arr[mid] < x) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return ans;
    }
}
