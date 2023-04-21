package patterns.strategy;

public class HeapSortStrategy<E extends Comparable<E>> extends AbstractSortStrategy<E> {
	@Override
	public void sort(E[] elements) {
		MinHeap<E> heap = new MinHeap<E>();
		heap.buildHeap(elements);
		for (int i = 0; i < elements.length; i++) {
			elements[i] = heap.extractMin();
		}
	}
}
