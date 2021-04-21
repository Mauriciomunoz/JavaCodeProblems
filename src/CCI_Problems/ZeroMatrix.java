package CCI_Problems;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ZeroMatrix {

    /**
     * Cracking the Code Interview
     *
     * Write an Algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
     *
     *
     * [0 1 1 ]
     * [0 1 0 ]
     * [1 1 1 ]
     * [0 1 1 ]
     *
     * [0 0 0 ]
     * [0 0 0 ]
     * [0 1 0 ]
     * [0 0 0 ]
     *
     * @param args
     */

    public static void main(String[] args) {
        int[][] matrix = new int[4][3];
        matrix[0][0] = 0;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 0;
        matrix[1][1] = 5;
        matrix[1][2] = 0;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        matrix[3][0] = 0;
        matrix[3][1] = 8;
        matrix[3][2] = 9;

        int[][] matrix2 = new int[2][3];
        matrix2[0][0] = 1;
        matrix2[0][1] = 1;
        matrix2[0][2] = 1;

        matrix2[1][0] = 1;
        matrix2[1][1] = 1;
        matrix2[1][2] = 0;


        int[][] result = zeroMatrix(matrix2);

    }

    //Time complexity: O(NM)
    //Space complexity: O(N+M)
    //Could be simplified to Space complexity O(1)
    private static int[][] zeroMatrix(int[][] matrix){
        int[] columns = new int[matrix[0].length];
        int[] rows = new int[matrix.length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    columns[j] = 1;
                    rows[i] = 1;
                }
            }
        }

        for(int column_it = 0; column_it < columns.length; column_it++){
            if (columns[column_it] == 1) {
                for(int row_i = 0; row_i < matrix.length; row_i++) {
                    matrix[row_i][column_it] = 0;
                }
            }
        }

        for(int row_it = 0; row_it < rows.length; row_it++){
          if(rows[row_it] == 1){
              for(int column_i = 0; column_i < matrix[0].length; column_i++){
                  matrix[row_it][column_i] = 0;
              }
          }
        }

        return matrix;
    }

}
