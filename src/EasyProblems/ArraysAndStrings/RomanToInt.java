package EasyProblems.ArraysAndStrings;

public class RomanToInt {
    public static void main(String[] args) {

        int result = romanToInt("MCMXCIV");
        System.out.println(result);

    }

    static int romanToInt(String s) {
        int result = 0;
        char[] c = s.toCharArray();

        for(int i = 0; i < c.length; i++){

            if(c[i] == 'I' || c[i] == 'X' || c[i] == 'C'){
                if(i + 1 < c.length) {
                    if(coupleValue(c[i], c[i + 1]) > 0) {
                        result = result + coupleValue(c[i], c[i + 1]);
                        i++;
                    } else{
                        result = result + returnInt(c[i]);
                    }
                }else{
                    result = result + returnInt(c[i]);
                }
            }else {
                result = result + returnInt(c[i]);
            }
        }

        return result;
    }

    static public int returnInt(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    static public int coupleValue(char c1, char c2){
        if(c1 == 'I' && c2 == 'V'){
            return 4;
        }else{
            if(c1 == 'I' && c2 == 'X'){
                return 9;
            }else{
                if(c1 == 'X' && c2 == 'L'){
                    return 40;
                }else{
                    if(c1 == 'X' && c2 == 'C'){
                        return 90;
                    }else{
                        if(c1 == 'C' && c2 == 'D'){
                            return 400;
                        }else{
                            if(c1 == 'C' && c2 == 'M'){
                                return 900;
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    /*static int romanToInt(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        char reserve = '\0';

        for(int i = 0; i < c.length; i++){

            if(c[i] == 'I' || c[i] == 'X' || c[i] == 'C'){
                if(reserve == '\0') {
                    reserve = c[i];
                }else{
                    result = result + returnInt(reserve);
                    reserve = c[i];
                }
            }else {
                if (reserve == '\0') {
                    result = result + returnInt(c[i]);
                } else {
                    result = result + (returnInt(c[i]) - returnInt(reserve));
                    reserve = '\0';
                }
            }
        }

    }*/
}
