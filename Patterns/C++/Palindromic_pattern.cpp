#include <iostream>
// Palindromic pattern
/*

            1
           212
          32123
         4321234
        543212345

*/
using namespace std;
int main()
{

    int count = 5;

    for (int i = 1; i <= count; i++)
    {
        for (int j = 1; j <= count - i; j++)
        {
            cout<<" ";
        }
        for (int j = i; j >= 1; j--)
        {
            cout<<j;
        }
        // for (int j = 2; (i>=2) && (j<=count-(count-i)); j++)
        for (int j = 2; j<=i; j++)
        {
            cout<<j;
        }
        cout<<"\n";
    }

    return 0;
}