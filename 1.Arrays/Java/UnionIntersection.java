public class UnionIntersection {
    static int unionCount = 0;
    static int intersectionCount = 0;

    static void insertInArray(int element, int[] array, char InorUni)
    {
        Boolean isElementPresentInArray = false;
        for (int k = 0; k < 6; k++)
        {
            if (array[k] == element)
            {
                isElementPresentInArray = true;
            }
        }
        if (!isElementPresentInArray)
        {
            if (InorUni == 'u')
            {
                array[unionCount++] = element;
            }
            else
            {
                array[intersectionCount++] = element;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println();
        int arr1[] = {1, 3, 2, 4, 6, 7};
        int arr2[] = {4, 6, 7, 8, 9, 5};

        int elementArr1 = arr1[0];
        int elementArr2 = arr2[0];

        int[] unionn = new int[12];
        int[] intercection = new int[6];

        for (int i = 0; i < 6; i++)
        {
            elementArr1 = arr1[i];
            elementArr2 = arr2[i];
            Boolean isElementArr1PresentInArr2 = false;
            Boolean isElementArr2PresentInArr1 = false;
            for (int j = 0; j < 6; j++)
            {
                if (arr1[j] == elementArr2)
                {
                    isElementArr2PresentInArr1 = true;
                }
                if (arr2[j] == elementArr1)
                {
                    isElementArr1PresentInArr2 = true;
                }
            }
            if (isElementArr2PresentInArr1)
            {
                insertInArray(elementArr2, intercection, 'i');
            }
            if (isElementArr1PresentInArr2)
            {
                insertInArray(elementArr1, intercection, 'i');
            }
            insertInArray(elementArr2, unionn, 'u');
            insertInArray(elementArr1, unionn, 'u');
        }

        System.out.print("intersection - ");

        for (int m = 0; m < intersectionCount; m++)
        {
            System.out.print(intercection[m]+" ");
        }
        System.out.print("\n");
        System.out.print("Union - ");
        for (int n = 0; n < unionCount; n++)
        {
            System.out.print(unionn[n]+" ");
        }
        System.out.println();
    }
}