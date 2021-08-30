package AoC2020.Day20.Task1;

import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        Input input = new Input();
        List<Image> allImages = input.createImages();
        Image test = allImages.get(0);
        System.out.println(test.getPicture());
        System.out.println("Turn");
        test.turn();
        System.out.println(test.getPicture());
    }
}
