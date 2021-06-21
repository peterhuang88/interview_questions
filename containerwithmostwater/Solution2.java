import java.util.*;

public class Solution2 {
    public static int maxArea(int[] height) {
        if (height.length == 2) {
            return calcArea(height, 0, 1);
        }

        int start = 0;
        int end = height.length - 1;
        int max_area = 0;

        while (start < end) {
            max_area = Math.max(max_area, calcArea(height, start, end));

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max_area;
    }

    public static int calcArea(int[] height, int start, int end) {
        return (end - start) * (Math.min(height[start], height[end]));
    }

    public static void main(String[] args) {
        int[] height = {4,3,2,1,4};
        // int[] height = {1,8,6,2,5,4,8,3,7};
        // int[] height = {1,2,1};
        int max_area = maxArea(height);

        System.out.println(max_area);
    }
}