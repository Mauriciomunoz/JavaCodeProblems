package EasyProblems;

import java.util.HashSet;

public class HappyNumber {

    public static void main(String[] args) {

//        int[] n = {2,7,1,4,3,5};
        int n = 2;


        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {

        HashSet<Integer> results = new HashSet<>();
        int value = 0;

        while(n != 1){

            String str = String.valueOf(n);

            for(int i = 0; i < str.length(); i++){
                value += (int) Math.pow( Character.getNumericValue(str.charAt(i)) , 2);
            }

            if(results.contains(value))
                return false;

            results.add(value);
            n = value;
            value = 0;
        }

        return true;
    }
}
