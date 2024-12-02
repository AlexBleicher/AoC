#include<iostream>
#include<vector>
#include<fstream>
#include<sstream>

using namespace std;

bool checkIfSafe(vector<int> vect, bool increasing) {
    for (int i = 0; i < vect.size() - 1; i) {
        int temp = vect[i];
        int next = vect[++i];
        if (increasing) {
            if (temp >= next || temp < next - 3) {
                return false;
            }
        } else {
            if (temp <= next || temp > next + 3) {
                return false;
            }
        }
    }
    return true;
}

void task1(std::vector<std::vector<int> > reports) {
    int amountSafe = 0;
    for (int i = 0; i < reports.size(); i++) {
        int t = reports[i][0];
        int n = reports[i][1];
        bool increasing = t < n;
        if (checkIfSafe(reports[i], increasing)) {
            amountSafe++;
        }
    }
    cout << amountSafe << endl;
}

void task2(std::vector<std::vector<int> > reports) {
    int amountSafe = 0;
    for (int i = 0; i < reports.size(); i++) {
        bool oneSafe = false;
        int t = reports[i][0];
        int n = reports[i][1];
        bool increasing = t < n;
        if (checkIfSafe(reports[i], increasing)) {
            oneSafe = true;
        }
        for (int j = 0; j < reports[i].size() && !oneSafe; j++) {
            vector<int> temp;
            for (int k = 0; k < reports[i].size(); k++) {
                if (k != j) {
                    temp.push_back(reports[i][k]);
                }
            }
            increasing = temp[0] < temp[1];
            if (checkIfSafe(temp, increasing)) {
                oneSafe = true;
            }
        }
        if (oneSafe) {
            amountSafe++;
        }
    }
    cout << amountSafe << endl;
}

int main() {
    std::ifstream inputFile("C:/Users/ABleicher/IdeaProjects/AoC/src/main/AoC2024C++/Day2/input.txt");

    std::string line;
    std::vector<std::vector<int> > reports;

    while (std::getline(inputFile, line)) {
        std::vector<int> levels;
        std::stringstream ss;
        ss << line;
        std::string numbers;
        while (std::getline(ss, numbers, ' ')) {
            levels.push_back(std::stoi(numbers));
        }
        reports.push_back(levels);
    }
    inputFile.close();
    std::cout << "Task 1" << std::endl;
    task1(reports);
    task2(reports);
    return 0;
}
