#include <chrono>
#include <iostream>
#include <fstream>
#include <sstream>
#include <thread>

#include <cstdlib>
#include <ctime>

using namespace std;

int main() {
    ifstream file("script.txt");
    if (!file.is_open()) {
        cout << "Could not open file" << endl;
        exit(-1);
    }

    stringstream buffer;
    buffer << file.rdbuf();
    for (int i = 0; i < 2; i++) {
        for (auto& c : buffer.str()) {
            cout << c << flush;
            this_thread::sleep_for(chrono::milliseconds(20));
        }
    }

    int count = 0;
    const char* chars 
        = "0123456789" 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" 
        "abcdefghijklmnopqrstuvwxyz";
    srand(time(nullptr));

    while (true) {
        cout << chars[rand() % 62] << flush;
        if (count % 80 == 0) {
            cout << endl;
        }

        this_thread::sleep_for(chrono::milliseconds(10));
        count++;
    }

    return 0;
}
