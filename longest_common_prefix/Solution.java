import java.util.*;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        String lcp = cmpFirstTwo(strs[0], strs[1]);

        System.out.println(lcp);

        if (strs.length > 2) {
            

            for (int i = 2; i < strs.length; i++) {
                System.out.println("Now comparing to: " + strs[i]);
                lcp = cmpLCP(lcp, strs[i]);
                System.out.println("new lcp: " + lcp);
            }

            System.out.println(lcp);
        }
        

        return lcp;
    }

    public static String cmpLCP(String org_lcp, String to_cmp) {
        // if (to_cmp.indexOf(org_lcp) == -1) {
        int len1 = org_lcp.length();
        int len2 = to_cmp.length();

        String new_lcp = "";

        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (org_lcp.charAt(i) != to_cmp.charAt(i)) {
                break;
            }
        
            new_lcp += org_lcp.charAt(i);
        }

        return new_lcp;
        // }

        // return org_lcp;
    }

    public static String cmpFirstTwo(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        
        String lcp = "";
        
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                break;
            }
            
            lcp += first.charAt(i);
        }
        
        return lcp;
    }

    public static void main(String[] args) {
        // String[] strs = {"flower","flow","flight"};
        String[] strs = {"baab","bacb","b","cbc"};

        String ret = longestCommonPrefix(strs);
    }
}