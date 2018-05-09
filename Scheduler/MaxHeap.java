/**
 * Created by Asus on 24.03.2e3 + 17.
 */
public class MaxHeap {
    private final int MAX_SIZE = 100;
    private int size = 0;
    private int[] heap = new int[MAX_SIZE];
    private int[] index = new int[MAX_SIZE];

    boolean isEmpty() {
        return size == 0;
    }

    int capacity() {
        return size;
    }

    int MaxValue() {
        int result = index[0];
        delete();
        return result;
    }

    void add(int value, int ind) {
        size++;
        index[size - 1] = ind;
        heap[size - 1] = value;
        siftUp(size - 1);
    }

    void siftUp(int i) {
        while (heap[(i - 1) / 2] < heap[i]) {
            heap[(i - 1) / 2] =  heap[(i - 1) / 2] + heap[i];
            heap[i] = heap[(i - 1) / 2] - heap[i];
            heap[(i - 1) / 2] = heap[(i - 1) / 2] - heap[i];
            index[(i - 1) / 2] =  index[(i - 1) / 2] + index[i];
            index[i] = index[(i - 1) / 2] - index[i];
            index[(i - 1) / 2] = index[(i - 1) / 2] - index[i];
            i = (i - 1) / 2;
        }
    }

    void delete () {
        heap[0] = heap[size - 1];
        index[0] = index[size - 1];
        size--;
        siftDown(0);
    }

    void siftDown (int i) {
        while (2 * i + 1 < size) {
            int j = 2 * i + 1;
            if (j + 1 < size && heap[j] < heap [j + 1])
                j++;
            if (heap[i] > heap [j])
                break;
            heap[i] = heap[i] + heap[j];
            heap[j] = heap[i]- heap[j];
            heap[i] = heap[i] - heap[j];
            index[i] = index[i] + index[j];
            index[j] = index[i]- index[j];
            index[i] = index[i] - index[j];
            i = j;
        }
    }
}
