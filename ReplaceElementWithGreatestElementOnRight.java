/*
 * 1299. Replace Elements with Greatest Element on Right Side

Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.


Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Example 2:

Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.
 */

public class ReplaceElementWithGreatestElementOnRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {400};
		a = replaceElements2(a);
		for(int i : a) System.out.println(i);

	}

	public static int[] replaceElements(int[] arr) {
		if(arr.length == 0) return arr;
		int[] res = new int[arr.length];
		
		res[arr.length-1] = -1;
		
		for(int i = arr.length-2 ; i>=0 ; i--) {	
			res[i] = Math.max( arr[i+1], (i+1 == arr.length-1?arr[i+1] : res[i+1]));	
		}
			
		return res;

	}
	
	//Trying to optimize above approach
	public static int[] replaceElements2(int[] arr) {
		
		if(arr.length == 0) return arr;
		int prev = Integer.MIN_VALUE;
		
		for(int i = arr.length-2 ; i>=0 ; i--) {
			int cur = arr[i];
			
			arr[i] = Math.max(arr[i+1], prev);
			
			prev = cur;
		}
		arr[arr.length-1] = -1;
		
		return arr;
	}
}

//space = 0(1), time - 0(n)


/*
 * prev = min
 * 
 * 17,18,5,4,6,1
 * 
 * 
 * 4 - ans = max(1,prev), prev = 6;   --- 17,18,5,4,1,1
 * 3-  ans = max(1, prev), prev = 4; ---- 17,18,5,6,1,1
 * 2 - ans = max(6, prev), prev = 5 ----- 17,18,6,6,1,1
 * 1 - ans = max(6,prev), prev = 18 -----17,6,6,6,1,1
 * 
 * 
 */
