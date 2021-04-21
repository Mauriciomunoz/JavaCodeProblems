package CCI_Problems;

/**
 *
 * CCI: 8.5
 *
 * Write a recursive function to multiply two positive integers without using the * operator
 * You can use addition, substraction and bit shifting but you should minimize the number of those operations
 *
 *
 *
 * Hints: #166 ,203 227 234 246 280
 */

public class RecursiveMultiply_8_5 {

    public static void main(String[] args) {

        int result = multiply(31, 13);
        System.out.println(result);

    }

    static int multiply(int a, int b){
        if(b==1){
            return a;
        }else{
            return a + multiply(a, b - 1);
        }
    }
}
