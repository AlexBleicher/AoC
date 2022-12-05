package AoC2022.Day4;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    List<Integer> section1;
    List<Integer> section2;

    public Pair(int lowerBounds1, int upperBounds1, int lowerBounds2, int upperBounds2) {
        List<Integer> s1 = new ArrayList<>();
        for(int i = lowerBounds1; i<=upperBounds1; i++){
            s1.add(i);
        }
        section1 = s1;
        List<Integer> s2 = new ArrayList<>();
        for(int i=lowerBounds2; i<=upperBounds2; i++){
            s2.add(i);
        }
        section2=s2;
    }

    public int add1IfOneSectionContainsOtherFull(){
        if((section2.contains(section1.get(0))&&section2.contains(section1.get(section1.size()-1)))
            ||section1.contains(section2.get(0))&&section1.contains(section2.get(section2.size()-1))){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int add1IfSomethingOverlapsAtAll(){
        for(int i=0; i<section1.size(); i++){
            if(section2.contains(section1.get(i))){
                return 1;
            }
        }
        return 0;
    }
}
