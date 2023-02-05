package BackTracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//Number of Permutation = n!
//example : n=3 , number of permutation = 3!= 3*2 =6.
//Time Complexity : O(n*n!)
//Space Complexity : O(n)
public class Permutation {
    public static void main(String args[])
    {
        int nums[] = {1,2,3,4};
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),res);
        System.out.println(res);
        System.out.println(res.size());
    }

    private static void backtrack(int[] nums, ArrayList<Integer> list, List<List<Integer>> res) {

        if(list.size()==nums.length)
        {
            res.add(new ArrayList<>(list));
        }

        for(int i=0;i<nums.length;i++)
        {
            if(list.contains(nums[i])) continue;

            list.add(nums[i]);
            backtrack(nums,list,res);
            list.remove(list.size()-1);
        }
    }
}
