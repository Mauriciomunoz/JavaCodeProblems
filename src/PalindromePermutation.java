import java.util.Arrays;

public class PalindromePermutation {

    /**
     * Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
     *
     * 27 July 2020
     *
     * Started: 12:45 am
     * Finished: 12:59 am
     *
     * @param args
     */

    public static void main(String[] args) {

        String str1="Tact Coaa";

        boolean result = isPalindromePermutation(str1);
        System.out.println(result);

    }

    private static boolean isPalindromePermutation(String str1){

        //tac t cat
        //Just can be 1 odd number of chars

        str1 = str1.replaceAll(" ","");
        str1 = str1.toLowerCase();

        char[] strArray = str1.toCharArray();

        Arrays.sort(strArray);

        int oddCont = 0;
        int cont = 1;

        for(int i = 1; i < strArray.length; i++){
            if(strArray[i-1] != strArray[i]){

                if(cont % 2 != 0){
                    oddCont++;
                }

                if(oddCont > 1){
                    return false;
                }

                cont=1;

            }else{
                cont++;
            }
        }

        return true;
    }

}
