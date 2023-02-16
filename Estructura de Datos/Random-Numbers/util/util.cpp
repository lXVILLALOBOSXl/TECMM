#include "util.h"
#include <iostream>

using namespace std;

int askInteger(const char *message, bool onlyPositive) {
  int number;
  if (onlyPositive) {

    while (cout << "Type a correct " << message << ": ",
           !(cin >> number) || number < 0) {
      cerr << "Input error, try again. \n";
      if (cin.fail()) {
        cin.clear();
        cin.ignore();
      }
    }

  } else {
    while (cout << "Type a correct " << message << ": ", !(cin >> number)) {
      cerr << "Input error, try again. \n";
      if (cin.fail()) {
        cin.clear();
        cin.ignore();
      }
    }
  }
  return number;
}