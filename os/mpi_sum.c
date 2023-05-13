#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#include <assert.h>
#include <time.h>
float *crn(int n)
{
    float *num = (float *)malloc(sizeof(float) * n);
    assert(num != NULL);
    int i;
    for (i = 0; i < n; i++)
    {
        num[i] = (rand() / (float)RAND_MAX);
    }

    return num;
}
int main(int argc, char **argv)
{
    if (argc != 2)
    {
        fprintf(stderr, "Usage: avg npp\n");
        exit(1);
    }
    int npp = atoi(argv[1]);

    MPI_Init(NULL, NULL);
    int world_rank;
    MPI_Comm_rank(MPI_COMM_WORLD, &world_rank);
    int world_size;
    MPI_Comm_size(MPI_COMM_WORLD, &world_size);
    srand(time(NULL) * world_rank);

    float *num = NULL;
    num = crn(npp);
    float local_sum = 0;
    int i;
    for (i = 0; i < npp; i++)
    {
        local_sum += num[i];
    }

    printf("Local sum for proces %d - %f. avg=%f\n", world_rank, local_sum, local_sum / npp);
    float global_sum;
    MPI_Reduce(&local_sum, &global_sum, 1, MPI_FLOAT, MPI_SUM, 0, MPI_COMM_WORLD);

    if (world_rank == 0)
    {
        printf("Total sum = %f.avg=%f\n", global_sum, global_sum / (world_size = npp));
    }
    free(num);
    MPI_Barrier(MPI_COMM_WORLD);
    MPI_Finalize();
}