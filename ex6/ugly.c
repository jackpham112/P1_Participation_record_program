// Same prime-detection strategy, but without any structured
// looping constructs.

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/*
 * Report a list of prime values.
 */
int main( void )
{
  // Get the range of values we're supposed to test.
  unsigned int low, high;
  if ( scanf( "%d%d", &low, &high ) != 2 ) {
    printf( "Invalid input\n" );
    exit( EXIT_FAILURE );
  }
  
  // Write your own, ugly solution, using goto instead of structured looping.

  // Test all values from low up to and including high.
  unsigned int val = low;
  startLoop:
    if(val > high) {
      goto endLoop;
    }
    //isPrime function
    bool isPrime = false;

    // Check all smaller values as potential factors.
    unsigned int fact = 2;
    startLoop1:
      if(fact * fact > val) {
        goto endLoop1;
      }
      // Does this factor evenly divide the given value.
      if ( val % fact == 0 ) {
        // if so, the value isn't prime.
        isPrime = false;
        goto endLoop2;
      }
      fact++;
      goto startLoop1;

    // If the value survives all the tests for factors, it must be prime.
    endLoop1:
    isPrime = true;
    
    endLoop2:

    if ( isPrime ) {
      printf( "%u\n", val );
    }
    val++;
    goto startLoop;

  endLoop:
  return EXIT_SUCCESS;
}
