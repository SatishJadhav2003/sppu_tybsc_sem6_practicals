import java.util.*;

public class slip_6_1 {
    public static void main(String args[]) throws Exception
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How many numbers : ");
        int n =s.nextInt();
        TreeSet<Integer> ts = new TreeSet<Integer>();
        System.out.println("Enter numbers : ");
        for(int i=0;i<n;i++)
        {
            ts.add(s.nextInt());
        }
        System.out.println("You have Entered "+ts);
        System.out.println("Enter number to search : ");
        int num = s.nextInt();
        System.out.println(ts.contains(num));

    }
}
