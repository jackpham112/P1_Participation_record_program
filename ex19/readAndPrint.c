// Exercise to read a sequence of doubles stored in binary format from
// a file, and then write the cosine of each to a file (in text)

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main( int argc, char *argv[] )
{
  // Open the the input file in binary mode
  FILE *input = fopen("doubles.bin", "rb");

  // Open the the output file in text mode
  FILE *output = fopen("output.txt", "w");

  // Read double values from the inupt file using fread().  Use an array
  // that's large enough to hold 100 values, and use the return value
  // of fread to tell how many you successfully read.
  double values[ 100 ];
  int len;
  while ( ( len = fread( values, 1, sizeof(values),input ) ) != 0 );
  
  // Loop over the list of values and print the cosine of each
  // to the output file, one value per line with 4 fractional digits
  // of precision.
  double val = 0; 
  int i = 0;
  while(i < 100) {
    val = cos(values[i]);
    values[i] = val;
    i++;
  }
  for(i = 0; i < 20; i++) {
    fprintf(output, "%.4f\n", values[i]);
  }
  

  // Close both of the files.
  fclose(input);
  fclose(output);

  return 0;
}
