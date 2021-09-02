public class SummingTwoStrings_FB_Interview {

    /**
     * Having two strings representing a number each, write a function to return a string with the sum of both numbers.
     *
     * Example:
     *
     * input:
     * a = "123"
     * b = "9"
     *
     * output:
     * c = "132"
     *
     */


    public static void main(String[] args) {

        char c = 'c';
        System.out.println(c - 'a');

        char c2 = '2';
        System.out.println(c2 - '3');

        System.out.println("Result is " + sumTwoStrings("999","1"));
    }


    public static String sumTwoStrings(String a, String b){
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int aux1 = 0;
        int aux2 = 0;

        while(carry > 0 || i >= 0 || j >= 0){
            if(i >= 0){
                aux1 = a.charAt(i) - '0';
            }else{
                aux1 = 0;
            }

            if(j >= 0){
                aux2 = b.charAt(j) - '0';

            }else{
                aux2 = 0;

            }

            sum = (aux1 + aux2 + carry) % 10;
            carry = (aux1 + aux2 + carry) / 10;
            result.insert(0, String.valueOf(sum));
            i--;
            j--;
        }


        return result.toString();
    }

}
