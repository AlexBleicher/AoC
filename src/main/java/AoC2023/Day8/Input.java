package AoC2023.Day8;

import java.util.HashMap;
import java.util.Map;

public class Input {

    private String input;

    public Input(String i) {
        input = i;
    }

    public Map<String, Node> parseInput() {
        String[] s = input.split("\n");
        Map<String, Node> map = new HashMap<>();
        for (String string : s) {
            String[] split1 = string.split(" = ");
            map.put(split1[0], new Node(split1[0]));
        }
        for (String string : s) {
            String[] split1 = string.split(" = ");
            String[] s1 = split1[1].split(", ");
            Node left = map.get(s1[0].substring(1));
            String help = s1[1].substring(0, 3);
            Node right = map.get(help);
            Node node = map.get(split1[0]);
            node.setLeft(left);
            node.setRight(right);
        }
        return map;
    }

}
