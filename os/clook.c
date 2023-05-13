#include <stdio.h>
#include <stdlib.h>

int main()
{
	int rq[100], i, n, move, initial, index, totalhm = 0;
	printf("How many requests : ");
	scanf("%d", &n);
	printf("Enter requests : ");
	for (i = 0; i < n; i++)
	{
		scanf("%d", &rq[i]);
	}
	printf("ENter initial position : ");
	scanf("%d", &initial);
	printf("Enter 1 for high and 0 for low : ");
	scanf("%d", &move);

	// sorting
	for (i = 0; i < n; i++)
	{
		for (int j = 0; j < n - 1 - i; j++)
		{
			if (rq[j] > rq[j + 1])
			{
				int temp;
				temp = rq[j];
				rq[j] = rq[j + 1];
				rq[j + 1] = temp;
			}
		}
	}

	// getting index
	for (i = 0; i < n; i++)
	{
		if (initial < rq[i])
		{
			index = i;
			break;
		}
	}

	// for high
	if (move == 1)
	{
		for (i = index; i < n; i++)
		{
			totalhm = totalhm + abs(rq[i] - initial);
			initial = rq[i];
		}

		for (i = 0; i < index; i++)
		{
			totalhm = totalhm + abs(rq[i] - initial);
			initial = rq[i];
		}
	} 
	// for low
	else
	{
		for (i = index - 1; i >= 0; i--)
		{
			totalhm += abs(rq[i] - initial);
			initial = rq[i];
		}

		for (i = n - 1; i >= index; i--)
		{
			totalhm += abs(rq[i] - initial);
			initial = rq[i];
		}
	}
	printf("%d", totalhm);
}