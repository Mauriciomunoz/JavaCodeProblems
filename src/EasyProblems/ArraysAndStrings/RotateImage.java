package EasyProblems.ArraysAndStrings;


/**
 *
 * LeetCode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 */

public class RotateImage {
    public static void main(String[] args) {
       /* int[][] image = new int[4][4];
        image[0][0] = 5;
        image[0][1] = 1;
        image[0][2] = 9;
        image[0][3] = 11;

        image[1][0] = 2;
        image[1][1] = 4;
        image[1][2] = 8;
        image[1][3] = 10;

        image[2][0] = 13;
        image[2][1] = 3;
        image[2][2] = 6;
        image[2][3] = 7;

        image[3][0] = 15;
        image[3][1] = 14;
        image[3][2] = 12;
        image[3][3] = 16;*/

        int[][] image = new int[3][3];
        image[0][0] = 1;
        image[0][1] = 2;
        image[0][2] = 3;

        image[1][0] = 4;
        image[1][1] = 5;
        image[1][2] = 6;

        image[2][0] = 7;
        image[2][1] = 8;
        image[2][2] = 9;

        rotate(image);


    }

    //TC: O(N^2)
    //SC: O(1)
    private static void rotate(int[][] matrix) {

        int aux = 0;
        int length = matrix.length;

        for(int i = 0; i < length; i++){
            for(int j = i; j < length; j++){
                if(i != j){
                    aux = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = aux;
                }
            }
        }

        for(int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(j > (length - 1) - j)
                    break;
                aux = matrix[i][j];
                matrix[i][j] = matrix[i][(length - 1) - j];
                matrix[i][(length - 1) - j] = aux;
            }
        }
    }

}
