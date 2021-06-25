import java.util.*;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            
            while (lo < )
        }
    }


    public static void main(String[] args) {
        // int[] nums = {-1,2,1,-4};
        int[] nums = {0,2,1,-3};

        int ret = threeSumClosest(nums, 1);

        System.out.println(ret);
    }
}