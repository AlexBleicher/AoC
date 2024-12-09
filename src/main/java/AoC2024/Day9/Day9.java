package AoC2024.Day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day9 {

    private List<File> files;

    public Day9(String i) {
        files = new Input(i).parseInput();
    }

    public long task1() {
        List<File> reorderedFiles = new ArrayList<>();
        System.out.println(countNotFree(files));
        int indexToMoveForwardNext = files.size() - 1;
        for (int i = 0; i < files.size() && indexToMoveForwardNext >= i && countNotFree(files) != countNotFree(reorderedFiles); i++) {
            File file = files.get(i);
            if (!file.isFree()) {
                reorderedFiles.add(file);
            } else {
                File file1 = files.get(indexToMoveForwardNext--);
                while (file1.isFree()) {
                    file1 = files.get(indexToMoveForwardNext--);
                }
                reorderedFiles.add(file1);

            }
        }
        System.out.println(countNotFree(reorderedFiles));
        long checksum = 0;
        for (int i = 0; i < reorderedFiles.size(); i++) {
            checksum += (long) i * reorderedFiles.get(i).getId();
        }
        return checksum;
    }

    public long task2() {
        List<File> reorderedFiles = new ArrayList<>(files);
        System.out.println(countNotFree(files));
        List<Block> fileBlocks = new ArrayList<>();
        List<Block> freeBlocks = new ArrayList<>();

        for (int i = 0; i < files.size(); ) {
            File file = files.get(i);
            int startOfBlock = i;
            int blockSize = 0;
            if (file.isFree()) {
                while (i < files.size() && files.get(i).isFree()) {
                    i++;
                    blockSize++;
                }
                freeBlocks.add(new Block(startOfBlock, blockSize, 0));
            } else {
                while (i < files.size() && !files.get(i).isFree() && files.get(i).getId() == file.getId()) {
                    i++;
                    blockSize++;
                }
                fileBlocks.add(new Block(startOfBlock, blockSize, file.getId()));
            }
        }

        fileBlocks.sort(Comparator.comparingInt(Block::getBlockId));
        Collections.reverse(fileBlocks);

        for (Block fileBlock : fileBlocks) {
            boolean inserted = false;
            for (Block freeBlock : freeBlocks) {
                if (!inserted) {
                    if (freeBlock.getBlockSize() >= fileBlock.getBlockSize() && freeBlock.getStartIndex() < fileBlock.getStartIndex()) {
                        for (int i = freeBlock.getStartIndex(); i < freeBlock.getStartIndex() + fileBlock.getBlockSize(); i++) {
                            reorderedFiles.set(i, new File(false, fileBlock.getBlockId()));
                        }
                        freeBlock.setStartIndex(freeBlock.getStartIndex() + fileBlock.getBlockSize());
                        freeBlock.setBlockSize(freeBlock.getBlockSize() - fileBlock.getBlockSize());
                        for (int i = fileBlock.getStartIndex(); i < fileBlock.getStartIndex() + fileBlock.getBlockSize(); i++) {
                            reorderedFiles.set(i, new File(true, 0));
                        }
                        inserted = true;
                    }
                }
            }
        }
        printOutFileSystem(reorderedFiles);
        System.out.println(countNotFree(reorderedFiles));
        long checksum = 0;
        for (int i = 0; i < reorderedFiles.size(); i++) {
            File file = reorderedFiles.get(i);
            if (!file.isFree()) {
                checksum += (long) i * file.getId();
            }
        }
        return checksum;
    }

    private long countNotFree(List<File> fileSystem) {
        long res = 0;
        for (File file : fileSystem) {
            if (!file.isFree()) {
                res++;
            }
        }
        return res;
    }

    private void printOutFileSystem(List<File> files) {
        String output = "";
        for (File reorderedFile : files) {
            if (reorderedFile.isFree()) {
                output += ".";
            } else {
                output += reorderedFile.getId();
            }
        }
        System.out.println(output);
    }
}
