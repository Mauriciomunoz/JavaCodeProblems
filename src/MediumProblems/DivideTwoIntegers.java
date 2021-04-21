package MediumProblems;

public class DivideTwoIntegers {


    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
     *
     * Return the quotient after dividing dividend by divisor.
     *
     * The integer division should truncate toward zero, which means losing its fractional part.
     * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
     *
     * Leetcode 29. https://leetcode.com/problems/divide-two-integers/
     * Level: Medium
     *
     * July 28th
     * Started: 11:18pm
     * Finished: 11:40pm
     *
     * @param args
     */

    public static void main(String[] args) {

        int dividend = 0;
        int divisor = 2;

        int result = divideTwoIntegers(dividend, divisor);
        System.out.println(result);

    }

    private static int divideTwoIntegers(int dividend, int divisor){

        int result = 0;
        int cont = 0;
        int negative = 1;

        if(dividend < 0 || divisor < 0)
            negative = -1;

        if(dividend < 0)
            dividend *= -1;

        if(divisor < 0)
            divisor *= -1;

        for(int i = 0; i < dividend; i++){
            if(result <= dividend){
                result += divisor;
                cont++;
            }else{
                cont--;
                break;
            }
        }


        return cont * negative;

    }
}
