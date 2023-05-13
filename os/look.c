#include <stdio.h>
#include <stdlib.h>

int main()
{
    int RQ[100], i, n, j, initial, index, move, totalhm = 0;
    printf("How many requests ; ");
    scanf("%d", &n);
    printf("Enter requests : ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &RQ[i]);
    }
    printf("Enter head potition : ");
    scanf("%d", &initial);
    printf("Enter 1 for high and 0 for low direction : ");
    scanf("%d", &move);

    // Sorting
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n - 1 - i; j++)
        {
            if (RQ[j] > RQ[j + 1])
            {
                int temp;
                temp = RQ[j];
                RQ[j] = RQ[j + 1];
                RQ[j + 1] = temp;
            }
        }
    }

    // Getting index after initial position
    for (i = 0; i < n; i++)
    {
        if (initial < RQ[i])
        {
            index = i;
            break;
        }
    }

    // For high
    if (move == 1)
    {
        for (i = index; i < n; i++)
        {
            totalhm += abs(RQ[i] - initial);
            initial = RQ[i];
        }
        for (i = index - 1; i >= 0; i--)
        {
            totalhm += abs(RQ[i] - initial);
            initial = RQ[i];
        }
    }
    // for low
    else
    {
        for (i = index - 1; i >= 0; i--)
        {
            totalhm += abs(RQ[i] - initial);
            initial = RQ[i];
        }
        for (i = index; i < n; i++)
        {
            totalhm += abs(RQ[i] - initial);
            initial = RQ[i];
        }
        
    }
    printf("%d",totalhm);
}