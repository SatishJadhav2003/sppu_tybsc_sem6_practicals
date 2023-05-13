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
    // till same
    float max = 0;
    int k;
    for (k = 0; k < npp; k++)
    {
        if (num[k] > max)
        {
            max = num[k];
        }
    }
    float global_max;
    MPI_Reduce(&max, &global_max, 1, MPI_FLOAT, MPI_MAX, 0, MPI_COMM_WORLD);
    float min = 999;
    int z;
    for (z = 0; z < npp; z++)
    {
        if (num[z] < min)
        {
            min = num[z];
        }
    }
    float global_min;
    MPI_Reduce(&min, &global_min, 1, MPI_FLOAT, MPI_MIN, 0, MPI_COMM_WORLD);
    if (world_rank == 0)
    {
        printf("max is %f\n", global_max);
        printf("min is %f\n", global_min);
    }
    free(rand_nums);
    MPI_Barrier(MPI_COMM_WORLD);
    MPI_Finalize();
}