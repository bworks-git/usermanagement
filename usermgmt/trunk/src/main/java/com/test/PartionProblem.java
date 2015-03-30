package com.test;

public class PartionProblem {

	public static void main(String[] args) {
		System.out.println(canSplit(new int[] { 1, 1 }));
		System.out.println(canSplit(new int[] { 1, 1, 1 }));
		System.out.println(canSplit(new int[] { 2, 3, 1, 2 }));

	}

	public static boolean canSplit(int[] nums) {
		// Calculate sum of the elements in array
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];

		// If sum is odd, there cannot be two subsets with equal sum
		if (sum % 2 != 0)
			return false;

		// Find if there is subset with sum equal to half of total sum
		return isSubsetSum(nums, nums.length, sum / 2);
	}

	public static boolean isSubsetSum(int nums[], int n, int sum) {
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		// If last element is greater than sum, then ignore it
		if (nums[n - 1] > sum)
			return isSubsetSum(nums, n - 1, sum);

		/*
		 * else, check if sum can be obtained by any of the following (a)
		 * including the last element (b) excluding the last element
		 */
		return isSubsetSum(nums, n - 1, sum)
				|| isSubsetSum(nums, n - 1, sum - nums[n - 1]);
	}

}
