#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/** constant variable of 0 */
#define CONST0 0

/** constant variable of 1 */
#define CONST1 1

void readGrid( int rows, int cols, int grid[ rows ][ cols ] )
{
  // Add code to read in all the elements of grid from standard input.
  int i,j;
  for (i = CONST0; i < rows; i++)
  {
    for (j = CONST0; j < cols; j++)
    {
      int val;
      scanf("%d", &val);
      grid[i][j] = val;
    }
  }
}

// Add parameters to to pass a variable-sized array to the following
// function.  It's the same as the previous function, but I want you
// to get a chance to type it in yourself.
void reportMaxima( int rows, int cols, int arr[rows][cols] )
{
  // Add code to find local maxima and print them out in row major order.
  int i, j;
  for (i = CONST0; i < rows; i++)
  {
    for (j = CONST0; j < cols; j++)
    {
      if(i != 0) {
        if (arr[i][j] > arr[i][j + CONST1] && arr[i][j] > arr[i + CONST1][j + CONST1] && arr[i][j] > arr[i + CONST1][j] &&
            arr[i][j] > arr[i - CONST1][j] && arr[i][j] > arr[i - CONST1][j + CONST1] && arr[i][j] > arr[i - CONST1][j - CONST1] &&
            arr[i][j] > arr[i][j - CONST1] && arr[i][j] > arr[i + CONST1][j - CONST1])
        {
          printf("%d %d\n", i, j);
        }
      }
      else if (i == CONST0)
      {
        if (arr[i][j] > arr[i][j + CONST1] && arr[i][j] > arr[i + CONST1][j + CONST1] && arr[i][j] > arr[i + CONST1][j] &&
            arr[i][j] > arr[i][j - CONST1] && arr[i][j] > arr[i + CONST1][j - CONST1])
        {
          printf("%d %d\n", i, j);
        }
      }
      if (i == rows - CONST1 && j == cols - CONST1)
      {
        if (arr[i][j] > arr[i - CONST1][j] && arr[i][j] > arr[i - CONST1][j - CONST1] && arr[i][j] > arr[i][j - CONST1])
        {
          printf("%d %d\n", i, j);
        }
      }
    }
  }
}

int main()
{
  // Add code to read in the grid size from standard input.
  int rows, columns;
  scanf("%d %d", &rows, &columns);

  // Declare a variable-sized array to hold the grid.
  int arr[rows][columns];

  // Call readGrid() to populate the array.
  readGrid(rows, columns, arr);

  // Call reportMaxima() to print out all local maxima.
  reportMaxima(rows, columns, arr);
  
  return EXIT_SUCCESS;
}
