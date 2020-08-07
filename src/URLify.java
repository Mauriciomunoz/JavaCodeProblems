public class URLify {

    //Cracking teh coding interview
    //Write a method to replace all spaces in a string with %20
    //You may assume that the string has sufficient space at the end to hold the additional characters, and that you
    //are you given the true length of the size. (Note: If implementing in java, please use a character array so that
    //you can perform this operation in peace)

    public static void main(String[] args) {

        String str1="www.google.com/my cool space";

        String result = urlConvertion(str1);
        System.out.println(result);

    }

    //Time complexity: O(N)
    //Space complexity: O(N)
    private static String urlConvertion(String str1){

        int count=0;

        for(int k = 0; k < str1.length(); k++){
            if(str1.charAt(k) == ' '){
                count++;
            }
        }

       char[] str1array = new char[str1.length() + (count * 2)];
       char[] strAux = str1.toCharArray();

       int j = 0;

       for(int i = 0; i < strAux.length; i++){
           if(strAux[i] == ' '){
               str1array[j] = '%';
               str1array[j+1] = '2';
               str1array[j+2] = '0';
               j+=3;
           }else{
               str1array[j] = strAux[i];
               j++;
           }
       }

        return String.valueOf(str1array);

    }

}
