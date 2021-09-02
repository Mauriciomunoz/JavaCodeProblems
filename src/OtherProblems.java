import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherProblems {
    public static void main(String[] args) {

        boolean[] schedule = {false, true, true, false, false, true, true, true , true};
        int pod = 1;

        //    int[][] matrix = {{1,0,0,1,0}, {1,0,1,0,0}, {0,0,1,0,1},{1,0,1,0,1},{1,0,1,1,0}};
        int[][] matrix = {
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}
        };

        riverSizes(matrix);
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[][] visited = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] != 0 && visited[i][j] == 0){
                    result.add(visitRiver(j, i, matrix, 0, visited));
                }
            }
        }

        return result;
    }

    public static int visitRiver(int x, int y, int[][] matrix, int counter, int visited[][]){
        if(x == matrix[0].length
                || x < 0
                || y < 0
                || y == matrix.length
                || visited[y][x] == 1)
            return 0;

        visited[y][x] = 1;

        if( matrix[y][x] != 1)
            return 0;

        counter = visitRiver(x + 1, y, matrix, counter, visited)
                + visitRiver(x, y + 1, matrix, counter, visited)
                + visitRiver(x - 1 , y , matrix, counter, visited)
                + visitRiver(x, y - 1, matrix, counter, visited);

        return counter + 1;

    }

    public static boolean test() {

        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);

        int j = 0;
        for(int i = 0 ; i < array.size(); i++){
            if(array.get(i) == sequence.get(j)){
                j++;
            }
            if(j > sequence.size()){
                return true;
            }
        }
        return false;
    }

}
