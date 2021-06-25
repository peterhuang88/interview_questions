import java.util.*;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int best_sum = 0;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                    best_sum = sum;
                    
                    if (sum == target) {
                        break;
                    }
                }
                
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return best_sum;
    }

    public static void main(String[] args) {
        // int[] nums = {-1,2,1,-4};
        // int[] nums = {0,2,1,-3};
        int[] nums = {-3,-2,-5,3,-4};

        int ret = threeSumClosest(nums, -1);

        System.out.println(ret);
    }
}