import java.util.*;

public class slip_21_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();

        List<String> subjects = new LinkedList<>();

        System.out.println("Enter " + n + " subject names:");
        for (int i = 0; i < n; i++) {
            String subject = scanner.next();
            subjects.add(subject);
        }

        System.out.println("Subject names:");
        Iterator<String> iterator = subjects.iterator();
        while (iterator.hasNext()) {
            String subject = iterator.next();
            System.out.println(subject);
        }

        scanner.close();
    }
}
