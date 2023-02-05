package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Generate_Paranthesis {
    public static void main(String args[])
    {
        int n=3;
        List<String> res = new ArrayList<>();
        backtrack(0,0,n,res,"");
        System.out.println(res);

    }

    private static void backtrack(int open, int close, int n, List<String> res, String s) {
        if(open==n && close==n)
        {
            res.add(s);
        }

        if(open<n)
        {
            s+="(";
            backtrack(open+1,close,n,res,s);
            s=s.substring(0,s.length()-1);
        }

        if(close<open)
        {
            s+=")";
            backtrack(open,close+1,n,res,s);
            s=s.substring(0,s.length()-1);
        }
    }

}
