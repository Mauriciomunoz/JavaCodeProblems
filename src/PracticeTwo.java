import java.util.Arrays;

public class PracticeTwo {


    /*

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

     */

    public static void main(String[] args) {
        int[] array = {2, 1, 3};


        /*

      O(N)     for(int i = 0...
      O(LogN)       x = BinarySearch(i)



        int[] array = {1, 2, 3, 4, |     | 5, 6,|        | 7, |       | 8}; k = 7





         */


        //MAX = 5, 6, 3 = 14
        /*
        int max1 = getMaxValue(array); - 6
        int max2 = getMaxValue(array); - 5
        int max3 = getMaxValue(array); - 3
          */

        /*

                            M0  M1  M2  M3  M4  M5
            array -> array [1] [2] [3] [4] [5] [6]
            array[M3] = 4 - O(1)




                       M0                   M34                    M123               M43                M543                M12
        List ->  NODE_1[1][M123]      NODE_2[3][M543]      NODE_3[2][M34]     NODE_4[6][NULL]     NODE_5[4][M12]      NODE_6[5][M43]

            NODE_123[XXX][NULL]


MXX
HEAD[0][M0]

HASHSET -> VALUE -


Dictionary -> KEY, VALUE || HASHMAP
        [a][100]
        [b][200]
        [c][300]
        [d][600]
        [e][31]


         */

        //output = 3


        /*                  0   1   2   3   4   5
                arrayAux = [0] [1] [1] [1] [1] [1]

         */



      //  System.out.println(twoSum(array));

    }

/*
    public static twoSum(){

    }
*/
}
