public class RotateImage {
/*      0  1  2
a = 0 [[1, 2, 3],
    1  [4, 5, 6],
    2  [7, 8, 9]]

     0,0 = 0,0
     0,1 = 1,0
     0,2 = 2,0
     1,1 = 1,1
     1,2 = 2,1
     2,2 = 2,2

a' = [[1, 4, 7],
      [2, 5, 8],
      [3, 6, 9]]

      0,0 = 0,2
      0,1 = 0,1
      0,2 = 0,0
      1,0 = 1,2
      1,1 = 1,1
      1,2 = 1,0
      2,0 = 2,2
      2,1 = 2,1
      2,2 = 2,0

a' = [[7, 4, 1],
      [8, 5, 2],
      [9, 6, 3]]

     */


//CodeSignal

    public static void main(String[] args) {

        int[][] matrix =   {{1,2,3},
                            {4,5,6},
                            {7,8,9}};

        matrix = rotateImage(matrix);
    }

    static int[][] rotateImage(int[][] a) {
        a = transpose(a);
        a = reverse(a);

        return a;
    }

    static int[][] transpose(int[][] matrix){
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = i; j < matrix.length; j++){
                if(i != j) {
                    int aux = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = aux;
                }
            }
        }

        return matrix;
    }

    static int[][] reverse(int[][] matrix){

        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix.length / 2; j++){
                int aux = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = aux;
            }
        }

        return matrix;
    }
}
