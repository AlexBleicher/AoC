package AoC2023.Day8;

import java.util.List;

public class LCMofArrayOfNumbers {
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public long getLCM(List<Long> numbers) {
        long lcm = 1, fir = lcm, res = 0;
        for (int i = 0; i < numbers.size(); i++) {
            long sec = numbers.get(i);
            lcm = (fir * sec) / gcd(fir, sec);
            fir = lcm;
        }
        for (int j = 0; j < numbers.size(); j++) {
            res = gcd(res, numbers.get(j));
        }
        return lcm;
    }
}
