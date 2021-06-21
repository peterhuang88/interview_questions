import java.util.*;

public class Solution {
    public static int maxArea(int[] height) {
        if (height.length == 2) {
            return calcArea(height, 0, 1);
        }

        return recurse(height, 0, 1);
    }

    public static int recurse(int[] height, int start, int end) {
        // if we've reached the end
        if (start >= height.length || end >= height.length) {
            return 0;
        }

        int currArea = calcArea(height, start, end); // area of current box
        int extendEnd = recurse(height, start, end + 1); // if we extend the front
        int extendStart = recurse(height, end, end + 1); // extend the start index to current index

        return Math.max(currArea, Math.max(extendEnd, extendStart));
    }

    public static int calcArea(int[] height, int start, int end) {
        return (end - start) * (Math.min(height[start], height[end]));
    }

    public static void main(String[] args) {
        // int[] height = {4,3,2,1,4};
        // int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,2,1};
        int max_area = maxArea(height);

        System.out.println(max_area);
    }
}