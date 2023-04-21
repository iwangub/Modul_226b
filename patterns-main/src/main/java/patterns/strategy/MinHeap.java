package patterns.strategy;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class MinHeap<E extends Comparable<E>> {
    private ArrayList<E> heap;
    private int size;

    /**
     * Konstruktor der Klasse MinHeap
     */
    public MinHeap() {
        heap = new ArrayList<>();
        size = 0;
    }
    
    /**
     * Erstellt einen Min-Heap aus einem Array von Elementen, 
     * indem jedes Element zum Heap hinzugefügt wird und dann 
     * die Heap-Eigenschaft wiederhergestellt wird.
     * 
     * @param elements die Elemente des Heaps
     */
    public void buildHeap(E[] elements) {
        clear();
        for (E e : elements) {
            insert(e);
        }
    }

    /**
     * Fügt ein neues Element zum Heap hinzu und stellt sicher, 
     * dass die Heap-Eigenschaften beibehalten werden, indem das Element 
     * so lange nach oben verschoben wird, bis sein Elternelement kleiner ist
     * oder bis es die Wurzel erreicht.
     * @param e das Element welches eingefügt wird.
     */
    public void insert(E e) {
        heap.add(e);
        size++;
        heapifyUp(size - 1);
    }

    public E extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap ist leer!");
        }

        E removed = heap.get(0);
        heap.set(0, heap.get(size - 1));
        heap.remove(size - 1);
        size--;
        heapifyDown(0);

        return removed;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap ist leer");
        }

        return heap.get(0);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        heap.clear();
        size = 0;
    }

    @SuppressWarnings("unchecked")
	public E[] toArray() {
        return heap.toArray((E[])new Comparable[size]);
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        if (index > 0 && heap.get(index).compareTo(heap.get(parent)) < 0) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }

        if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

