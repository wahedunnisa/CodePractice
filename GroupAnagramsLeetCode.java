/*
 * 
 * 49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsLeetCode {

	public static void main(String[] args) {

		List<List<String>> rel = new ArrayList();

		String[] strs = {"eat","tea","tan","ate","nat","bat"};

		//rel = groupAnagrams(strs);
		rel = groupAnagramsOptimise(strs);
		

		for(List<String> l : rel) {
			System.out.println(l);
		}

	}

	//Solution -1
	static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList();
		int[] p = new int[strs.length];

		for(int i = 0; i<strs.length ; i++) {
			HashMap<Character, Integer> hm = returnHashMap(strs[i]);
			if(p[i] != -1) {
				result.add(new ArrayList());
				result.get(result.size()-1).add(strs[i]);
				for(int j = i+1 ; j<strs.length ; j++) {
					if(p[j] != -1) {
						HashMap<Character, Integer> hm2 = returnHashMap(strs[j]);
						if(hm.equals(hm2)) {
							p[j] = -1;
							result.get(result.size()-1).add(strs[j]);
						}
					}
				}
			}
		}
		return result;
	}

	//Trying to optimize above solution
	static List<List<String>> groupAnagramsOptimise(String[] strs) {
		List<List<String>> result = new ArrayList();
		HashMap<HashMap, ArrayList>hm = new HashMap();
		for(int i = 0; i<strs.length ; i++) {
			
			HashMap<Character, Integer> str = returnHashMap(strs[i]);
			
			if(hm.containsKey(str)) {
				ArrayList<Integer> a = hm.get(str);
				a.add(i);
				hm.put(str, a);
			}
			else {
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(i);
				hm.put(str,a);
			}
		}
		
		for(Map.Entry<HashMap, ArrayList> res : hm.entrySet()) {
			ArrayList<Integer> r = res.getValue();
			ArrayList<String> ans = new ArrayList();
			
			for( Integer x : r) ans.add(strs[x]);
			
			result.add(ans);
		}
		return result;
	}


	static HashMap returnHashMap(String s) {

		HashMap<Character, Integer> hm = new HashMap();
		for(int i = 0; i<s.length(); i++) {
			if(hm.containsKey(s.charAt(i))) {
				hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
			}
			else hm.put(s.charAt(i), 1);
		}
		return hm;
	}
}
