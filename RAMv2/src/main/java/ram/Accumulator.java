package ram;

public class Accumulator {
	private int data;

	public Accumulator() {
	}

	public int get() {
		return data;
	}

	public void load(int data) {
		this.data = data;
	}

	public void add(int data) {
		this.data += data;
	}

	public void subtract(int data) {
		this.data -= data;
	}
}
