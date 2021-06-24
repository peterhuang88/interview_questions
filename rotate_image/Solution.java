

public class Solution {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // go over each outer layer
        for (int layer = 0; layer < (n+1)/2; layer++) {
            for (int j = layer; j < n - layer - 1; j++) {
                // set the top left corner as temp
                int temp = matrix[layer][j];

                // if (j == 1) {
                //     System.out.println("top: " + temp);
                //     System.out.println("left: " + matrix[n - 1 - j][layer]);
                //     System.out.println("bot: " + matrix[n - 1 - layer][n - 1 - j]);
                //     System.out.println("right: " + matrix[j][n - 1 - layer]);
                // }
                
                matrix[layer][j] = matrix[n - 1 - j][layer]; // move left to top
                matrix[n - 1 - j][layer] = matrix[n - 1 - layer][n - 1 - j]; // move bot to left
                matrix[n - 1 - layer][n - 1 - j] = matrix[j][n - 1 - layer]; // move right to bot
                matrix[j][n - 1 - layer] = temp; // move top to right

                // break;
            }

            // break;
        }
    }

    public static void printMatrix(int arr[][]) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
            System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix =  {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printMatrix(matrix);
        System.out.println("-------------------------------------");
        rotate(matrix);
        System.out.println("-------------------------------------");
        printMatrix(matrix);
    }
}