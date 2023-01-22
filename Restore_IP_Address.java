package BackTracking;

import java.util.ArrayList;
import java.util.List;

//Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
public class Restore_IP_Address {
    public static void main(String[] args)
    {
        String s = "25525511135";
        List<String> res = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),res);
        System.out.println(res);
    }
    public static void backtrack(String s,int idx,List<String> list,List<String> res)
    {
        if(list.size()==4)     //if the list has 4 str means, we can add 3 dots in IP Address.IP Address
                                 //should have only <=12 characters,if it exceeds then making the ip address is not possible
        {
            if(idx==s.length())   //this condition make sure we reached end of the string character , we exhausted all possiblities till n length
            {
                res.add(String.join(".",list));
            }
        }

        for(int i=idx+1;i<=idx+3 && i<=s.length();i++)
        {
            String str = s.substring(idx,i);
            //string should not start with 0 unless its a single character '0' and value of the string
            //should be less than or equal to 255
            if((str.equals("0")|| !str.startsWith("0") && Integer.parseInt(str)<=255))
            {
                list.add(str);
                backtrack(s,i,list,res);
                list.remove(list.size()-1);
            }
        }

    }
}
