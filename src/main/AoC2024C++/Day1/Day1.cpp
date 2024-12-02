#include <algorithm>
#include <fstream>
#include <iostream>
#include <sstream>
#include <vector>

void task1(std::vector<long> left, std::vector<long> right) {
    sort(left.begin(), left.end());
    sort(right.begin(), right.end());
    long res = 0;
    for (int i = 0; i < left.size(); i++) {
        long l = left[i];
        long r = right[i];
        if (l > r) {
            res += l - r;
        } else {
            res += r - l;
        }
    }
    std::cout << res << std::endl;
}

void task2(std::vector<long> left, std::vector<long> right) {
    long res = 0;
    for (int i = 0; i < left.size(); i++) {
        long l = left[i];
        long amount = 0;
        for (int j = 0; j < right.size(); j++) {
            if (l == right[j]) {
                amount += 1;
            }
        }
        res += amount * l;
    }
    std::cout << res << std::endl;
}

int main() {
    std::ifstream inputFile("C:/Users/ABleicher/IdeaProjects/AoC/src/main/AoC2024C++/Day1/input.txt");

    std::string line;
    std::vector<long> leftList;
    std::vector<long> rightList;

    while (std::getline(inputFile, line)) {
        //auto endFirstNumber = line.find(" ");
        //std::cout << line.substr(0, endFirstNumber) << std::endl;
        std::stringstream ss;
        ss << line;
        std::string numbers;
        int i = 0;
        while (std::getline(ss, numbers, ' ')) {
            if (!numbers.empty()) {
                if (i % 2 == 0) {
                    leftList.push_back(std::stol(numbers));
                } else {
                    rightList.push_back(std::stol(numbers));
                }
                i++;
            }
        }
    }
    inputFile.close();

    task1(leftList, rightList);
    task2(leftList, rightList);
    return 0;
}
