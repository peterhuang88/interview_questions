import java.util.*;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        // create a hashmap with the set of nums
        // HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();

        // for (int i = 0; i < nums.length; i++) {
        //     mymap.put(i, nums[i]);
        // }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> seen = new HashSet<List<Integer>>();

        // go over each individual number
        for (int i = 0; i < nums.length; i++) {
            int anchor = nums[i];
            
            twosum(nums, ret, -anchor, i, seen);
        }
        
        return ret;
    }

    // we want to skip the initial index
    public static void twosum(int[] nums, List<List<Integer>> ret, int target, int initial, HashSet<List<Integer>> seen) {
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (i == initial) { // skip the initial index
                continue;
            }

            int complement = target - nums[i];

            if (temp.containsValue(complement)) {
                // int[] res = Arrays.sort(-target, nums[i], complement);
                int[] res = {-target, nums[i], complement};
                Arrays.sort(res);
                if (!seen.contains(Arrays.asList(res[0], res[1], res[2]))) {
                    seen.add(Arrays.asList(res[0], res[1], res[2]));
                    ret.add(Arrays.asList(res[0], res[1], res[2]));
                }
                // ret.add(Arrays.asList(-target, nums[i], complement));
            } else {
                temp.put(i,nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        // int[] nums = {2,7,3,6};
        int[] nums = {-1,0,1,2,-1,-4};

        // twosum(nums, ret, 9, 1);
        ret = threeSum(nums);

        for (int i = 0; i < ret.size(); i++) {
            System.out.println(Arrays.toString(ret.get(i).toArray()));
        }
    }
}