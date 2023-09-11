/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
 */


import java.util.HashMap;

public class TwoSumLeetcode {

	public static void main(String[] args) {
		
		int[] result = new int[2];
		int[] a = {3,2,4};
		result = twoSum(a, 6);
		for(int i : result) System.out.println(i);

	}
	
	 public static int[] twoSum(int[] nums, int target) {

	        int[] solution = new int[2];

	        HashMap<Integer,Integer> h = new HashMap();

	        for(int i=0; i<nums.length ; i++) {
	        	if(h.containsKey(target - nums[i])) {
	        		solution[0]=h.get(target-nums[i]);
	        		solution[1] = i;
	        	}
	        	else h.put(nums[i], i);
	        }
	        
	        return solution;
	    }

}


// Space complexity - O(N), Time Complexity - O(N)