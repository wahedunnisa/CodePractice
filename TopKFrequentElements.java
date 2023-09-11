import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 347. Top K Frequent Elements
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/

 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */


public class TopKFrequentElements {

	public static void main(String[] args) {

		int[] a = {1,2};
		int[] topKfreq = topKFrequent(a,2);
		for(int i : topKfreq) System.out.print(i+" ");

	}

	public static int[] topKFrequent(int[] nums, int k) {

		int[] result = new int[k];
		List<List<Integer>> f = new ArrayList();
		HashMap<Integer, Integer> hm = new HashMap();

		for(int i : nums) hm.put(i, hm.getOrDefault(i, 0)+1);

		for(int i = 0; i<= nums.length ; i++) f.add(new ArrayList());

		
		for(Map.Entry<Integer, Integer> map : hm.entrySet()) {
			f.get(map.getValue()).add(map.getKey());
		}

		//		for(List l : f) {
		//			System.out.println(l);
		//		}
		int count = 0;
		for(int i = nums.length; i>=0 ; i--) {
			for(int j = 0; j<f.get(i).size() ; j++) {
				result[count++] = f.get(i).get(j);
			}
			if(count == k) break;
		}

		return result;
	}

}

