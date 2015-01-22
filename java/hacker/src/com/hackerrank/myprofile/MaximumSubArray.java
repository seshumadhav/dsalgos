package com.hackerrank.myprofile;

import java.util.Scanner;

/**
 * Link: https://www.hackerrank.com/challenges/maxsubarray
 * Submission: https://www.hackerrank.com/challenges/maxsubarray/submissions/code/2666049
 *
 * @author seshu
 */
public class MaximumSubArray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    validate(T, 1, 10);

    int[][] inputs = new int[T][];
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      validate(N, 1, Math.pow(10, 5));

      inputs[i] = new int[N];
      for (int j = 0; j < N; j++) {
        inputs[i][j] = sc.nextInt();
        validate(inputs[i][j], -1 * Math.pow(10, 4), Math.pow(10, 4));
      }
    }

    // print2dArray(inputs);
    for (int i = 0; i < T; i++) {
      int[] array = inputs[i];
      // print1dArray(array);
      System.out.println(maxContiguous(array) + " " + maxNonContiguous(array));
    }

    sc.close();
  }

  private static int maxContiguous(int[] array) {
    if (array.length == 0) {
      return 0;
    }

    int max = array[0];
    int sum = array[0];

    /*
     * Previous version of same code lines#56, 57 if (cur + sum >= sum) { sum +=
     * cur; } else if (cur + sum < cur) { sum = cur; } else { sum += cur; }
     *
     * It does not work because: eg: cur=40 sum=-60 we expect sum to be reset to
     * 40, but we end up setting sum to -20 with above code
     */
    for (int i = 1; i < array.length; i++) {
      int cur = array[i];
      sum = max(cur + sum, cur);
      max = max(max, sum);
    }

    return max;
  }

  private static int maxNonContiguous(int[] array) {
    if (allNegativeNumbers(array)) {
      return max(array);
    }

    int sum = 0;
    for (int element : array) {
      if (element >= 0) {
        sum += element;
      }
    }

    return sum;
  }

  private static boolean allNegativeNumbers(int[] array) {
    for (int element : array) {
      if (element >= 0) {
        return false;
      }
    }

    return true;
  }

  private static int max(int[] array) {
    if (array.length == 0) {
      return Integer.MIN_VALUE;
    }

    int max = array[0];
    for (int element : array) {
      if (max <= element) {
        max = element;
      }
    }
    return max;
  }

  private static int max(int a, int b) {
    return a >= b ? a : b;
  }

  private static void print2dArray(int[][] array) {
    StringBuffer sb = new StringBuffer();
    for (int[] element : array) {
      print1dArray(element);
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }

  private static void print1dArray(int[] array) {
    StringBuffer sb = new StringBuffer();
    for (int element : array) {
      sb.append(element);
      sb.append(" ");
    }

    System.out.println(sb.toString());
  }

  private static void validate(long input, long min, long max) {
    if (input < min || input > max) {
      System.out.println("Cannot proceed. Invalid input specified");
      System.exit(1);
    }
  }

  private static void validate(double input, double min, double max) {
    if (input < min || input > max) {
      System.out.println("Cannot proceed. Invalid input specified");
      System.exit(1);
    }
  }

}
