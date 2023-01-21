package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sum to target.
//Each number in candidates may only be used once in the combination.
//Note: The solution set must not contain duplicate combinations.
public class Combination_Sum_II {
    public static void main(String args[])
    {
//        int arr[] = {2,3,6,7};   //output :- [[2,2,3] ,[7]]
//        int target = 7;
        int arr[] = {2,5,2,1,2};
        int target = 5;
        Arrays.sort(arr);
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
            for(int i=idx;i<arr.length;i++) {
                if (i > idx && arr[i] == arr[i - 1]) continue;
                if (target >= arr[i]) {
                    list.add(arr[i]);
                    backtrack(arr, i + 1, target - arr[i], list, res);
                    list.remove(list.size() - 1);
                }
            }
        }

    }

}


//Time Complexity : - (2^number of recursive call) * length of the input
//Space Complexity :- number of recursive call * length of the input
