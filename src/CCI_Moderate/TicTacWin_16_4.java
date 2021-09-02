package CCI_Moderate;

/**
 *
 * CCI: 16.4
 *
 * Design an algorithm to figure out if somenone has won a game of Tic Tac Toe
 *
 *
 * Hints: #710 732
 */


public class TicTacWin_16_4 {

    public static void main(String[] args) {

        int[][] array = new int[3][3];

        array[0][0] = 1;
        array[0][1] = 1;
        array[0][2] = 0;

        array[1][0] = 1;
        array[1][1] = 1;
        array[1][2] = 0;

        array[2][0] = 0;
        array[2][1] = 1;
        array[2][2] = 0;


        int result = whoWon(array);
        System.out.println(result);

    }

    //TC: O(N^2)
    static int whoWon(int[][] array){
        int result = 0;
        int diff = 0;
        int firstVal = 0;

        int rows = array.length;
        int columns = array[0].length;


        //Check rows
        for(int i = 0; i < rows; i++){
            firstVal = array[i][0];
            for(int j = 0; j < columns; j++){
                if(firstVal != array[i][j]){
                    break;
                }else{
                    if(j == array[i].length - 1){
                        return firstVal;
                    }
                }
            }
        }

        //Check column
        for(int i = 0; i < array[0].length; i++){
            firstVal = array[0][i];
            for(int j = 0; j < array[i].length; j++){
                if(firstVal != array[j][i]){
                    break;
                }else{
                    if(j == array[i].length - 1){
                        return firstVal;
                    }
                }
            }
        }

        //Check diagonal
        for(int i = 0; i < rows; i++){
            firstVal = array[i][i];
            if(firstVal != array[0][0]){
                break;
            }else{
                if(i == rows - 1){
                    return firstVal;
                }
            }
        }

        //Check inversed diagonal
        for(int i = 0; i < rows; i++){
            firstVal = array[i][(rows-1)-i];
            if(firstVal != array[rows - 1][0]){
                break;
            }else{
                if(i == rows - 1){
                    return firstVal;
                }
            }
        }

        return result;
    }



}
