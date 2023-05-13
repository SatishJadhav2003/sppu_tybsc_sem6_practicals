#include <stdio.h>
#include <stdlib.h>

int main()
{
    int  RQ[100],initial, i, n, size, move, ttotalhm = 0;
    printf("How many reqests : \n");
    scanf("%d", &n);
    printf("Enetr Requests : ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &RQ[i]);
    }

    printf("Enter Initial head position : \n");
    scanf("%d", &initial);
    printf("Enter disk size : \n");
    scanf("%d", &size);
    printf("for Toward high enter 1 and for towords low enter 0 : \n");
    scanf("%d", &move);


// Logic for C-scan
    for (i = 0; i < n; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
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

    int index;
    for (i = 0; i < n; i++)
    {
        if (initial < RQ[i])
        {
            index = i;
            break;
        }
    }

    // Towards high
    if (move == 1)
    {
        for (i = index; i < n; i++)
        {
            ttotalhm += abs(RQ[i] - initial);
            initial = RQ[i];
        }
        ttotalhm += abs(size - 1 - RQ[i - 1]);
        ttotalhm += abs(size - 1 - 0);
        initial = 0;
        for (i = 0; i < index; i++)
        {
            ttotalhm += abs(RQ[i] - initial);
            initial = RQ[i];
        }
    }
    else
    {
        for (i = index - 1; i >= 0; i--)
        {
            ttotalhm += abs(RQ[i] - initial);
            initial = RQ[i];
        }

        ttotalhm += abs(RQ[i + 1] - 0);
        ttotalhm += abs(size - 1 - 0);
        initial = size - 1;
        for (i = n - 1; i >= index; i--)
        {
            ttotalhm += abs(RQ[i]-initial);
            initial = RQ[i];
        }
    }
    printf("Total head movment is  : %d",ttotalhm);
}