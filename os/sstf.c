#include <stdio.h>
#include <stdlib.h>
int main()
{
    int RQ[100], n, i, initial, Totalhm=0, count = 0;
    printf("How many requests: ");
    scanf("%d", &n);
    printf("Enter requests : ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &RQ[i]);
    }
    printf("ENter head position : ");
    scanf("%d", &initial);


    // Logic for SSTF
    while (count != n)
    {
        int min = 1000, d, index;
        for (i = 0; i < n; i++)
        {
            d = abs(RQ[i] - initial);
            if (min > d)
            {
                min = d;
                index = i;
            }
        }
        Totalhm = Totalhm + min;
        initial = RQ[index];
        RQ[index] = 1000;
        count++;
    }
    printf("Total head moment is : %d", Totalhm);
    return 0;
}