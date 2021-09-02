import java.util.HashMap;

public class Sudoku2 {


    public static void main(String[] args) {

/*        char[][] grid =
        {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
         {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
         {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
         {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
         {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
         {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
         {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
         {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};*/


/*

[[".",".",".",".",".",".",".",".","."],
 [".",".","2",".",".",".",".",".","."],
 [".",".",".",".",".","2","7","1","."],
 [".",".",".",".",".",".",".",".","."],
 [".","2",".",".",".",".",".",".","."],
 [".","5",".",".",".",".",".",".","."],
 [".",".",".",".","9",".",".",".","8"],
 [".",".",".",".",".","1","6",".","."],
 [".",".",".",".","6",".",".",".","."]]
 */
        char[][] grid =
            {{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
             {'.', '.', '2', '.', '.', '.', '.', '.', '.'},
             {'.', '.', '.', '.', '.', '2', '7', '1', '.'},
             {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
             {'.', '2', '.', '.', '.', '.', '.', '.', '.'},
             {'.', '5', '.', '.', '.', '.', '.', '.', '.'},
             {'.', '.', '.', '.', '9', '.', '.', '.', '8'},
             {'.', '.', '.', '.', '.', '1', '6', '.', '.'},
             {'.', '.', '.', '.', '6', '.', '.', '.', '.'}};


        boolean val = sudoku2(grid);
        System.out.println("DONE");
    }

    /*
    hashmap columns -  1 - 3, 2
                       4 - 4
                       2 - 7, 7
                       6 - 2, 1
                       7 - 2
                       9 - 8
                       8 - 6

    hashmap rows:   1 - 0, 3
                    4 - 0
                    2 - 0, 5
                    6 - 1, 4
                    7 - 4
                    9 - 4
                    8 - 5

     */
    static boolean sudoku2(char[][] grid) {
        HashMap<Character, int[]> rows = new HashMap<>();
        HashMap<Character, int[]> cols = new HashMap<>();
        HashMap<Character, int[]> quads = new HashMap<>();


        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] != '.'){
                    int[] row = rows.get(grid[i][j]);
                    if(row == null){
                        int[] newRow = new int[9];
                        newRow[i] = 1;
                        rows.put(grid[i][j], newRow);
                    }else{
                        if(row[i] == 1){
                            return false;
                        }else{
                            row[i] = 1;
                            rows.put(grid[i][j], row);
                        }
                    }

                    int[] col = cols.get(grid[i][j]);
                    if(col == null){
                        int[] newCol = new int[9];
                        newCol[j] = 1;
                        cols.put(grid[i][j], newCol);
                    }else{
                        if(col[j] == 1){
                            return false;
                        }else{
                            col[j] = 1;
                            cols.put(grid[i][j], col);
                        }
                    }

                    int[] quad = quads.get(grid[i][j]);
                    if(quad == null){
                        int[] newQuad = new int[9];
                        newQuad[getQuad(j, i)] = 1;
                        quads.put(grid[i][j], newQuad);
                    }else{
                        if(quad[getQuad(j, i)] == 1){
                            return false;
                        }else{
                            quad[getQuad(j, i)] = 1;
                            quads.put(grid[i][j], quad);
                        }
                    }
                }
            }
        }

        return true;
    }

    static int getQuad(int x, int y){
        if(x < 3 && y < 3) {
            return 0;
        }
        else{
            if(x >= 3 && x < 6 && y < 3) {
                return 1;
            }
            else{
                if(x >= 6 && x < 9 && y < 3) {
                    return 2;
                }
                else{
                    if(x < 3 && y >= 3 && y < 6) {
                        return 3;
                    }
                    else{
                        if(x >= 3 && x < 6 && y >= 3 && y < 6) {
                            return 4;
                        }
                        else{
                            if(x >= 6 && x < 9 && y >= 3 && y < 6) {
                                return 5;
                            }
                            else{
                                if(x < 3 && y >= 6 && y < 9) {
                                    return 6;
                                }
                                else{
                                    if(x >= 3 && x < 6 && y >= 6 && y < 9) {
                                        return 7;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 8;
    }
}
