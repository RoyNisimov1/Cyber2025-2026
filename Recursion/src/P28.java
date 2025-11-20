public class P28 {

    public static void main(String[] args) {
        ex24('a', 'z');
    }

    public static void ex24(char beginChar, char endChar){
        String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
        int bI = lowerCaseAlphabet.indexOf(beginChar);
        int eI = lowerCaseAlphabet.indexOf(endChar);
        if (bI+1>=eI) return;
        if (beginChar == 'y') return;
        System.out.print(lowerCaseAlphabet.charAt(bI+1));
        ex24(lowerCaseAlphabet.charAt(bI+1), endChar);
    }


}
