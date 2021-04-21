package CCI_Moderate;

public class CodeSignal {
    public static void main(String[] args) {

        int[] a = {16, 1 , 4 ,2,14};
        int[] b = {7,11,2, 0,15};



        int result = countTinyPairs(a, b, 743);
        System.out.println(result);

    }

    static int countTinyPairs(int[] a, int[] b, int k) {
        //a & b size are the same
        //a iteration from left to right
        //b iteration from right to left
        //look for pairs (x, y) where x is from a and y is from b
        //the pair is called 'tiny'
        //tiny is the pair who concatenation is less than K
        //return the number of tiny pairs
        int count = 0;
/*
        for(int i = 0; i < a.length; i++){
            for(int j = b.length - 1; j > 0; j--){
                if(Integer.parseInt(String.valueOf(a[i]) + String.valueOf(b[j])) < k){
                    count++;
                }
            }
        }*/

        int i = 0;
        int j = b.length - 1;

        while(i < a.length && j >= 0){
            if(Integer.parseInt(String.valueOf(a[i]) + String.valueOf(b[j])) < k){
                count++;
            }
            i++;
            j--;
        }

        return count;

    }
}
