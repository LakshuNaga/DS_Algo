package BackTracking;

import java.util.ArrayList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers
// chosen from the range [1, n].
//You may return the answer in any order.

//Input: n = 4, k = 2
//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//Explanation: There are 4 choose 2 = 6 total combinations.
//Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
public class Combinations {
    public static void main(String args[])
    {

        int n=4;
        int k=2;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n,1,k,new ArrayList<>(),res);
        System.out.println(res);

    }

    private static void backtrack(int n, int idx, int k, ArrayList<Integer> list,
                                  List<List<Integer>> res) {
        //Base Case :- Check target is equal to 0
         if(list.size()==k)
        {
            res.add(new ArrayList<>(list));
            return;
        }

            for(int i=idx;i<=n;i++)
            {
                list.add(i);
                backtrack(n,i+1,k,list,res);
                list.remove(list.size()-1);
            }


    }

}


//Time Complexity : - (2^number of recursive call) * length of the input  O(k * nCk)
//Space Complexity :- number of recursive call * length of the input
