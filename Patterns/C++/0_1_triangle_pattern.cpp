#include <iostream>

// 0-1 triangle pattern
/*

         1
         01
         101
         0101
         10101

* */
int main()
{

    for (int i = 1; i <= 5; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            if (i % 2 == 1)
            {
                if (j % 2 == 0)
                {
                    std::cout << "0";
                }
                else
                {
                    std::cout << "1";
                }
            }

            if (i % 2 == 0)
            {
                if (j % 2 == 0)
                {
                    std::cout << "1";
                }
                else
                {
                    std::cout << "0";
                }
            }
        }
        std::cout << "\n";
    }

    return 0;
}