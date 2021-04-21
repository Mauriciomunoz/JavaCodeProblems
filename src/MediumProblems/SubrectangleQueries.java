package MediumProblems;

/**
 *
 * https://leetcode.com/problems/subrectangle-queries/
 *
 * Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:
 *
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1) and bottom right coordinate is (row2,col2).
 * 2. getValue(int row, int col)
 *
 * Returns the current value of the coordinate (row,col) from the rectangle.
 *
 *
 *
 *
 */

public class SubrectangleQueries {
    public static void main(String[] args) {

        int[][] array = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueriesObject subrectangleQueries = new SubrectangleQueriesObject(array);
        System.out.println(subrectangleQueries.getValue(0,2));
        subrectangleQueries.updateSubrectangle(0,0,3,2,5);
        System.out.println(subrectangleQueries.getValue(3,1));
        System.out.println(subrectangleQueries.getValue(0,2));
        subrectangleQueries.updateSubrectangle(3,0,3,2,10);
        System.out.println(subrectangleQueries.getValue(3,1));
        System.out.println(subrectangleQueries.getValue(0,2));
        System.out.println("DONE");
    }
}

class SubrectangleQueriesObject {

    int[][] rectangle;

    public SubrectangleQueriesObject(int[][] rectangle) {
        this.rectangle = new int[rectangle.length][rectangle[0].length];
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int row = row1; row <= row2; row++){
            for(int col = col1; col <= col2; col++){
                rectangle[row][col] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
