package AoC2024.Day9;

public class Block {
    private int startIndex;
    private int blockSize;

    private int blockId;

    public Block(int startIndex, int blockSize, int blockId) {
        this.startIndex = startIndex;
        this.blockSize = blockSize;
        this.blockId = blockId;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getBlockId() {
        return blockId;
    }
}
