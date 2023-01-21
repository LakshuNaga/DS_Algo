package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Find all valid combinations of k numbers that sum up to n such that the following
// conditions are true:
//Only numbers 1 through 9 are used.Each number is used at most once.
//Return a list of all possible valid combinations.The list must not contain the
// same combination twice,and the combinations may be returned in any order.
public class Combination_Sum_III {
    public static void main(String args[])
    {
        int k = 3; // size of the sum that add up to the target
        int target = 7;

        List<List<Integer>> res = new ArrayList<>();
        backtrack(1,k,target,new ArrayList<>(),res);
        System.out.println(res);

    }

    private static void backtrack(int idx,int k, int target, ArrayList<Integer> list,
                                  List<List<Integer>> res) {

        if(list.size()>k) return;
        else if(list.size()==k && target==0)
        {
            res.add(new ArrayList<>(list));
        }
        else{
            for(int i=idx;i<=9;i++) {
                if (target >= i) {
                    list.add(i);
                    backtrack( i+1,k, target - i, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }

    }

}


//Time Complexity : - (2^number of recursive call) * length of the input
//Space Complexity :- number of recursive call * length of the input
