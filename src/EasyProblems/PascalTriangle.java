package EasyProblems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 *
 */


public class PascalTriangle {


    public static void main(String[] args) {

        int[] nums = {1,2,3};

        List<List<Integer>> result = generate2(5);

        System.out.println("DONE");
    }


    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            if(i == 0){
                elements.add(1);
            }else{
                List<Integer> elements2 = new ArrayList<>();
                for(int j = 0; j < elements.size() + 1; j++){
                    if(j == 0 || j == elements.size()){
                        elements2.add(1);
                    }else{
                        elements2.add(elements.get(j) + elements.get(j - 1));
                    }
                }
                elements = elements2;
            }
            result.add(elements);
        }

        return result;
    }

    public static List<List<Integer>> generate2(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        result.add(elements);
        int j = 0;
        List<Integer> elements2 = new ArrayList<>();

        while(elements.size() < numRows){
            if(j == 0){
                elements2.add(1);
                j++;
            }else{
                if(j != elements.size()){
                    elements2.add(elements.get(j) + elements.get(j - 1));
                    j++;
                }else {
                    elements2.add(1);
                    result.add(elements2);
                    elements = elements2;
                    elements2 = new ArrayList<>();
                    j = 0;
                }
            }
        }

        return result;
    }
}
