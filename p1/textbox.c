/**
  @file textbox.c 
  @author Duy Pham 
  This file will wrap the given text in a border 
  */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/** Width of each line of text in the box. */
#define LINE_WIDTH 60

/** Width of border */
#define BORDER_WIDTH 62

/** constant number one */
#define ONE 1

/** constant number zero */
#define ZERO 0

/** Symbol used to draw the border around the box. */
#define BORDER '*'

/** Symbol used to draw space character */
#define SPACE ' '

/**
  This function will read and print a single line of text 
  inside the border
  */
bool paddedLine()
{
  char ch = getchar();
  int count = ZERO;
  if(ch == EOF) return false;
  if(ch == '\n') {
    ch = getchar();
  }
  if(ch == EOF) return false;
  putchar(BORDER);
  putchar(ch);
  count++;
  bool less = false;
  
  for(int i = ONE; i < LINE_WIDTH + ONE; i++) {
    if(i < LINE_WIDTH) {
      if(less) {
        putchar(SPACE);
      } else {
        ch = getchar();
        if(ch != '\n' || ch != EOF) {
          if(ch != '\n') {
            putchar(ch);
            count++;
          } else {
            less = true;
          }
        }
      } 
    } 
  }
  
  if(count == LINE_WIDTH) {
    ch = getchar();
    while(ch != '\n' && ch != EOF) {
      ch = getchar();
    }
    ungetc(ch, stdin);
  }

  if(less) putchar(SPACE);
  putchar(BORDER);
  printf("\n");
  if(less) {
    ch = getchar();
    if(ch == '\n') {
      putchar(BORDER);
      for(int i = ZERO; i < LINE_WIDTH; i++) {
        putchar(SPACE);
      }
      putchar(BORDER);
      putchar('\n');
    } else {
      ungetc(ch, stdin);
    }
  }
  return true;
}

/**
  This function prints out multiple copies of the given character, 
  followed by a newline
  @param ch input character 
  @param count number of copies 
  */
void lineOfChars( char ch, int count )
{
  for(int i = 0; i < count; i++) {
    putchar(ch);
  }
  printf("\n");
}

/**
  This is the main function 
  */
int main()
{
  lineOfChars(BORDER, BORDER_WIDTH);
  bool result = paddedLine();
  while(result == true) {
    result = paddedLine();
  }
  lineOfChars(BORDER, BORDER_WIDTH);
  return EXIT_SUCCESS;
}
