package AoC2022.Day8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {

    private List<Tree> trees;

    public Day8(String input) {
        trees = new Input(input).parseInput();
    }

    public long task1() {
        return trees.stream()
                .filter(Tree -> isVisible(Tree))
                .count();
    }

    private boolean isVisible(Tree tree) {

        List<Tree> allTreesLeftOfTree = trees.stream()
                .filter(Tree -> (Tree.getX() < tree.getX() && Tree.getY() == tree.getY()) && Tree.getHeight() >= tree.getHeight())
                .collect(Collectors.toList());
        if (allTreesLeftOfTree.isEmpty()) {
            return true;
        }

        List<Tree> allTreesRightOfTree = trees.stream()
                .filter(Tree -> (Tree.getX() > tree.getX() && Tree.getY() == tree.getY()) && Tree.getHeight() >= tree.getHeight())
                .collect(Collectors.toList());
        if (allTreesRightOfTree.isEmpty()) {
            return true;
        }

        List<Tree> allTreesTopOfTree = trees.stream()
                .filter(Tree -> (Tree.getY() < tree.getY() && Tree.getX() == tree.getX()) && Tree.getHeight() >= tree.getHeight())
                .collect(Collectors.toList());
        if (allTreesTopOfTree.isEmpty()) {
            return true;
        }

        List<Tree> allTreesBottomOfTree = trees.stream()
                .filter(Tree -> (Tree.getY() > tree.getY() && Tree.getX() == tree.getX()) && Tree.getHeight() >= tree.getHeight())
                .collect(Collectors.toList());
        return allTreesBottomOfTree.isEmpty();
    }

    private int getScenicScoreOfTree(Tree tree) {
        List<Tree> allTreesLeftOfTree = trees.stream()
                .filter(Tree -> Tree.getX() < tree.getX() && Tree.getY() == tree.getY())
                .sorted(Comparator.comparingInt(Tree::getX))
                .collect(Collectors.toList());
        int scoreLeft = 0;
        boolean stopped = false;
        for (int i = allTreesLeftOfTree.size() - 1; i >= 0 && !stopped; i--) {
            Tree treeLeft = allTreesLeftOfTree.get(i);
            scoreLeft++;
            if (treeLeft.getHeight() >= tree.getHeight()) {
                stopped = true;
            }
        }
        tree.addToScenicScore(scoreLeft);

        List<Tree> allTreesRightofTree = trees.stream()
                .filter(Tree -> Tree.getX() > tree.getX() && Tree.getY() == tree.getY())
                .sorted(Comparator.comparingInt(Tree::getX))
                .collect(Collectors.toList());
        int scoreRight = 0;
        stopped = false;
        for (int i = 0; i < allTreesRightofTree.size() && !stopped; i++) {
            Tree treeLeft = allTreesRightofTree.get(i);
            scoreRight++;
            if (treeLeft.getHeight() >= tree.getHeight()) {
                stopped = true;
            }
        }
        tree.addToScenicScore(scoreRight);

        List<Tree> allTreesTopOfTree = trees.stream()
                .filter(Tree -> Tree.getY() < tree.getY() && Tree.getX() == tree.getX())
                .sorted(Comparator.comparingInt(Tree::getX))
                .collect(Collectors.toList());
        int scoreTop = 0;
        stopped = false;
        for (int i = allTreesTopOfTree.size() - 1; i >= 0 && !stopped; i--) {
            Tree treeLeft = allTreesTopOfTree.get(i);
            scoreTop++;
            if (treeLeft.getHeight() >= tree.getHeight()) {
                stopped = true;
            }
        }
        tree.addToScenicScore(scoreTop);

        List<Tree> allTreesBottomofTree = trees.stream()
                .filter(Tree -> Tree.getY() > tree.getY() && Tree.getX() == tree.getX())
                .sorted(Comparator.comparingInt(Tree::getX))
                .collect(Collectors.toList());
        int scoreBottom = 0;
        stopped = false;
        for (int i = 0; i < allTreesBottomofTree.size() && !stopped; i++) {
            Tree treeLeft = allTreesBottomofTree.get(i);
            scoreBottom++;
            if (treeLeft.getHeight() >= tree.getHeight()) {
                stopped = true;
            }
        }
        tree.addToScenicScore(scoreBottom);

        return tree.getScenicScore();
    }

    public long task2() {
        return trees.stream()
                .map(this::getScenicScoreOfTree)
                .max(Comparator.comparingInt(Integer::intValue))
                .get();

    }
}
