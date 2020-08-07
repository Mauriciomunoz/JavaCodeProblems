import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class CheckPermutation {

    //Cracking the coding interview
    //Given two strings, write a method to decide if one is a permutation of the other
    static int NO_OF_CHARS = 256;

    public static void main(String[] args) {

        String str1="aaccadc";
        String str2="cabacca";

        boolean result = arePermutation(str1,str2);
        System.out.println(result);

    }

    //Time complexity: O(N LogN)
    //Space complexity: O(N)
    private static boolean checkPermutation(String str1, String str2){

        if(str1.length()!=str2.length())
            return false;

        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();

        Arrays.sort(str1Array);
        Arrays.sort(str2Array);

        for(int i = 0; i < str1Array.length; i++){
            if(str1Array[i]!=str2Array[i]){
                return false;
            }
        }

        return true;
    }

    //Time complexity: O(N)
    //Space complexity: O(N)
    //Internet solution
    static boolean arePermutation(String str1, String str2)
    {
        char[] str1arr = str1.toCharArray();
        char[] str2arr = str2.toCharArray();

        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int [NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int [NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i < str1arr.length && i < str2arr.length ; i++)
        {
            count1[str1arr[i]]++;
            count2[str2arr[i]]++;
        }

        // If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (str1arr.length != str2arr.length)
            return false;

        // Compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }
}
