package AoC2021.Day14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day14Test {

    @ParameterizedTest
    @MethodSource
    void task1(String input, long expectedResult){
        Day14 testObject = new Day14(input);
        long result = testObject.task1();

        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> task1(){
        return Stream.of(
                Arguments.of("NNCB\n" +
                        "\n" +
                        "CH -> B\n" +
                        "HH -> N\n" +
                        "CB -> H\n" +
                        "NH -> C\n" +
                        "HB -> C\n" +
                        "HC -> B\n" +
                        "HN -> C\n" +
                        "NN -> C\n" +
                        "BH -> H\n" +
                        "NC -> B\n" +
                        "NB -> B\n" +
                        "BN -> B\n" +
                        "BB -> N\n" +
                        "BC -> B\n" +
                        "CC -> N\n" +
                        "CN -> C", 1588),
                Arguments.of("HBHVVNPCNFPSVKBPPCBH\n" +
                        "\n" +
                        "HV -> B\n" +
                        "KS -> F\n" +
                        "NH -> P\n" +
                        "OP -> K\n" +
                        "OV -> C\n" +
                        "HN -> O\n" +
                        "FF -> K\n" +
                        "CP -> O\n" +
                        "NV -> F\n" +
                        "VB -> C\n" +
                        "KC -> F\n" +
                        "CS -> H\n" +
                        "VC -> F\n" +
                        "HF -> V\n" +
                        "NK -> H\n" +
                        "CF -> O\n" +
                        "HH -> P\n" +
                        "FP -> O\n" +
                        "OH -> K\n" +
                        "NN -> C\n" +
                        "VK -> V\n" +
                        "FB -> F\n" +
                        "VP -> N\n" +
                        "FC -> P\n" +
                        "SV -> F\n" +
                        "NO -> C\n" +
                        "VN -> S\n" +
                        "CH -> N\n" +
                        "FN -> N\n" +
                        "FV -> P\n" +
                        "CN -> H\n" +
                        "PS -> S\n" +
                        "VF -> K\n" +
                        "BN -> S\n" +
                        "FK -> C\n" +
                        "BB -> H\n" +
                        "VO -> P\n" +
                        "KN -> N\n" +
                        "ON -> C\n" +
                        "BO -> S\n" +
                        "VS -> O\n" +
                        "PK -> C\n" +
                        "SK -> P\n" +
                        "KF -> K\n" +
                        "CK -> O\n" +
                        "PB -> H\n" +
                        "PF -> O\n" +
                        "KB -> V\n" +
                        "CC -> K\n" +
                        "OK -> B\n" +
                        "CV -> P\n" +
                        "PO -> O\n" +
                        "SH -> O\n" +
                        "NP -> F\n" +
                        "CO -> F\n" +
                        "SS -> P\n" +
                        "FO -> K\n" +
                        "NS -> O\n" +
                        "PN -> H\n" +
                        "PV -> V\n" +
                        "KP -> C\n" +
                        "BK -> B\n" +
                        "BP -> F\n" +
                        "NB -> C\n" +
                        "OF -> O\n" +
                        "OC -> O\n" +
                        "HO -> C\n" +
                        "SC -> K\n" +
                        "HC -> C\n" +
                        "HS -> B\n" +
                        "KH -> N\n" +
                        "FS -> N\n" +
                        "PH -> O\n" +
                        "PC -> V\n" +
                        "BS -> O\n" +
                        "KO -> F\n" +
                        "SP -> K\n" +
                        "OB -> O\n" +
                        "SF -> K\n" +
                        "KV -> F\n" +
                        "NC -> B\n" +
                        "SO -> C\n" +
                        "CB -> S\n" +
                        "VH -> V\n" +
                        "FH -> F\n" +
                        "SN -> V\n" +
                        "SB -> P\n" +
                        "PP -> B\n" +
                        "BF -> K\n" +
                        "HB -> O\n" +
                        "OO -> V\n" +
                        "HP -> H\n" +
                        "KK -> O\n" +
                        "BV -> K\n" +
                        "BH -> B\n" +
                        "HK -> H\n" +
                        "BC -> C\n" +
                        "VV -> S\n" +
                        "OS -> F\n" +
                        "NF -> B",0)
        );
    }
    @ParameterizedTest
    @MethodSource
    void task2(String input, long expectedResult){
        Day14 testObject = new Day14(input);
        long result = testObject.task2();

        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> task2(){
        return Stream.of(
                Arguments.of("NNCB\n" +
                        "\n" +
                        "CH -> B\n" +
                        "HH -> N\n" +
                        "CB -> H\n" +
                        "NH -> C\n" +
                        "HB -> C\n" +
                        "HC -> B\n" +
                        "HN -> C\n" +
                        "NN -> C\n" +
                        "BH -> H\n" +
                        "NC -> B\n" +
                        "NB -> B\n" +
                        "BN -> B\n" +
                        "BB -> N\n" +
                        "BC -> B\n" +
                        "CC -> N\n" +
                        "CN -> C", Long.parseLong("2188189693529")),
                Arguments.of("HBHVVNPCNFPSVKBPPCBH\n" +
                        "\n" +
                        "HV -> B\n" +
                        "KS -> F\n" +
                        "NH -> P\n" +
                        "OP -> K\n" +
                        "OV -> C\n" +
                        "HN -> O\n" +
                        "FF -> K\n" +
                        "CP -> O\n" +
                        "NV -> F\n" +
                        "VB -> C\n" +
                        "KC -> F\n" +
                        "CS -> H\n" +
                        "VC -> F\n" +
                        "HF -> V\n" +
                        "NK -> H\n" +
                        "CF -> O\n" +
                        "HH -> P\n" +
                        "FP -> O\n" +
                        "OH -> K\n" +
                        "NN -> C\n" +
                        "VK -> V\n" +
                        "FB -> F\n" +
                        "VP -> N\n" +
                        "FC -> P\n" +
                        "SV -> F\n" +
                        "NO -> C\n" +
                        "VN -> S\n" +
                        "CH -> N\n" +
                        "FN -> N\n" +
                        "FV -> P\n" +
                        "CN -> H\n" +
                        "PS -> S\n" +
                        "VF -> K\n" +
                        "BN -> S\n" +
                        "FK -> C\n" +
                        "BB -> H\n" +
                        "VO -> P\n" +
                        "KN -> N\n" +
                        "ON -> C\n" +
                        "BO -> S\n" +
                        "VS -> O\n" +
                        "PK -> C\n" +
                        "SK -> P\n" +
                        "KF -> K\n" +
                        "CK -> O\n" +
                        "PB -> H\n" +
                        "PF -> O\n" +
                        "KB -> V\n" +
                        "CC -> K\n" +
                        "OK -> B\n" +
                        "CV -> P\n" +
                        "PO -> O\n" +
                        "SH -> O\n" +
                        "NP -> F\n" +
                        "CO -> F\n" +
                        "SS -> P\n" +
                        "FO -> K\n" +
                        "NS -> O\n" +
                        "PN -> H\n" +
                        "PV -> V\n" +
                        "KP -> C\n" +
                        "BK -> B\n" +
                        "BP -> F\n" +
                        "NB -> C\n" +
                        "OF -> O\n" +
                        "OC -> O\n" +
                        "HO -> C\n" +
                        "SC -> K\n" +
                        "HC -> C\n" +
                        "HS -> B\n" +
                        "KH -> N\n" +
                        "FS -> N\n" +
                        "PH -> O\n" +
                        "PC -> V\n" +
                        "BS -> O\n" +
                        "KO -> F\n" +
                        "SP -> K\n" +
                        "OB -> O\n" +
                        "SF -> K\n" +
                        "KV -> F\n" +
                        "NC -> B\n" +
                        "SO -> C\n" +
                        "CB -> S\n" +
                        "VH -> V\n" +
                        "FH -> F\n" +
                        "SN -> V\n" +
                        "SB -> P\n" +
                        "PP -> B\n" +
                        "BF -> K\n" +
                        "HB -> O\n" +
                        "OO -> V\n" +
                        "HP -> H\n" +
                        "KK -> O\n" +
                        "BV -> K\n" +
                        "BH -> B\n" +
                        "HK -> H\n" +
                        "BC -> C\n" +
                        "VV -> S\n" +
                        "OS -> F\n" +
                        "NF -> B",0)
        );
    }
}