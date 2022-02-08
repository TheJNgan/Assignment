package com.revature.Exercise1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Calculator
 */
class Calculate {
  private double result = 0.0;
  private String operator = "";

  public void add(double num1, double num2) {
    result = num1 + num2;
    operator = " + ";
  }

  public void subtract(double num1, double num2) {
    result = num1 - num2;
    operator = " - ";
  }

  public void multiply(double num1, double num2) {
    result = num1 * num2;
    operator = " * ";
  }

  public void divide(double num1, double num2) {
    result = num1 / num2;
    operator = " / ";
  }

  public void display(double num1, double num2) {
    System.out.println(num1 + operator + num2 + " = " + result);
  }

}

public class Calculator {

  public static void main(String[] args) {
    double number1 = 0.0;
    double number2 = 0.0;
    boolean flag = false;
    Scanner s = null;
    int key = 0;
    Calculate cal = new Calculate();

    // Get two numbers from user
    do {
      try {
        s = new Scanner(System.in);
        System.out.println("Enter a number for Number 1: ");
        number1 = s.nextDouble();
        System.out.println("Enter a number for Number 2: ");
        number2 = s.nextDouble();
        flag = true;
      } catch (InputMismatchException e) {
        e.printStackTrace();
        System.out.println("Please enter a valid number.");
      } catch (NoSuchElementException e) {
        e.printStackTrace();
        System.out.println("Input is exhausted");
      } catch (IllegalStateException e) {
        e.printStackTrace();
        System.out.println("Scanner is closed.");
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Catch all exception.");
      }
    } while (!flag);

    // Operation base off user's input
    do {
      try {
        s = new Scanner(System.in);
        System.out.println("Please choose an arithmetic operator: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiply");
        System.out.println("4. Division");
        key = s.nextInt();
        if(key >= 1 && key <=4) s.close();
      } catch (InputMismatchException e) {
        e.printStackTrace();
        System.out.println("Please enter a valid number (1-4).");
      } catch (NoSuchElementException e) {
        e.printStackTrace();
        System.out.println("Input is exhausted");
      } catch (IllegalStateException e) {
        e.printStackTrace();
        System.out.println("Scanner is closed.");
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Catch all exception.");
      }
      switch (key) {
        case 1:
          cal.add(number1, number2);
          cal.display(number1, number2);
          break;
        case 2:
          cal.subtract(number1, number2);
          cal.display(number1, number2);
          break;
        case 3:
          cal.multiply(number1, number2);
          cal.display(number1, number2);
          break;
        case 4:
          if (number2 == 0) {
            System.out.println("Cannot divide by zero!");
            break;
          }
          cal.divide(number1, number2);
          cal.display(number1, number2);
          break;
        default:
          System.out.println("Please input number 1-4");
          break;
      }
    } while (key < 1 || key > 4);

  }
}
