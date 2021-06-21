import java.util.*;

public class temp {
    public static void main(String[] args) {
        int[] nums = {2,7,3,6};
        int[] nums2 = {2,7,3,6};

        Arrays.sort(nums);

        HashSet<List<Integer>> temp = new HashSet<List<Integer>>();

        temp.add(Arrays.asList(1,2,3));
        temp.add(Arrays.asList(1,2,3));

        System.out.println(temp.size());
        System.out.println(Arrays.toString(nums));
    }
}