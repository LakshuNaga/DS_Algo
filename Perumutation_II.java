package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Perumutation_II {
    public static void main(String args[])
    {
        int nums[] = {1,2,3,3};
        List<List<Integer>> res = new ArrayList<>();
        boolean visited[]= new boolean[nums.length];
        backtrack(nums,new ArrayList<>(),visited,res);

        System.out.println(res);
        System.out.println(res.size());
    }

    private static void backtrack(int[] nums, ArrayList<Integer> list,boolean[] visited, List<List<Integer>> res) {

        if(list.size()==nums.length)
        {
            res.add(new ArrayList<>(list));
        }

        for(int i=0;i<nums.length;i++)
        {
            if(visited[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            //if(i>0 && nums[i]==nums[i-1] && visited[i-1]) continue;  //both works
            visited[i]=true;
            list.add(nums[i]);
            backtrack(nums,list,visited,res);
            list.remove(list.size()-1);
            visited[i]=false;
        }
    }
}
