package EasyProblems.ArraysAndStrings;

public class PalindromeNum {

    public static void main(String[] args) {

        boolean result = isPalindrome(121);
        System.out.println(result);

    }

    static boolean isPalindrome(int x) {
        char[] chars = ("" + x).toCharArray();

        int j = chars.length - 1;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != chars[j])
                return false;
            if(i == j)
                break;
            j--;
        }
        return true;
    }
}
