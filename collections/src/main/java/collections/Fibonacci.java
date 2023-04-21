package collections;

import java.util.Iterator;

public class Fibonacci implements Iterable<Integer> {

	private int n;

	public Fibonacci(int n) {
		this.n = n;
	}

	public Iterator<Integer> iterator() {
		return new FibonacciIterator(n);
	}

	private class FibonacciIterator implements Iterator<Integer> {

		int cnt;
		int x1;
		int x2;

		public FibonacciIterator(int scope) {
			this.cnt = scope;
			this.x1 = 1;
			this.x2 = 1;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cnt > 0;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			int res = x1;
			x1 = x2;
			x2 += res;
			cnt--;
			return res;
		}

	}

	public static void main(String[] args) {

		Fibonacci fibo = new Fibonacci(20);

		int last = 1;

		for (Integer i : fibo) {
			System.out.println(i / (last * 1.0)); // Golden Ratio
			last = i;
		}
	}

}
