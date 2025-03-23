#include <iostream>
// Triangle
/*

                 *
               * * *
             * * * * *
           * * * * * * *

*/
using namespace std;
int main()
{

    int count = 8;
    for (int i = 1; i <= count / 2; i++)
    {
        for (int j = 1; j < count; j++)
        {
            if (j > count / 2 - i && j < count / 2 + i)
            {
                cout << "* ";
            }
            else
            {
                cout << "  ";
            }
        }
        cout << "\n";
    }

    return 0;
}