package ram;

public class Accumulator implements RAMComponent{
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

    @Override
    public int read(int address) {
        throw new UnsupportedOperationException("Accumulator does not support read operation.");
    }

    @Override
    public void write(int address, int value) {
        throw new UnsupportedOperationException("Accumulator does not support write operation.");
    }

    @Override
    public int getMemorySize() {
        throw new UnsupportedOperationException("Accumulator does not have memory size.");
    }
}
