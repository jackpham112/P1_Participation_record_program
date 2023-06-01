#include "print.h"
#include <stdio.h>

// Add a new global variable to keep a count of the spaces we print.

/* constant variable for number 0 */
#define CONST0 0
/* constant variable for number 1 */
#define CONST1 1

/* global variable */
int spaceCount = CONST0;

// Print the given character, counting spaces as we print and
// replacing each space with a '-'. The parameter type is char here,
// since we don't expect EOF to be passed to the function, just legal
// characters.
void dashesForSpaces( char ch )
{

   // Fill in the body of this function.

   if(ch != ' ') {
      printf("%c", ch);
   } else {
      printf("%c", '-');
      spaceCount = spaceCount + CONST1; 
  }
}
