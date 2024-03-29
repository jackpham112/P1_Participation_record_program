// Dynamically allocate a 2D array that holds the same set of strings as
// the command line arguments.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void printArguments( int rows, int cols, char args[][ cols ] )
{
  // Each row of the args array contains a string.  Print out each of the
  // strings.

  
  for(int i = 0; i < rows; i++) {
    for(int z = 0; z < cols; z++) {
      printf("%c", args[i][z]);
    }
    printf("\n");
  }
}

int main( int argc, char *argv[] )
{
  // Figure out the length of the longest command-line argument.
  int longest = 0;

  
  for(int i = 0; i < argc; i++) {
    if(strlen(argv[i]) > longest) {
      longest = strlen(argv[i]);
    }
  }

  // Dynamically allocate a 2D array of characers, with one row for every
  // command-line argument and (exactly) enough columns to hold a copy of the
  // widest command-line argument (including the null terminator at the end).
  char (*words)[ longest + 1 ];

  words = (char (*) [longest + 1]) malloc(argc * sizeof(*words));

  // Copy each command-line argumetn to a row of this new array.
  for (int i = 0; i < argc; ++i) {
    strcpy(words[i], argv[i]);
  }
  

  // Call a function that's expecting the command-line arguments as a 2D array
  // (not as an array of pointers).
  printArguments( argc, longest + 1, words );

  return 0;
}
