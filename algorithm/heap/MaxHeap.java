public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.Heap = new int[this.maxSize+1];
        this.Heap[0] = Integer.MAX_VALUE;
    }

    public void insert(int element) {
        Heap[++this.size] = element;

        int current = this.size;
        // 자식이 더 큰 경우 swap -> current를 부모 노드 인덱스로 변경
        while(Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private int parent(int pos) {
        return pos/2;
    }

    private void swap(int left, int right) {
        int tmp = Heap[left];
        Heap[left] = Heap[right];
        Heap[right] = tmp;
    }
    
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
    }
}
