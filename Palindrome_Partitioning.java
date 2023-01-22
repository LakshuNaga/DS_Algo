package BackTracking;

import java.util.ArrayList;
import java.util.List;
//Given a string s, partition s such that every substring of the partition is a
//palindrome.Return all possible palindrome partitioning of s.
//Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
public class Palindrome_Partitioning {
    public static void main(String[] args)
    {
        String s = "aabbaa";
        List<List<String>> res = new ArrayList<>();

        backtrack(s,0,new ArrayList<>(),res);
        System.out.println(res);
    }

    private static void backtrack(String s, int idx, ArrayList<String> list, List<List<String>> res) {
        if(idx==s.length())
        {
            res.add(new ArrayList<>(list));
        }

        for(int i=idx;i<s.length();i++)
        {
            String str = s.substring(idx,i+1);   //i+1-->s.substring(0,1)--> ex: aab output val :- a
            if(palindrome(str))
            {
                list.add(str);
                backtrack(s,i+1,list,res);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean palindrome(String str) {

        int i=0,j=str.length()-1;
        while(i<=j)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
