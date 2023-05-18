package ram;

public interface RAMComponent {

	public int read(int address);

	public void write(int address, int value);

	public int getMemorySize();

}
