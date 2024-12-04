#include<iostream>
#include<regex>
#include<fstream>
#include<sstream>
#include <variant>

using namespace std;

long task1(string input) {
    regex reg(R"(mul\(\d+,\d+\))");
    regex reg2(R"(\d+)");
    long res = 0;
    for (smatch sm; regex_search(input, sm, reg);) {
        string mult = sm.str();
        long toMult = 1;
        for (smatch sm2; regex_search(mult, sm2, reg2);) {
            toMult *= stol(sm2.str());
            mult = sm2.suffix();
        }
        res += toMult;
        input = sm.suffix();
    }
    return res;
}

void task2(string input) {
    int blockStart = 0;
    string rest = input;
    bool reachedLastBlock = false;
    bool lastBlockCounts = true;
    long res = 0;
    while (!rest.empty() && !reachedLastBlock) {
        auto endWithDo = rest.find("do()");
        auto endWithDont = rest.find("don't()");
        if (endWithDo == endWithDont) {
            reachedLastBlock = true;
            if (lastBlockCounts) {
                res += task1(rest);
            }
            cout << res << endl;
        } else if (endWithDont == variant_npos || endWithDo < endWithDont) {
            string block = rest.substr(blockStart, endWithDo);
            rest = rest.substr(endWithDo + 4);
            if (lastBlockCounts) {
                res += task1(block);
            }
            lastBlockCounts = true;
        } else {
            string block = rest.substr(blockStart, endWithDont);
            rest = rest.substr(endWithDont + 7);
            if (lastBlockCounts) {
                res += task1(block);
            }
            lastBlockCounts = false;
        }
    }
}

int main() {
    ifstream ifile("C:/Users/ABleicher/IdeaProjects/AoC/src/main/AoC2024C++/Day3/Input.txt");
    string input;
    stringstream ss;
    ss << ifile.rdbuf();
    input = ss.str();

    //task1(input);
    task2(input);
    return 0;
}
