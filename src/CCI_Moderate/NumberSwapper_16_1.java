package CCI_Moderate;

/**
 *
 * CCI: 16.1
 *
 * Write a function to swap a number in place (that is without temporary variables)
 *
 * Hints: #492 716 737
 */

public class NumberSwapper_16_1 {

    public static void main(String[] args) {

        swapNumber(-13, -12);

    }

    static void swapNumber(int a, int b){

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a + " " + b);
    }
}
