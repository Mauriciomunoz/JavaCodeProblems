import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        ArrayList<String> strList = new ArrayList<>();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String s = in.next();
            strList.add(increasingSubstrings(s, n));
        }

        int i = 1;
        for (String str : strList) {
            System.out.println("Case #" + i + ": " + str);
            i++;
        }

    }

    public static String increasingSubstrings(String s, int n){
        StringBuilder sAux = new StringBuilder();
        int[] aux = new int[n];

        if(n == 1)
            return "1";

        aux[0] = 1;
        sAux.append("1");

        for(int i = 1; i < n; i++){
            if(s.charAt(i) > s.charAt(i - 1)){
                sAux.append(" ");
                sAux.append(aux[i - 1] + 1);
                aux[i] = aux[i - 1] + 1;
            }else{
                sAux.append(" ");
                sAux.append("1");
                aux[i] = 1;
            }
        }

        return sAux.toString();
    }
}
