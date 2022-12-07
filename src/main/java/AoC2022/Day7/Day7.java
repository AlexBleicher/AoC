package AoC2022.Day7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Day7 {

    private List<Command> commandList;

    public Day7(String input) {
        this.commandList = new Input(input).parseInput();
    }

    public long task1() {
        List<Directory> allDirs = new ArrayList<>();
        allDirs.add(new Directory("/"));
        fillAllDirs(allDirs);
        return allDirs.stream()
                .filter(Directory -> Directory.getSize() <= 100000)
                .mapToLong(Directory::getSize).sum();
    }

    public long task2() {
        List<Directory> allDirs = new ArrayList<>();
        allDirs.add(new Directory("/"));
        fillAllDirs(allDirs);
        long totalSpace = allDirs.get(0).getSize();
        long spaceFree = 70000000 - totalSpace;
        long spaceNeeded = 30000000 - spaceFree;
        return allDirs.stream()
                .filter(Directory -> Directory.getSize() >= spaceNeeded)
                .min(Comparator.comparingLong(Directory::getSize))
                .get()
                .getSize();
    }

    private void fillAllDirs(List<Directory> allDirs) {
        Directory currentDir = allDirs.get(0);
        for (Command command : commandList) {
            if (command.changesDir()) {
                if (command.getContent().equals("..") && currentDir.getParent() != null) {
                    currentDir = currentDir.getParent();
                } else {
                    if (command.getContent().equals("/")) {
                        currentDir = allDirs.get(0);
                    } else {
                        Optional<Directory> subDirToMoveIn = currentDir.getSubDirs().stream()
                                .filter(Directory -> Directory.getName().equals(command.getContent()))
                                .findFirst();
                        if(subDirToMoveIn.isPresent()) {
                            subDirToMoveIn.get().setParent(currentDir);
                            currentDir = subDirToMoveIn.get();
                        }
                    }
                }
            } else {
                String contendOfCurrentDir = command.getContent();
                String[] linesOfContent = contendOfCurrentDir.split("\n");
                for (String s : linesOfContent) {
                    if (s.startsWith("dir")) {
                        String[] subdir = s.split(" ");
                        String nameOfSubdir = subdir[1];
                        Directory newDir = new Directory(nameOfSubdir);
                        allDirs.add(newDir);
                        currentDir.addSubDir(newDir);
                    } else {
                        String[] fileString = s.split(" ");
                        long size = Long.parseLong(fileString[0]);
                        Optional<File> file = currentDir.getSubFiles().stream()
                                .filter(File -> File.getName().equals(fileString[1]))
                                .findFirst();
                        if (file.isEmpty()) {
                            currentDir.addSubFile(new File(size, fileString[1]));
                        }
                    }
                }
            }
        }
    }
}
