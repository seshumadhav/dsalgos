package com.hackerrank.myprofile;

import java.util.Scanner;

/**
 * Link: https://www.hackerrank.com/challenges/maxsubarray
 *
 * @author seshu
 */
public class MaximumSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// sc.useDelimiter(",\\s*");
		int T = sc.nextInt();
		validate(T, 1, 10);

		int[][] inputs = new int[T][];
		for (int i = 0; i < T; i++) {
			sc = new Scanner(System.in);
			int N = sc.nextInt();
			validate(N, 1, Math.pow(10, 5));

			inputs[i] = new int[N];
			for (int j = 0; j < N; j++) {
				sc = new Scanner(System.in);
				inputs[i][j] = sc.nextInt();
				validate(inputs[i][j], -1 * Math.pow(10, 4), Math.pow(10, 4));
			}
		}

		// print2dArray(inputs);
		for (int i = 0; i < T; i++) {
			System.out.println(maxContiguous(inputs[i]) + " "
			    + maxNonContiguous(inputs[i]));
		}
	}

	private static int maxContiguous(int[] input) {
		return -1;
	}

	private static int maxNonContiguous(int[] input) {
		return -1;
	}

	private static void print2dArray(int[][] array) {
		StringBuffer sb = new StringBuffer();
		for (int[] element : array) {
			for (int element2 : element) {
				sb.append(element2);
				sb.append(" ");
			}
			sb.append("\n");
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
