/*
 * 
 * 238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */


public class ProductOfArrayExceptSelfLeetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {-1,1,0,-3,3};

		int[] ans = productExceptSelf(a);

		for(int i : ans) System.out.println(i);

	}

	public static int[] productExceptSelf(int[] nums) {

		int product = 1;
		int countZero = 0;

		for(int i : nums) {

			if(i == 0) countZero++; 
			else product = product*i;	

		}

		for(int i = 0 ; i<nums.length ; i++){
			if(nums[i] != 0){
				nums[i] = (countZero == 0)?  product/nums[i] : 0;
			}
			else{
				if(countZero >1) nums[i] = 0;
				else nums[i] = product;
			}
		}

		return nums;

	}

}

// space - O(1), Time - O(N)