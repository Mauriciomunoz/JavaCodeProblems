import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//CodeSignal

public class FirstNotRepeatingCharacter {
    public static void main(String[] args) {

        firstNotRepeatingCharacter("abacabad");
    }

    static char firstNotRepeatingCharacter(String s) {

        int[] alphabet = new int[26];

        /*
                  a = 0  b =1      c=2    d = 3   e = 4
         alphabet = [4]    [2]    [1]      [1]     []      [] [] [] [] [] ...

        HashMap hm =
        [a][4]
        [b][2]
        [c][1]
        [d][1]

         */

        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            alphabet[c] = alphabet[c] + 1;
        }
        /*
        HashMap<Character, Integer> hm = new HashMap<>();
        for(Map.Entry<Character, Integer> elemento : hm.entrySet()){
            int key = elemento.getKey();
            int value = elemento.getValue();
            if(value == 1)
                return key;
        }*/

        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(alphabet[c] == 1)
                return s.charAt(i);
        }

        return '_';
    }
}
