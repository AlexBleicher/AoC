package AoC2022.Day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory {

    private String name;
    private List<Directory> subDirs;
    private List<File> subFiles;
    private Directory parent;

    public Directory(String name) {
        this.name = name;
        subDirs = new ArrayList<>();
        subFiles = new ArrayList<>();
    }

    public void addSubDir(Directory dir) {
        subDirs.add(dir);
    }

    public void addSubFile(File file) {
        subFiles.add(file);
    }

    public long getSize() {
        long size = 0;
        size += subDirs.stream()
                .mapToLong(Directory::getSize).sum();
        size += subFiles.stream()
                .mapToLong(File::getSize).sum();
        return size;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public List<Directory> getSubDirs() {
        return subDirs;
    }

    public String getName() {
        return name;
    }

    public List<File> getSubFiles() {
        return subFiles;
    }
}
