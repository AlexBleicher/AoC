package AoC2022.Day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 {

    private List<Command> commands;
    private Set<Position> tailPositions;
    private Position header;
    private Position tail;
    private List<Position> nodes;

    public Day9(String input) {
        commands = new Input(input).parseInput();
        tailPositions = new HashSet<>();
        header = new Position(0, 0);
        tail = header;
        tailPositions.add(tail);
        nodes = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            nodes.add(new Position(header.getX(), header.getY(), "" + i));
        }
    }

    public int task1() {
        moveThroughCommands(1);
        return tailPositions.size();
    }

    private void moveThroughCommands(int tasknumber) {
        if (tasknumber == 1) {
            for (Command command : commands) {
                followCommand(command);
            }
        } else if (tasknumber == 2) {

            for (Command command : commands) {
                followCommand2(command);
            }
        }
    }

    private void followCommand(Command command) {
        for (int i = 0; i < command.getSteps(); i++) {
            moveHead(command.getDirection());
            moveTail();

        }
    }

    private void moveHead(Direction direction) {
        if (direction == Direction.Up) {
            header = new Position(header.getX(), header.getY() + 1);
        } else if (direction == Direction.Down) {
            header = new Position(header.getX(), header.getY() - 1);
        } else if (direction == Direction.Left) {
            header = new Position(header.getX() - 1, header.getY());
        } else if (direction == Direction.Right) {
            header = new Position(header.getX() + 1, header.getY());
        }
    }

    private void moveTail() {
        if (tail.getX() == header.getX() && tail.getY() == header.getY() + 2) { //Movedown
            tail = new Position(tail.getX(), tail.getY() - 1);
        } else if (tail.getX() == header.getX() && tail.getY() == header.getY() - 2) { //Moveup
            tail = new Position(tail.getX(), tail.getY() + 1);
        } else if (tail.getX() == header.getX() + 2 && tail.getY() == header.getY()) { //Moveleft
            tail = new Position(tail.getX() - 1, tail.getY());
        } else if (tail.getX() == header.getX() - 2 && tail.getY() == header.getY()) { //Moveright
            tail = new Position(tail.getX() + 1, tail.getY());
        } else if ((tail.getX() == header.getX() + 1 && tail.getY() == header.getY() - 2) || (tail.getX() == header.getX() + 2 && tail.getY() == header.getY() - 1)
                || (tail.getX() == header.getX() + 2 && tail.getY() == header.getY() - 2)) { //Move leftup
            tail = new Position(tail.getX() - 1, tail.getY() + 1);
        } else if ((tail.getX() == header.getX() + 1 && tail.getY() == header.getY() + 2) || (tail.getX() == header.getX() + 2 && tail.getY() == header.getY() + 1)
                || (tail.getX() == header.getX() + 2 && tail.getY() == header.getY() + 2)) { //Move leftdown
            tail = new Position(tail.getX() - 1, tail.getY() - 1);
        } else if ((tail.getX() == header.getX() - 1 && tail.getY() == header.getY() - 2) || (tail.getX() == header.getX() - 2 && tail.getY() == header.getY() - 1)
                || (tail.getX() == header.getX() - 2 && tail.getY() == header.getY() - 2)) { //Move rightup
            tail = new Position(tail.getX() + 1, tail.getY() + 1);
        } else if ((tail.getX() == header.getX() - 1 && tail.getY() == header.getY() + 2) || (tail.getX() == header.getX() - 2 && tail.getY() == header.getY() + 1)
                || (tail.getX() == header.getX() - 2 && tail.getY() == header.getY() + 2)) { //Move rightdown
            tail = new Position(tail.getX() + 1, tail.getY() - 1);
        }
        tailPositions.add(tail);
    }

    private void followCommand2(Command command) {
        for (int i = 0; i < command.getSteps(); i++) {
            moveHead(command.getDirection());
            Position nodeMoved = header;
            for (int j = 1; j < 10; j++) {
                String name = "" + j;
                Position nodeToMove = nodes.stream()
                        .filter(Position -> Position.getName().equals(name))
                        .findFirst()
                        .get();
                nodeToMove = moveOneBehind(nodeMoved, nodeToMove);
                nodes.set(j - 1, nodeToMove);
                nodeMoved = nodeToMove;

            }
        }
    }

    private Position moveOneBehind(Position node, Position nodeBehind) {
        if (nodeBehind.getX() == node.getX() && nodeBehind.getY() == node.getY() + 2) { //Movedown
            nodeBehind = new Position(nodeBehind.getX(), nodeBehind.getY() - 1, nodeBehind.getName());
        } else if (nodeBehind.getX() == node.getX() && nodeBehind.getY() == node.getY() - 2) { //Moveup
            nodeBehind = new Position(nodeBehind.getX(), nodeBehind.getY() + 1, nodeBehind.getName());
        } else if (nodeBehind.getX() == node.getX() + 2 && nodeBehind.getY() == node.getY()) { //Moveleft
            nodeBehind = new Position(nodeBehind.getX() - 1, nodeBehind.getY(), nodeBehind.getName());
        } else if (nodeBehind.getX() == node.getX() - 2 && nodeBehind.getY() == node.getY()) { //Moveright
            nodeBehind = new Position(nodeBehind.getX() + 1, nodeBehind.getY(), nodeBehind.getName());
        } else if ((nodeBehind.getX() == node.getX() + 1 && nodeBehind.getY() == node.getY() - 2) || (nodeBehind.getX() == node.getX() + 2 && nodeBehind.getY() == node.getY() - 1)
                || (nodeBehind.getX() == node.getX() + 2 && nodeBehind.getY() == node.getY() - 2)) { //Move leftup
            nodeBehind = new Position(nodeBehind.getX() - 1, nodeBehind.getY() + 1, nodeBehind.getName());
        } else if ((nodeBehind.getX() == node.getX() + 1 && nodeBehind.getY() == node.getY() + 2) || (nodeBehind.getX() == node.getX() + 2 && nodeBehind.getY() == node.getY() + 1)
                || (nodeBehind.getX() == node.getX() + 2 && nodeBehind.getY() == node.getY() + 2)) { //Move leftdown
            nodeBehind = new Position(nodeBehind.getX() - 1, nodeBehind.getY() - 1, nodeBehind.getName());
        } else if ((nodeBehind.getX() == node.getX() - 1 && nodeBehind.getY() == node.getY() - 2) || (nodeBehind.getX() == node.getX() - 2 && nodeBehind.getY() == node.getY() - 1)
                || (nodeBehind.getX() == node.getX() - 2 && nodeBehind.getY() == node.getY() - 2)) { //Move rightup
            nodeBehind = new Position(nodeBehind.getX() + 1, nodeBehind.getY() + 1, nodeBehind.getName());
        } else if ((nodeBehind.getX() == node.getX() - 1 && nodeBehind.getY() == node.getY() + 2) || (nodeBehind.getX() == node.getX() - 2 && nodeBehind.getY() == node.getY() + 1)
                || (nodeBehind.getX() == node.getX() - 2 && nodeBehind.getY() == node.getY() + 2)) { //Move rightdown
            nodeBehind = new Position(nodeBehind.getX() + 1, nodeBehind.getY() - 1, nodeBehind.getName());
        }

        if (nodeBehind.getName().equals("9")) {
            tailPositions.add(nodeBehind);
        }
        return nodeBehind;
    }

    public int task2() {
        moveThroughCommands(2);
        return tailPositions.size();
    }

}
