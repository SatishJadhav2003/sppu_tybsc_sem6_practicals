/**
 * slip_1_1
 */
public class slip_1_1 extends Thread {
   char alphabet = 'a';

    public void run() {
        while (alphabet <='z') {
           System.out.println(alphabet++); 
           try
           {
            Thread.sleep(2000);
           }
           catch(Exception e)
           {
            System.out.println(e);
           }
        }
    }

    public static void main(String[] args) {
        slip_1_1 s = new slip_1_1();
        s.start();
    }

}