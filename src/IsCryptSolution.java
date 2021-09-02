import java.util.HashMap;

public class IsCryptSolution {



    public static void main(String[] args) {

        /*char[][] solution =
            {{'O', '0'},
            {'M', '1'},
            {'Y', '2'},
            {'E', '5'},
            {'N', '6'},
            {'D', '7'},
            {'R', '8'},
            {'S', '9'}};*/

        //String[] crypt = {"SEND", "MORE", "MONEY"};

        char[][] solution =
                {{'A', '0'}};
        String[] crypt = {"", "A", "A"};

        /*
        char[][] solution =
                {{'O', '1'},
                        {'T', '0'},
                        {'W', '9'},
                        {'E', '5'},
                        {'N', '4'}};
        String[] crypt = {"TEN", "TWO", "ONE"};
*/


        boolean val = isCryptSolution(crypt, solution);
        System.out.println("DONE");
    }


    static boolean isCryptSolution(String[] crypt, char[][] solution) {

        HashMap sol = convertSolutionToHash(solution);
        if(crypt == null || solution == null)
            return false;

        long word1 = getValueOfWord(crypt[0], sol);
        if(word1 == -1)
            return false;

        long word2 = getValueOfWord(crypt[1], sol);
        if(word2 == -1)
            return false;

        long word3 = getValueOfWord(crypt[2], sol);
        if(word1 + word2 != word3)
            return false;

        return true;
    }

    static HashMap<Character, Integer> convertSolutionToHash(char[][] solution){
        HashMap<Character, Integer> sol = new HashMap<>();

        for(int i = 0; i < solution.length; i++){
            char c = solution[i][0];
            int val = Integer.parseInt(String.valueOf(solution[i][1]));
            sol.put(c, val);
        }

        return sol;
    }

    static long getValueOfWord(String word, HashMap<Character, Integer> solution){
        StringBuilder str = new StringBuilder();
        if(word.length() == 0)
            return -1;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int val = solution.getOrDefault(c,-1);
            if(val == 0 && word.length() > 1 && i == 0 || val == -1)
                return -1;
            str.append(val);
        }

        return Long.parseLong(str.toString());
    }

}
