/*
 * 
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 
 */


public class ValidAnagramLeetCode {

	public static void main(String[] args) {
		
		System.out.println(isAnagram("ghjkl","ghjklllllllll"));

	}


	public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] a = new char[26];
        for(int i = 0; i<s.length(); i++){
            a[s.charAt(i)-'a']++;
        }
        for(int j = 0; j<t.length() ; j++){
            a[t.charAt(j)-'a']--;
        }
        for(int i = 0; i<26;i++) if(a[i] !=0) return false;
        return true;
        
    }
}
