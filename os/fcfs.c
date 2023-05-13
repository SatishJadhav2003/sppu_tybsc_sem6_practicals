#include <stdio.h>
#include <stdlib.h>

int main()
{
    int Totalhm = 0, n, i, initial, RQ[100];
    printf("How many request : ");
    scanf("%d", &n);
    printf("Enter the request sequence : ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &RQ[i]);
    }
    printf("Enter head position : ");
    scanf("%d", &initial);

    for (i = 0; i < n; i++)
    {
        Totalhm = Totalhm + abs(RQ[i] - initial);
        initial = RQ[i];
    }

    printf("Total head Moment : %d", Totalhm);
}