import java.util.HashMap;

public class IsUnique {

    public static void main(String[] args) {

        String str="achv";

        boolean result = areChractersUnique(str);
        System.out.println(result);

    }

    //Using an extra data structure
    private static boolean isUnique(String str){

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int cont = 0;

        for ( char c : str.toCharArray()
             ) {
            if(hm.containsKey(c)){
                return false;
            }else{
                hm.put(c,1);
            }
        }

        return true;
    }

    //Not using data structure
    private static boolean isUnique2(String str){
        char c;


        for(int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            for(int j = i+1; j < str.length(); j++){
                if(c == str.charAt(j)){
                    return  false;
                }
            }
        }

        return true;
    }


    static boolean areChractersUnique(String str)
    {

        // An integer to store presence/absence
        // of 26 characters using its 32 bits.
        int checker = 0;

        for (int i = 0; i < str.length(); ++i)
        {
            int val = (str.charAt(i)-'a');

            // If bit corresponding to current
            // character is already set
            if ((checker & (1 << val)) > 0)
                return false;

            // set bit in checker
            checker |= (1 << val);
        }

        return true;
    }
}
