package yym.svydovets.dataStructure;

/*
 * Build max heap with heapify method
 */
public class Heap {


    public void buildHeap(int[] arr, int n) {
        int startIdx = (n/2) - 1; //last non-leaf node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
    private void heapify(int[] arr, int n, int idx) {
        int largest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != idx) {
            int tmp = arr[idx];
            arr[idx] = arr[largest];
            arr[largest] = tmp;

            heapify(arr, n, largest);
        }
    }

    public void printHeap(int[] arr, int n) {
        System.out.println("Array representation of Heap is:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int N = arr.length;

        final Heap heap = new Heap();
        heap.buildHeap(arr, N);
        heap.printHeap(arr, N);
    }




}
