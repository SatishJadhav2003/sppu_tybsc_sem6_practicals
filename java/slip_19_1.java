import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class slip_19_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        List<Integer> numbers = new LinkedList<>();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            numbers.add(num);
        }

        System.out.println("Negative integers:");
        for (int num : numbers) {
            if (num < 0) {
                System.out.println(num);
            }
        }

        scanner.close();
    }
}
