#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#define ARRAY_SIZE 1000
int main(int argc, char **argv)
{
    int rank, size;
    int array[ARRAY_SIZE];
    int sum = 0;
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    // Seed the random number generator with the rank of the process
    srand(rank);
    // Fill the array with random numbers between 0 and 999
    for (int i = 0; i < ARRAY_SIZE; i++)
    {
        array[i] = rand() % 1000;
    }
    // Calculate the sum of all odd numbers in the array
    for (int i = rank; i < ARRAY_SIZE; i += size)
    {
        if (array[i] % 2 != 0)
        {
            sum += array[i];
        }
    }
    // Reduce the sum across all processes
    int global_sum;
    MPI_Reduce(&sum, &global_sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);
    // Print the result from the root process
    if (rank == 0)
    {
        printf("Sum of all odd numbers in the array: %d\n", global_sum);
    }

    MPI_Finalize();

    return 0;
}
