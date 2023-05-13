import java.util.*;

public class slip_2_1 {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        System.out.println("How many names : ");
        int n = s.nextInt();
        HashSet<String> hs = new HashSet<String>();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter"+i+1+" th name : ");
            hs.add(s.next());
        }
        System.out.println(hs);
    }
}
