package com.test.misc;

public class FindMissingNumber {

	public static void main(String args[]) {
		int[] numbers1 = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };
		findMissingNumber2(numbers1);

		int[] numbers4 = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };
		findMissingNumber2(numbers4);

		int[] numbers2 = { 1, 2, 3, 0, 5, 6, 7, 8, 9, 10 }; // here, 4 is the
															// missing number
															// represented as 0
		findMissingNumber(numbers2);

		Integer[] numbers3 = { 1, 2, 3, null, 5, 6, 7, 8, 9, 10 }; // here, 4 is
																	// the
																	// missing
																	// number
																	// represented
																	// as null
		findMissingNumber(numbers3);
	}

	private static int findMissingNumber2(int[] arr) {
		// will be the sum of the numbers in the array.
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		// the total sum of numbers between 1 and arr.length.
		int n = arr.length + 1; // add 1 for missing slot
		int total = n * (n + 1) / 2;

		int missingNum = total - sum;
		System.out.println("missing number is: " + missingNum);
		return missingNum;
	}

	private static int findMissingNumber(int[] arr) {
		// will be the sum of the numbers in the array.
		int sum = 0;
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				idx = i;
			} else {
				sum += arr[i];
			}
		}

		// the total sum of numbers between 1 and arr.length.
		int n = arr.length;
		int total = n * (n + 1) / 2;

		int missingNum = total - sum;
		int missingIndex = idx;
		System.out.println("missing number is: " + missingNum + " at index "
				+ missingIndex);
		return missingNum;
	}

	private static int findMissingNumber(Integer[] arr) {
		// will be the sum of the numbers in the array.
		int sum = 0;
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				idx = i;
			} else {
				sum += arr[i];
			}
		}

		// the total sum of numbers between 1 and arr.length.
		int n = arr.length;
		int total = n * (n + 1) / 2;

		int missingNum = total - sum;
		int missingIndex = idx;
		System.out.println("missing number is: " + missingNum + " at index "
				+ missingIndex);
		return missingNum;
	}

	/**
	 * In the above methods, if the sum of the numbers goes beyond maximum allowed
	 * integer, then there can be integer overflow and we may not get correct
	 * answer. This method has no such problems but with a little performance problem.
	 * 
	 * @param arr
	 * @return
	 */
	private static int findMissingNumber3(int[] arr) {
		int n = arr.length;
		int i;
		int x1 = arr[0]; /* For xor of all the elemets in arary */
		int x2 = 1; /* For xor of all the elemets from 1 to n+1 */

		for (i = 1; i < n; i++)
			x1 = x1 ^ arr[i];

		for (i = 2; i <= n + 1; i++)
			x2 = x2 ^ i;

		int missingNum = x1 ^ x2;
		System.out.println("missing number is: " + missingNum);
		return missingNum;
	}
}
