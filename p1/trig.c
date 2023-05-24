/**
  @file trig.c 
  @author Duy Pham 
  This file will read an angle, x, from the user as a double value. Then, it will print out 
  a table of successively more accurate approximations of the sine of x, the cosine of x and the tangent of x.
  */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/** Approximation of PI.  For now, we're using our own constant for
    this. There's also one provided by the gnu math library, once we
    learn about that. */
#define PI 3.14159265358979323846

/**
  This function reads the angle input from the user and returns it
*/
double getAngle()
{
  double result = -10.0;
  scanf("%lf", &result);
  if(result == -10.0) {
    printf("Invalid input\n");
    return -10.0;
  }
  if(result > PI || result < -PI) {
    printf("Invalid input\n");
    return -10.0;
  }
  return result;
}

/**
  This function returns the positive difference between a and b.
  @param a input first value 
  @param b input second value 
*/
double difference( double a, double b )
{
  double result = a  - b;
  if(result < 0) {
    result *= -1.00000000;
  }
  return result;
}

/**
  Print the two header lines at the top of the table.
*/
void tableHeader()
{
  printf("terms |         sin |         cos |         tan \n");
  printf("------+-------------+-------------+-------------\n");
}

/** 
  Print a row of the table, reporting the number of terms used for the Taylor series approximation (terms), 
  the current value of sine (s), cosine (c) and tangent (t).
  @param terms input number of terms
  @param s input value of sin 
  @param c input value of cosin 
  @param t input value of tan 
*/
void tableRow( int terms, double s, double c, double t )
{
  printf("%5d |%12.7lf |%12.7lf |%12.7lf\n", terms, s, c, t);
  
}

/**
  This is the main function 
  */
int main()
{
  double angle = getAngle();
  if(angle == -10.0) {
    return EXIT_FAILURE;
  }
  tableHeader();
  int terms = 0;
  int turns = -1;

  double sin;
  double cos;
  double tan;

  //calculate for term 1
  terms++;
  turns++;
  sin = 0;
  cos = 1;
  tan = sin / cos;
  tableRow(terms, sin, cos, tan);

  //calculate sin for terms
  terms++;
  turns++;
  double x = 1;
  double f = angle;
  double y = 1;
  int count = 0;
  bool cont = true;
  double oSin;
  double oCos;
  double difA;
  double difB;
  while(cont) {
    switch(turns) {
      case 1:
        y = 1;
        x = 1;
        count = 0;
        for(int i = 0; i < terms - 1; i++) {
          x = x * f;
          
        }

        if(terms == 2) {
          x = angle;
        }

        for(double z = 1; z <= terms - 1; z++) {
          y = y * z;
          count++;
        }

        if(terms == 2) {
          y = 1;
        }
        
        oSin = sin;
        oCos = cos;
        sin = sin + (1 * (x / y));
        cos = cos + (0 * (x / y));
        //printf("%d, x = %lf, y = %lf, count = %d, f = %lf\n", terms, x, y, count, f);
        tan = sin / cos;
        tableRow(terms, sin, cos, tan);
        difA = difference(oSin, sin);
        difB = difference(oCos, cos);
        if((difA <= 0.000001 && difB <= 0.000001)) {
          cont = false;
          break;
        }
        turns++;
        terms++;
      case 2:
        y = 1;
        x = 1;
        count = 0;
        for(int i = 0; i < terms - 1; i++) {
          x = x * f;
          
        }

        for(double z = 1; z <= terms - 1; z++) {
          y = y * z;
          count++;
        }
        oSin = sin;
        oCos = cos;
        sin = sin;
        cos = (x / y);
        cos = oCos - cos;
        tan = sin / cos;
        tableRow(terms, sin, cos, tan);
        //printf("%d, x = %lf, y = %lf, count = %d, f = %lf\n", terms, x, y, count, f);
        //printf("oCos = %lf, cos = %lf, result = %lf\n", oCos, cos, x/y);
        difA = difference(oSin, sin);
        difB = difference(cos, oCos);
        //printf("difa = %lf, difb = %lf\n", difA, difB);
        if((difA <= 0.000001 && difB <= 0.000001)) {
          cont = false;
          break;
        }
        turns++;
        terms++;
      case 3:
        y = 1;
        x = 1;
        for(int i = 0; i < terms - 1; i++) {
          x = x * f;
          
        }

        for(double z = 1; z <= terms - 1; z++) {
          y = y * z;
          count++;
        }
        oSin = sin;
        oCos = cos;
        sin = sin - (x / y);
        cos = cos + (0 * (x / y));
        tan = sin / cos;
        //printf("%d, x = %lf, y = %d, count = %d, f = %lf", terms, x, y, count, f);
        //printf("%lf,   %lf", x / y, oSin);
        tableRow(terms, sin, cos, tan);
        difA = difference(oSin, sin);
        difB = difference(oCos, cos);
        if((difA <= 0.000001 && difB <= 0.000001)) {
          cont = false;
          break;
        }
        turns = 0;
        terms++;
      case 0:
        y = 1;
        x = 1;
        for(int i = 0; i < terms - 1; i++) {
          x = x * f;
          
        }
        for(double z = 1; z <= terms - 1; z++) {
          y = y * z;
          count++;
        }
        oSin = sin;
        oCos = cos;
        cos = cos + (1 * (x / y));
        tan = sin / cos;
        tableRow(terms, sin, cos, tan);
        //printf("%d, x = %lf, y = %d, count = %d, f = %lf\n", terms, x, y, count, f);
        difA = difference(oSin, sin);
        difB = difference(oCos, cos);
        if((difA <= 0.000001 && difB <= 0.000001)) {
          cont = false;
          break;
        }
        turns++;
        terms++;
    }

  }

  return EXIT_SUCCESS;
}
