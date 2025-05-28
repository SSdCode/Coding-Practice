#include <iostream>
#include <vector>

int unionCount = 0;
int intersectionCount = 0;

void insertInArray(int element, std::vector<int> &array, char InorUni) {
    bool isElementPresentInArray = false;
    for (int k = 0; k < array.size(); k++) {
        if (array[k] == element) {
            isElementPresentInArray = true;
            break;
        }
    }
    if (!isElementPresentInArray) {
        if (InorUni == 'u') {
            array.push_back(element);
            unionCount++;
        } else {
            array.push_back(element);
            intersectionCount++;
        }
    }
}

int main() {
    std::vector<int> arr1 = {1, 3, 2, 4, 6, 7};
    std::vector<int> arr2 = {4, 6, 7, 8, 9, 5};

    int elementArr1 = arr1[0];
    int elementArr2 = arr2[0];

    std::vector<int> unionn;
    std::vector<int> intersection;

    for (int i = 0; i < 6; i++) {
        elementArr1 = arr1[i];
        elementArr2 = arr2[i];

        bool isElementArr1PresentInArr2 = false;
        bool isElementArr2PresentInArr1 = false;

        for (int j = 0; j < 6; j++) {
            if (arr1[j] == elementArr2) {
                isElementArr2PresentInArr1 = true;
            }
            if (arr2[j] == elementArr1) {
                isElementArr1PresentInArr2 = true;
            }
        }

        if (isElementArr2PresentInArr1) {
            insertInArray(elementArr2, intersection, 'i');
        }
        if (isElementArr1PresentInArr2) {
            insertInArray(elementArr1, intersection, 'i');
        }

        insertInArray(elementArr2, unionn, 'u');
        insertInArray(elementArr1, unionn, 'u');
    }

    std::cout << "Intersection - ";
    for (int m = 0; m < intersection.size(); m++) {
        std::cout << intersection[m] << ", ";
    }
    std::cout << "\n";

    std::cout << "Union - ";
    for (int n = 0; n < unionn.size(); n++) {
        std::cout << unionn[n] << ", ";
    }

    return 0;
}
