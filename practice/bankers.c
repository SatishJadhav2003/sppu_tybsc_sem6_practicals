#include <stdio.h>
#include <stdlib.h>
#define true 1
#define false 0

int alloc[5][4], need[5][4], max[5][4], work[10], finish[10], safeseq[10], req[10], avail[10];
int m = 3, n = 5, i, j, ssi = -1;


void get_alloc_state();
int safe_state();
void get_alloc_request();
int need_lte_work(int i);
int req_lte_need(int i);
int req_lte_avail();
void print_safess();

int main()
{
    get_alloc_state();
}

void get_alloc_state()
{
    int ch = 0;
    printf("Total resource types : %d\n", m);
    printf("Total Process types : %d\n", n);
    while (ch != 8)
    {
        printf("\n1] Accept available\n2]display max and allocations\n3]content of need matrix\n4]Display available\n5]Accept request\n6]Safety algorithm\n7]Resource request algorithm\n8]Exit\n\nEnter your choice : \t");
        scanf("%d", &ch);
        switch (ch)
        {
        case 1:
            printf("\nEnter available : \t");
            for (i = 0; i < m; i++)
            {
                scanf("%d", &avail[i]);
            }
            printf("\nEnter maximum demand by each process : \n");
            for (i = 0; i < n; i++)
            {
                printf("\nProcess %d\t", i);
                for (j = 0; j < m; j++)
                {
                    scanf("%d", &max[i][j]);
                }
            }
            printf("\nEnter Allocations by each process : \n");
            for (i = 0; i < n; i++)
            {
                printf("\nProcess %d\t", i);
                for (j = 0; j < m; j++)
                {
                    scanf("%d", &alloc[i][j]);
                }
            }
            break;

        case 2:
            printf("\n maximum demand by each process : \n");
            for (i = 0; i < n; i++)
            {
                printf("\nProcess %d\t", i);
                for (j = 0; j < m; j++)
                {
                    printf("%d", max[i][j]);
                }
            }
            printf("\nAllocations by each process : \n");
            for (i = 0; i < n; i++)
            {
                printf("\nProcess %d\t", i);
                for (j = 0; j < m; j++)
                {
                    printf("%d", alloc[i][j]);
                }
            }
            break;
        case 3:
            printf("\n Need by each process : \n");
            for (i = 0; i < n; i++)
            {
                printf("\nProcess %d\t", i);
                for (j = 0; j < m; j++)
                {
                    need[i][j] = max[i][j] - alloc[i][j];
                    printf("%d", need[i][j]);
                }
            }
            break;

        case 4:
            printf("\n available : \t");
            for (i = 0; i < m; i++)
            {
                printf("%d\t", avail[i]);
            }
            break;

        case 5:
            printf("Enter process number for request : \n");
            scanf("%d", &i);
            printf("Enter requests : \n");
            for (j = 0; j < m; j++)
            {
                scanf("%d", &req[j]);
            }
            break;

        case 6:
            if (safe_state())
            {
                printf("Given System is in safe state ......\n");
                print_safess();
            }
            break;
        case 7:
            if (safe_state())
            {
                printf("Given System is in safe state ......\n");
                ssi = ssi / 2;
                print_safess();
            }
            else
            {
                printf("Given system is not in safe state ...\n");
                get_alloc_request();
                ssi = -1;
                if (safe_state())
                {
                    printf("Given System will be in safe state after requests ......\n");
                    print_safess();
                }
                else
                {
                    printf("Given System will not be safe state after requests ......\n");
                    printf("Allocation state undone\nprocess should wait..\n");
                }
            }

            break;
        case 8:
            exit(0);
        default:
            printf("Uff dude...You entered invalid choice ... please enter valid choice...\n");
            break;
        }
    }
}

int safe_state()
{
    int found;
    for (j = 0; j < m; j++)
    {
        work[j] = avail[j];
    }

    for (j = 0; j < n; j++)
    {
        finish[j] = false;
    }

    do
    {
        found = false;
        for (i = 0; i < n; i++)
        {
            if (finish[i] == false && need_lte_work(i))
            {
                printf("Selected process %d\n", i);
                finish[i] = true;
                for (j = 0; j < m; j++)
                {
                    work[j] += alloc[i][j];
                }
                safeseq[++ssi] = i;
                found = true;
            }
        }
        if (found == false)
        {
            for (j = 0; j < n; j++)
            {
                if (finish[j] == false)
                {
                    return false;
                }
            }
            return true;
        }

    } while (1);
}

int need_lte_work(int i)
{
    for (j = 0; j < m; j++)
    {
        if (need[i][j] > work[j])
        {
            return false;
        }
    }
    return true;
}

void print_safess()
{
    for ( i = 0; i <= ssi; i++)
    {
        printf("%4d",safeseq[i]);
    }
    
}


void get_alloc_request()
{
    if (!req_lte_need(i))
    {
        printf("Requst is more than it's maximum claim ...\n");
    }

    if (!req_lte_avail())
    {
        printf("Resources are not available ..process should wait ...\n");
    }
    for (j = 0; j < m; j++)
    {
        alloc[i][j] += work[j];
        need[i][j] -= work[j];
        avail[j] = work[j];
    }
}

int req_lte_need(int i)
{
    for (j = 0; j < m; j++)
    {
        if (req[j] > need[i][j])
        {
            return 1;
        }
    }
    return 0;
}

int req_lte_avail()
{
    for (j = 0; j < m; j++)
    {
        if (req[j] > avail[i])
        {
            return 1;
        }
    }
    return 0;
}