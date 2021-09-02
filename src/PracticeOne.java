import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashSet;

public class PracticeOne {


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3};
        /*                  0   1   2   3   4   5
                arrayAux = [0] [1] [1] [1] [1] [1]

         */

        //array = {2,3,3,2}

        System.out.println(searchRepeated(array));

        int[] arraySearch = {100, 6, 3, 5, 4, 1};

        //Sort (NLogN) + Binary Search O(LogN) = N2Log = NLogN
        //int[] arraySearch = {1, 3, 4, < | | > 5, 6 < | |> 100};

        //Linear search O(N)

        //a[n] positive always
        //array never null



        System.out.println(search(array, 6));
    }


    public static int searchRepeated(int[] array){
        //O(N^2) = N*N
/*
        int val1 = searchRepeated2(array);
        int val2 = searchRepeated2(array2);

*/

        /*
                           M0  M1  M2  M3  M4  M5
            array -> array [1] [2] [3] [4] [5] [6]
            array[M3] = 4

                       M0                   M34                    M123               M43                M543                M12
            List -> NODE_1[1][M123][]      NODE_2[3][M543][]      NODE_3[2][M34][M0]      NODE_4[6][NULL]      NODE_5[4][M12]      NODE_6[5][M43]

MXX
HEAD[0][M0]


Dictionary -> KEY, VALUE || HASHMAP
        [a][100]
        [b][200]
        [c][300]
        [d][600]
        [e][31]

        dictionary.get(e) = 31


Set - VALUE  | HASHSET
        [2]
        [3]
        [5]
        [123]
        [34]

        HASHTABLE ->
        [0x121FF][100]->[500]->[]->[]->[]->[]->[]
        [0x12388GG][200]->[]->[]->[]->[]
        [0x13132][300]->[]->[]->[]->[]
        [0x213][600]->[]->[]->[301]->[]->[]
        [0x31244][31]->[]->[]->[]->[]->[]->[]->[]->[]->[]->[]->[]



         */
        int length = array.length;

        if(array.length == 1){
            return -1;
        }

        //O(N) Time Complexity
        //array = {1, 2, 3, 4, 5, 3};
        //O(N) Space
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < length; i++){
            if(hs.contains(array[i])){
               return array[i];
            }
            hs.add(array[i]);
        }
        //hs = 1,2,3,4,5

/*
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(array[i] == array[j]){
                    return array[i];
                }
            }
        }
*/
        return -1;


    }


    public static int searchRepeated2(int[] array){
        int length = array.length;


        int val = getMaxValue(array) //Get the bigger number in array y delete it
        int val2 = getMaxValue(array) //Get the bigger number in array y delete it
        int val3 = getMaxValue(array) //Get the bigger number in array y delete it


        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(array[i] == array[j]){
                    return array[i];
                }
            }
        }

        return -1;

    }

    public static int searchSameValue(int[] array1, int[] array2){

        //array1 = { 1, 2, 3, 4} - N
        //array2 = { 5, 6, 3} - M

        //O(N*M)
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if(array1[i] == array2[j]){
                    return 1;
                }
            }
        }

        return -1;
    }



    public static int search(int[] array, int n){
        //O(N)
        for(int j = 0; j < array.length; j++){
            if(array[j] == n){
                return j;
            }
        }

        return -1;
    }

    public static int searchInTwo(int[] array,  int[] array2, int n){
        //O(N+M) = O(2N) = O(N)
        int result = 0;
        for(int j = 0; j < array.length; j++){
            if(array[j] == n){
                result = 1;
            }
        }

        for(int j = 0; j < array2.length; j++){
            if(array2[j] == n){
                result++;
            }
        }

        if(result == 2)
            return 1;

        return -1;
    }

}
