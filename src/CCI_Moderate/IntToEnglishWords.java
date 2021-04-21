package CCI_Moderate;

import java.util.HashMap;

/**
 *
 * CCI: 16.8
 * Leetcode: https://leetcode.com/problems/integer-to-english-words/
 *
 * Given any integer print an English phrase that describes the integer.
 * (eg. "One Thousand, Two Hundred Thirty Four")
 *
 *
 * Hints: #502 588 688
 */

public class IntToEnglishWords {

    public static void main(String[] args) {

        //25014 Twenty five thousand
        //250146 Two hundred thousand
        //2 501 467 Two million five hundred thousand
        //22 501 467 twenty two million five hundred thousand
        //222 501 467 two hundred twenty two million
        //1 000 000 000 One billion
        //1 222 501 467 One billion two hundred twenty two million five hundred thousand four hundred sixty seven
        //100 030 164


        int value = 1223501467;//123030164;
        //int value = 123;

        String result = numberToWords(value);
        System.out.println(result);

    }

    static public String numberToWords(int num) {
        StringBuilder str = new StringBuilder();

        int billions = num  / 1000000000;
        int millions = (num % 1000000000 ) / 1000000;
        int thousands = (num % 1000000) / 1000;
        int hundreds = num % 1000;

        if(num == 0){
            return "Zero";
        }

        if(num < 0)
            str.append("Negative ");

        if(billions > 0){
            str.append(getStringValue(billions) + " Billion");
        }

        if(millions > 0){
            str.append(getStringValue(millions) + " Million");
        }

        if(thousands > 0){
            str.append(getStringValue(thousands) + " Thousand");
        }

        if(hundreds > 0){
            str.append(getStringValue(hundreds));
        }

        str.replace(0,1,"");
        return str.toString();
    }

    static public String getStringValue(int value){

        HashMap<Integer, String> myDictionary = new HashMap<>();

        myDictionary.put(1, "One");
        myDictionary.put(2, "Two");
        myDictionary.put(3, "Three");
        myDictionary.put(4, "Four");
        myDictionary.put(5, "Five");
        myDictionary.put(6, "Six");
        myDictionary.put(7, "Seven");
        myDictionary.put(8, "Eight");
        myDictionary.put(9, "Nine");

        myDictionary.put(10, "Ten");
        myDictionary.put(11, "Eleven");
        myDictionary.put(12, "Twelve");
        myDictionary.put(13, "Thirteen");
        myDictionary.put(14, "Fourteen");
        myDictionary.put(15, "Fifteen");
        myDictionary.put(16, "Sixteen");
        myDictionary.put(17, "Seventeen");
        myDictionary.put(18, "Eighteen");
        myDictionary.put(19, "Nineteen");

        myDictionary.put(20, "Twenty");
        myDictionary.put(30, "Thirty");
        myDictionary.put(40, "Forty");
        myDictionary.put(50, "Fifty");
        myDictionary.put(60, "Sixty");
        myDictionary.put(70, "Seventy");
        myDictionary.put(80, "Eighty");
        myDictionary.put(90, "Ninety");

        StringBuilder aux = new StringBuilder();

        int hundreds = value / 100;
        if(hundreds > 0)
            aux.append(" " + myDictionary.get(hundreds) + " Hundred");

        int tenths = value % 100;
        if(tenths > 0 && tenths < 21)
            aux.append(" " + myDictionary.get(value % 100));
        else{
            if(tenths > 0) {
                int individual = tenths % 10;
                aux.append(" " + myDictionary.get((tenths / 10) * 10));
                if (individual > 0)
                    aux.append(" " + myDictionary.get(individual));
            }
        }

        return aux.toString();
    }

}
