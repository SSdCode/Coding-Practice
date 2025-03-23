#include <iostream>

// Solid rhombus pattern
/*
             *****
            *****
           *****
          *****
         *****

*/
using namespace std;

int main()
{

    int count = 10;

    for (int i = 1; i <= count / 2; i++)
    {
        for (int j = 1; j <= count; j++)
        {
            if (j > count / 2 - i && j <= count - i)
            {
                cout << "*";
            }
            else
            {
                cout << " ";
            }
        }
        cout << "\n";
    }

    return 0;
}