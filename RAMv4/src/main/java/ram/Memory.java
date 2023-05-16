package ram;

public class Memory {
    private int[] memory;

    public Memory(int size) {
        memory = new int[size];
    }

    public void write(int address, int value) {
        memory[address] = value;
    }

    public int read(int address) {
        return memory[address];
    }

    public int getMemorySize() {
        return memory.length;
    }
}
