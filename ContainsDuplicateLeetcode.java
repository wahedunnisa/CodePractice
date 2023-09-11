import java.util.HashSet;

/*
 *Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

public class ContainsDuplicateLeetcode {

	public static void main(String[] args) {
		
		int[] array = {1,2,3,5,4};
		
		System.out.println(containsDuplicate(array));

	}
	
	static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        for( int i : nums ){
            if(hs.contains(i)) return true;
            else  hs.add(i);    
        }
        return false;  
    }

}
