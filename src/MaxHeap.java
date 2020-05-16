public class MaxHeap {
    public static final int HEAP_SIZE = 100;
    int[] heap = new int[HEAP_SIZE];
    int size;

    public void insert(int n) {
        if (size == heap.length) {
            int[] newHeap = new int[heap.length * 2];
            cloneArray(heap, newHeap);
            heap = newHeap;
        }

        int currentPosition = size;
        int parent = (size - 1) / 2;

        heap[size++] = n;

        while (parent >= 0 && currentPosition >= 0) {
            if (heap[parent] < heap[currentPosition]) {
                swapInArray(heap, currentPosition, parent);
                currentPosition = parent;
            } else {
                break;
            }
        }

    }

    public int delete() {
        if (size == 0) {
            // Nothing to delete
            return Integer.MIN_VALUE;
        }

        int n = heap[0];
        heap[0] = heap[--size];
        heap[size] = -1;

        int currentPosition = 0;
        int left = 1;
        int right = 2;

        while (heap[currentPosition] < heap[left] && heap[currentPosition] < heap[right] && left < size && right < size) {
            if (heap[left] > heap[right]) {
                swapInArray(heap, currentPosition, left);
                currentPosition = left;
            } else {
                swapInArray(heap, currentPosition, right);
                currentPosition = right;
            }
            // Update left, right
            left = currentPosition * 2 + 1;
            right = currentPosition * 2 + 2;
        }

        return n;
    }

    private void cloneArray(int[] arr, int[] newArr) {
        for (int i=0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
    }

    private void swapInArray(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
