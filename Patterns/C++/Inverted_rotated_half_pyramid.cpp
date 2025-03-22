#include <iostream>

int main()
{
    int count = 4;
    for (int i = count; i > 0; i--)
    {
        for (int j = 0; j <= count; j++)
        {
            if (j >= i)
            {
                std::cout << "*";
            }
            else
            {
                std::cout << " ";
            }
        }
        std::cout << "\n";
    }

    return 0;
}