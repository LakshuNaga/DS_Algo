package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//Given an array of distinct integers candidates and a target integer target,
// return a list of all unique combinations of candidates
// where the chosen numbers sum to target. You may return the combinations in any order.
public class Combination_Sum_I {
    public static void main(String args[])
    {
//        int arr[] = {2,3,6,7};   //output :- [[2,2,3] ,[7]]
//        int target = 7;
        int arr[] = {8,1,8,6,8};   //output :- [[8, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
                                                // [1, 1, 1, 1, 1, 1, 6], [1, 1, 1, 1, 8],
                                                // [1, 1, 1, 1, 8], [6, 6]] (To remove repeated 1,1,1,8 values
                                                // add into set then backtrack by converting the array into list
                                                // and add into set then sort and convert them back to list to array.

        int target = 12;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(arr,0,target,new ArrayList<>(),res);
        System.out.println(res);

    }

    private static void backtrack(int[] arr, int idx, int target, ArrayList<Integer> list,
                                  List<List<Integer>> res) {
        //Base Case :- Check target is equal to 0
        if(target<0) return;
        else if(target==0)
        {
            res.add(new ArrayList<>(list));
        }
        else{
            for(int i=idx;i<arr.length;i++)
            {
                list.add(arr[i]);
                backtrack(arr,i,target-arr[i],list,res);
                list.remove(list.size()-1);
            }
        }

    }

}


//Time Complexity : - (2^number of recursive call) * length of the input  O(k * nCk)
//Space Complexity :- number of recursive call * length of the input
