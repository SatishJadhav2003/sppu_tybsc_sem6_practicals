#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

// #define ARRAY_SIZE 1000

int main(int argc, char** argv) {
  int rank, size;
  int array[1000];
  int local_min, local_max, global_min, global_max;

  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  MPI_Comm_size(MPI_COMM_WORLD, &size);

  // Seed the random number generator with the rank of the process
  srand(rank);

  // Fill the array with random numbers between 0 and 999
  for (int i = 0; i < 1000; i++) {
    array[i] = rand() % 1000;
  }

  // Calculate the local minimum and maximum values
  local_min = array[0];
  local_max = array[0];
  for (int i = rank; i < 1000; i += size) {
    if (array[i] < local_min) {
      local_min = array[i];
    }
    if (array[i] > local_max) {
      local_max = array[i];
    }
  }

  // Reduce the local minimum and maximum values across all processes
  MPI_Reduce(&local_min, &global_min, 1, MPI_INT, MPI_MIN, 0, MPI_COMM_WORLD);
  MPI_Reduce(&local_max, &global_max, 1, MPI_INT, MPI_MAX, 0, MPI_COMM_WORLD);

  // Print the result from the root process
  if (rank == 0) {
    printf("Minimum value in the array: %d\n", global_min);
    printf("Maximum value in the array: %d\n", global_max);
  }

  MPI_Finalize();

  return 0;
}
