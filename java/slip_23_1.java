import java.util.*;

public class slip_23_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter string : ");
        String str = s.next();
        checkVowel cv = new checkVowel(str);
        cv.start();
    }
}

class checkVowel extends Thread {
    String str;

    checkVowel(String str) {
        this.str = str;
    }

    public void run() {

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isVowel(c)) {
                System.out.println(c);
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    }

    boolean isVowel(char c) {
        char ch = Character.toLowerCase(c);
        return ch == 'a' || ch == 'i' || ch == 'o' || ch == 'e' || ch == 'u';
    }
}