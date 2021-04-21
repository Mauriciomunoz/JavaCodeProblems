import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KickStart1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String s = in.next();
            hm.put(n,s);
           //System.out.println("Case #" + i + ": " + increasingSubstrings(s, n));
            //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
            //System.out.println("Case #" + i + ": " + n +  " Str = " + m);
        }

        for (Map.Entry<Integer, String> entry : hm.entrySet()
             ) {
            int i = 1;
            System.out.println("Case #" + i++ + ": " + increasingSubstrings(entry.getValue(), entry.getKey()));

        }


    }

    public static String increasingSubstrings(String s, int n){
        StringBuilder sAux = new StringBuilder();
        int[] aux = new int[n];

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
