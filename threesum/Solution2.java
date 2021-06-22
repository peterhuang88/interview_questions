import java.util.*;

public class Solution2 {
    public static List<List<Integer>> threeSum(int[] nums) {
        // create a hashmap with the set of nums
        // HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();

        // for (int i = 0; i < nums.length; i++) {
        //     mymap.put(i, nums[i]);
        // }

        // sort array prior to being used
        Arrays.sort(nums);

        Set<List<Integer>> ret = new HashSet<List<Integer>>();
        HashSet<List<Integer>> seen = new HashSet<List<Integer>>();
        HashSet<Integer> seen_nums = new HashSet<Integer>(); // prolly inefficient use of space but w/e

        // go over each individual number
        for (int i = 0; i < nums.length - 2; i++) {
            int anchor = nums[i];
            
            twosum(nums, ret, -anchor, i, seen);
            
            // if (!seen_nums.contains(nums[i])) {
            //     twosum(nums, ret, -nums[i], i, seen);
            //     seen_nums.add(nums[i]);
            // }
        }
        
        return new ArrayList(ret);
    }

    // we want to skip the initial index
    public static void twosum(int[] nums, Set<List<Integer>> ret, int target, int initial, HashSet<List<Integer>> seen) {
        int start = initial + 1; // start from the number directly after the current number we're on
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] == target) {
                ret.add(Arrays.asList(nums[initial], nums[start], nums[end]));
                // System.out.println("Found: " + nums[start] + " and " + nums[end]);
                // ret.add(Arrays.asList(nums[start], nums[end]));
                start++;
                end--;

                while (nums[start] == nums[start-1] && start < end) {
                    start++;
                }

                while (nums[end] == nums[end+1] && start < end) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            }
        } 
    }

    public static void main(String[] args) {
        // List<List<Integer>> ret = new ArrayList<List<Integer>>();
        // Set<List<Integer>> ret = new HashSet<List<Integer>>();
        // HashSet<List<Integer>> seen = new HashSet<List<Integer>>();

        // int[] nums = {2,3,6,7};
        int[] nums = {-1,0,1,2,-1,-4};

        // twosum(nums, ret, 9, -1, seen);
        List<List<Integer>> ret = threeSum(nums);
        // List<List<Integer>> ret2 = new ArrayList(ret);

        for (int i = 0; i < ret.size(); i++) {
            System.out.println(Arrays.toString(ret.get(i).toArray()));
        }
    }
}