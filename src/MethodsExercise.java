import java.util.Scanner;

public class MethodsExercise {
    public int smallestOfThree(int n1, int n2, int n3) {
        int smallest = n1;
        if (n2 < n1 && n2 < n3) {
            smallest = n2;
        } else if (n3 < n1 && n3 < n2) {
            smallest = n3;
        }
        return smallest;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //double d = Double.parseDouble(scanner.nextLine());
        //int n = Integer.parseInt(scanner.nextLine());
        //String words = scanner.nextLine();
        //String[] nums = words.split(" ");
        //double d = Double.parseDouble(scanner.nextLine());
        //String s = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        MethodsExercise me = new MethodsExercise();
        System.out.println(me.smallestOfThree(n, n2, n3));
        scanner.close();
    }
}
