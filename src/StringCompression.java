public class StringCompression {
    /**
     * Implement a method to perform basic string compression using the counts of repeated characters.
     * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become
     * smaller than the original string, your method should return the original string.
     * You can assume the string has only uppercase and lowercase letters.
     *
     * 27 July 2020
     *
     * Started: 10:04pm
     * Finished: 10:13pm
     *
     * @param args
     */


    public static void main(String[] args) {

        String str1="aabcccccaaa";

        String result = compressString(str1);
        System.out.println(result);

    }

    private static String compressString(String str){
        String strResult = "";

        int cont = 1;
        int flag = 0;

        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) == str.charAt(i)){
                cont++;
                flag = 1;
            }else{
                strResult = strResult + str.charAt(i-1) + cont;
                cont = 1;
            }
        }

        strResult = strResult + str.charAt(str.length()-1) + cont;

        if(flag == 0)
            return str;

        return strResult;
    }

}
