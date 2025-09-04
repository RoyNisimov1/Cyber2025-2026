import java.util.ArrayList;
public class Program {
    public static String B2C(String inp){
        StringBuilder s = new StringBuilder();
        for (int c = 0; c < inp.length(); c++) {
            if(inp.charAt(c) != 'b' && inp.charAt(c) != 'B'){
                s.append(inp.charAt(c));
                continue;
            }
            s.append('c');
        }
        return s.toString();
    }
    public static boolean doesNotContainDigits(String s){
        String digits = "0123456789";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < digits.length(); j++) {
                if (s.charAt(i) == digits.charAt(j)) return false;
            }
        }
        return true;
    }
    public static boolean containsLetters(String s){
        String digits = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < digits.length(); j++) {
                if (s.charAt(i) == digits.charAt(j)) return true;
            }
        }
        return false;
    }
    public static boolean firstIsLast(String s){
        return s.charAt(0) == s.charAt(s.length()-1);
    }
    public static int NumberOfWords(String s){
        int numWords = 0;
        if (s.charAt(0) != ' '){
            numWords++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length()-1) break;

            if (s.charAt(i) == ' ' && s.charAt(i+1) != ' ') numWords++;
        }
        return numWords;
    }
    public static boolean isJavaParsable(String s){
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') c++;
            if (s.charAt(i) == '}') c--;
        }
        return c==0;
    }
    public static boolean isPalindrome(String s){
        StringBuilder sr = new StringBuilder(s).reverse();
        return sr.toString().equals(s);
    }
    public static String setLike(String s){
        StringBuilder seen = new StringBuilder();
        boolean seenAtI;
        for (int i = 0; i < s.length(); i++) {
            seenAtI = false;
            for (int j = 0; j < seen.length(); j++) {
                if (s.charAt(i) == seen.charAt(j)){
                    seenAtI = true;
                    break;
                }
            }
            if(seenAtI) continue;
            seen.append(s.charAt(i));

        }
        return seen.toString();
    }
    public static int sequences(String s){
        int numberOfSequences = 1;
        char lastChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != lastChar){
                numberOfSequences++;
            }
            lastChar = s.charAt(i);
        }
        return numberOfSequences;
    }
    public static boolean isGoodPass(String s){
        if (s.length() < 6) return false;
        boolean containsDigit = !Program.doesNotContainDigits(s);
        boolean containsLetter = Program.containsLetters(s);
        return containsLetter && containsDigit;

    }

}
