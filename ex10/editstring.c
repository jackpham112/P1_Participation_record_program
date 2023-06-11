#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/** Maximum length for strings in this exercise (not counting the null
    terminator). */
#define STRING_LIMIT 80

/** max num allowed for input */
#define NUM_MIN 33

/** min num allowed for input */
#define NUM_MAX 126

/** Report that the input is invalid and exit unsuccessfully. */
static void invalid()
{
  fprintf( stderr, "Invalid input\n" );
  exit( EXIT_FAILURE );
}

void insert(int len, int p, char ch, char str[STRING_LIMIT + 1])
{
  if (p > STRING_LIMIT) {
    invalid();
  }
  if (((int)ch < NUM_MIN || (int)ch > NUM_MAX)) {
    invalid();
  }
  int i;
  for (i = len; i > p; i--) {
    str[i] = str[i - 1];
  }
  str[p] = ch;
}

static void delete(int len, int p, char str[STRING_LIMIT + 1])
{
  if (p > STRING_LIMIT) {
    invalid();
  }
  int i;
  for (i = p; i < len - 1; i++)
  {
    str[i] = str[i + 1];
  }
  char ss[STRING_LIMIT + 1] = "";
  for (i = 0; i < len - 1; i++)
  {
    ss[i] = str[i];
  }
  strcpy(str, ss);
}

int main()
{
  // Read the filename from standard input.
  char filename[ STRING_LIMIT + 1 ];
  scanf( "%s", filename );

  // Open an input file with the given name.
  FILE *stream = fopen( filename , "r" );

  // This is the representation of the string we're creating.  It starts out
  // as an empty string.
  char str[ STRING_LIMIT + 1 ] = "";

  // Current length of the string.  We could use strlen(), but it's convenient
  // to aslo have a variable for this.
  int len = 0;

  // Read the word at the start of each command.
  int temp = fgetc(stream);
  while (temp != EOF)
  {
    if (len > STRING_LIMIT) {
      invalid();
    }
    if (temp == (int)'\n')
    {
      temp = fgetc(stream);
    }
    char operand[6] = "";
    int opLength = 1;
    char inserting[6] = {'i', 'n', 's', 'e', 'r'};
    char deleting[7] = {'d', 'e', 'l', 'e', 't'};
    operand[0] = temp;
    while (opLength < 6)
    {
      operand[opLength] = fgetc(stream);
      opLength++;
    }
    // Read the operands for the operation.  Make sure it's valid and
    // modify the string if it is.
    char operation[6] = "";
    operation[0] = operand[0];
    operation[1] = operand[1];
    operation[2] = operand[2];
    operation[3] = operand[3];
    operation[4] = operand[4];

    temp = fgetc(stream);
    if ((strcmp(inserting, operation) == 0))
    {
      int p = fgetc(stream) - 48;
      temp = fgetc(stream);
      if(temp != (int) ' ' && temp != EOF && temp != (int) '\n') {
        p = (p * 10) + ((temp)-48);
        temp = fgetc(stream);
      }
      char ch2 = fgetc(stream);
      insert(len, p, ch2, str);
      len++;
 
      temp = fgetc(stream);
    }
    else if (strcmp(deleting, operation) == 0)
    {

      int p = fgetc(stream) - 48;
      temp = fgetc(stream);
      if (temp != (int)' ' && temp != EOF && temp != (int)'\n')
      {
        p = (p * 10) + ((temp)-48);
      }
      delete(len, p, str);
      len--;
    }
    // Print out the current state of the string.
    printf("%s\n", str);
    temp = fgetc(stream);
  }

  // Close the input file.
  fclose(stream);

  return EXIT_SUCCESS;
}
