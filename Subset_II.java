package BackTracking;

import java.util.ArrayList;
import java.util.List;
//Given an integer array nums that may contain duplicates, return all possible
//subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.

//Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

//Time Complexity :- O(N*2^N)
public class Subset_II {
    public static void main(String args[])
    {
        int nums[] = {1,2,2};
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),res);
        System.out.println(res);
        System.out.println(res.size());
    }

    private static void backtrack(int[] nums,int idx, ArrayList<Integer> list, List<List<Integer>> res) {
            res.add(new ArrayList<>(list));

            for(int i=idx;i<nums.length;i++)
            {
                if(i>idx && nums[i]==nums[i-1]) continue;
                list.add(nums[i]);
                backtrack(nums,i+1,list,res);
                list.remove(list.size()-1);
            }

    }
}
