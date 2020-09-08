package ArraysAndStrings;



/**
 *
 * CCI: 1.9
 *
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings S1 and S2, write the code to check if S2 is a rotation of S1 using only one call to isSubstring
 *
 * Example:
 * S1 = "waterbottle"
 * S2 = "erbottlewat"
 * output = true
 *
 * HINTS:
 * If a string is a rotation of another, then it's a rotation at a particular point.
 * For example a rotation o "waterbottle" at character 3 means cutting "waterbottle" at character 3 and putting
 *  the right half (erbottle) before the left half (wat)
 *
 *  Is there any way we can split S1 in two parts X and Y such that S1 is XY and S2 is YX
 *  X = wat
 *  Y = erbottle
 *
 *  S1 = XY = waterbottle
 *  S2 = YX = erbottlewat
 *
 *  Think about the earlier hint. What happen when we concatenate S2?
 *  erbottlewat will be erbootlewaterbootlewat
 *
 *
 */
public class StringRotation {

    public static void main(String[] args) {

        String str1 = "waterbottle";
        String str2 = "erbottlewat";

        boolean result = isRotated(str1, str2);
        System.out.println(result);


    }

    private static boolean isRotated(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        StringBuilder stringAux = new StringBuilder(str2);
        stringAux.append(str2);

        if(isSubstring(stringAux.toString(),str1))
            return true;
        return false;
    }

    private static boolean isSubstring(String str1, String str2) {
        if(str1.indexOf(str2) != -1)
            return true;
        return false;
    }


}
