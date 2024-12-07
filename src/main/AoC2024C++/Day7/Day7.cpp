#include <stdio.h>
#include <fstream>
#include <iostream>
#include <sstream>
#include<vector>

using namespace std;

struct Equation {
    long long testValue;
    vector<long long> numbers;

    ~Equation() = default;
};

bool checkWithPlusNext(long long testValue, long long ca, const vector<long long> &numbers, int index, bool isTask1);

bool checkWithConcatNext(long long testValue, long long ca, const vector<long long> &numbers, int index, bool isTask1);

bool checkWithMulNext(long long testValue, long long ca, const vector<long long> &numbers, int index, bool isTask1);

bool checkWithPlusNext(long long testValue, long long ca, const vector<long long> &numbers, int index, bool isTask1) {
    if (index < numbers.size()) {
        ca += numbers.at(index);
        if (ca > testValue) {
            return false;
        }
        if (checkWithPlusNext(testValue, ca, numbers, index + 1, isTask1)) {
            return true;
        }
        if (!isTask1) {
            if (checkWithConcatNext(testValue, ca, numbers, index + 1, isTask1)) {
                return true;
            }
        }
        return checkWithMulNext(testValue, ca, numbers, index + 1, isTask1);
    }
    return ca == testValue;
}

bool checkWithConcatNext(long long testValue, long long ca, const vector<long long> &numbers, int index, bool isTask1) {
    if (index < numbers.size()) {
        ca = stoll(to_string(ca) + to_string(numbers.at(index)));
        if (ca > testValue) {
            return false;
        }
        if (checkWithPlusNext(testValue, ca, numbers, index + 1, isTask1)) {
            return true;
        }
        if (!isTask1) {
            if (checkWithConcatNext(testValue, ca, numbers, index + 1, isTask1)) {
                return true;
            }
        }
        return checkWithMulNext(testValue, ca, numbers, index + 1, isTask1);
    }
    return ca == testValue;
}

bool checkWithMulNext(long long testValue, long long ca, const vector<long long> &numbers, int index, bool isTask1) {
    if (index < numbers.size()) {
        ca *= numbers.at(index);
        if (ca > testValue) {
            return false;
        }
        if (checkWithPlusNext(testValue, ca, numbers, index + 1, isTask1)) {
            return true;
        }
        if (!isTask1) {
            if (checkWithConcatNext(testValue, ca, numbers, index + 1, isTask1)) {
                return true;
            }
        }
        return checkWithMulNext(testValue, ca, numbers, index + 1, isTask1);
    }
    return ca == testValue;
}

bool checkIfPossible(long long testValue, vector<long long> numbers, bool isTask1) {
    long long ca = numbers.at(0);
    if (checkWithPlusNext(testValue, ca, numbers, 1, isTask1)) {
        return true;
    }
    if (!isTask1) {
        if (checkWithConcatNext(testValue, ca, numbers, 1, isTask1)) {
            return true;
        }
    }
    return checkWithMulNext(testValue, ca, numbers, 1, isTask1);
}

void task1(vector<Equation> equations) {
    long long res = 0;
    for (const auto &equation: equations) {
        if (checkIfPossible(equation.testValue, equation.numbers, true)) {
            res += equation.testValue;
        }
    }
    cout << "Task 1: " << res << endl;
}

void task2(vector<Equation> equations) {
    long long res = 0;
    for (const auto &equation: equations) {
        if (checkIfPossible(equation.testValue, equation.numbers, false)) {
            res += equation.testValue;
        }
    }
    cout << "Task 2: " << res << endl;
}

int main() {
    ifstream inputFile("C:/Users/ABleicher/IdeaProjects/AoC/src/main/AoC2024C++/Day7/Input");
    std::string line;
    vector<Equation> equations;

    while (std::getline(inputFile, line)) {
        auto e = new Equation();
        auto sepIndex = line.find(':');
        try {
            e->testValue = stoll(line.substr(0, sepIndex));
        } catch (out_of_range) {
            cerr << "Invalid input" << endl;
        }
        auto numbersString = line.substr(sepIndex + 1, line.length());
        vector<long long> numbers;
        stringstream ss(numbersString);
        string into;
        while (getline(ss, into, ' ')) {
            if (!into.empty()) {
                try {
                    numbers.push_back(stoll(into));
                } catch (out_of_range) {
                    cerr << "Error in line " << line;
                }
            }
        }
        e->numbers = numbers;
        equations.push_back(*e);
    }
    inputFile.close();

    task1(equations);
    task2(equations);
    for (auto &equation: equations) {
        delete &equation;
    }
    return 0;
}
