public class OneWay {

    /**
     * There are three types of edits that can be performed on strings:
     * Insert a character, remove a character or replace a character. Given two strings,
     * write a function to check if they are one edit (or zero edits) away.
     *
     * Example:
     * Pale, ple -> true
     * pales, pale -> true
     * pale, bale -> true
     * pale, bake -> false
     *
     * 27 July 2020
     *
     * Started: 9:19pm
     * Finished: 9:52pm
     *
     * @param args
     */


    public static void main(String[] args) {

        String str1="pale";
        String str2="bake";

        boolean result = editString(str1, str2);
        System.out.println(result);

    }

    //Time complexity: O(N)
    //Space complexity: O(1)
    private static boolean editString(String str1, String str2){

        if(str2.length() > str1.length() + 1 || str2.length() < str1.length() - 1){
            return false;
        }

        int cont = 0;
        int minLength = str1.length();

        if(str1.length() > str2.length()) {
            cont++;
            minLength = str2.length();
        }
        else{
            if(str2.length() > str1.length()) {
                cont++;
                minLength = str1.length();
            }
        }

        for(int i = 0; i < minLength; i++){
            if (str1.charAt(i) != str2.charAt(i)) {
                cont++;
            }

            if(cont > 1)
                return false;
        }

        return true;
    }

}
