package datastructure.array.sortedArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

   The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */
public class CombinationSum_I {

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		//initiate the array
	    List<List<Integer>> re = new ArrayList<>();
	    //sort the array
	    Arrays.sort(nums);
        //call helper method
	    backtrack(re, new ArrayList<>(), nums, target, 0);
	    return re;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) 
	    	return;
	    else
	    	if(remain == 0) 
	    		list.add(tempList);
	    else{ 
	    	for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	

}
