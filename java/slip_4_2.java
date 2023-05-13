import java.util.*;
public class slip_4_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
        System.out.print("How many cities : \t");
        int n = s.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter city name and STD code : ");
            String name = s.next();
            int std = s.nextInt();
            ht.put(name,std);
        }
        System.out.println("You have entered : "+ht);
        System.out.println("Enter city name you want to delete : ");
        String name = s.next();
        ht.remove(name);

        System.out.println("After deletion of "+name+" your data set "+ht);

        System.out.println("Enter city name for search : ");
        name = s.next();
        
        System.out.println(ht.get(name));

    }
}
