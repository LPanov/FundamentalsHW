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
    private boolean isVowel(char ch) {
        ch = String.valueOf(ch).toUpperCase().charAt(0); 
        return (ch=='A' || ch=='E' || ch=='I' || 
                        ch=='O' || ch=='U'); 
    }
    public int vowelsCount (String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) count++;
        }
        return count;
    }
    public void charsInRange(char a, char b) {
        if((int) a < (int) b){
            for(int i = (int) a + 1; i < (int) b; i++) {
                System.out.print((char) i + " ");
            }
        }
        else if((int) a >= (int) b) {
            for(int i = (int) b + 1; i < (int) a; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
    private boolean isRightLng (String s) {
        return s.length() >= 6 && s.length() <= 10;
           
    }
    private boolean isLetAndDigs(String s){  
        int countValid = 0;
        for(int i = 0; i < s.length(); i++) {
            if (((int) s.charAt(i) > 64 && (int) s.charAt(i) < 91) || 
                ((int) s.charAt(i) > 96 && (int) s.charAt(i) < 123) || 
                ((int) s.charAt(i) > 47 && (int) s.charAt(i) < 58)) countValid++;
        }
        return countValid == s.length();
    }
    private boolean isTwoDigs (String s) {
        int countValid = 0;
        for(int i = 0; i < s.length(); i++) { 
            if ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57) countValid++;
        }
        return countValid >= 2;
    }

    public void passwordValidator() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
            if (!isRightLng(s)) {
                System.out.println("Password must be between 6 and 10 characters");
            }
            if (!isLetAndDigs(s)) {
                System.out.println("Password must consist only of letters and digits");
            }
            if (!isTwoDigs(s)) {
                System.out.println("Password must have at least 2 digits");
            }

            if (isRightLng(s) && isLetAndDigs(s) && isTwoDigs(s)) System.out.println("Password is valid");

        scanner.close();
    }
    private int sum (int n1, int n2) {
        return n1+n2;
    }
    private int substract (int n1, int n2) {
        return n1 - n2;
    }
    public void addAndSubstract() {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        System.out.println(substract(sum(n1, n2), n3));
        scanner.close();
    }
    public void midleChar (String s) {
        String mid = "";
        if (s.length() % 2 == 0) {
            mid = s.substring(s.length()/2 - 1, s.length()/2 + 1);
        } else {
            mid = s.substring(s.length()/2, s.length()/2 + 1);
        }
        System.out.println(mid);
    }
    public void nXn (int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    private double factorial (int num) {
        if (num == 0 || num == 1) return 1; 
        return num * factorial(num - 1);
    }
    public void factorialDiv (int n1, int n2) {
        System.out.printf("%.2f", factorial(n1)/factorial(n2));
    }
    private boolean isPolindrome (String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev.equals(s);
    }
    public void polidromeInt (String s) {
        if(isPolindrome(s)) System.out.println("true");
        else System.out.println("false");
    }
    private boolean isDivisible (String n) {
        int sum = 0;
        for(int i = 0; i < n.length(); i++) {
            sum += Integer.parseInt(String.valueOf(n.charAt(i)));
        }
        return sum % 8 == 0;
    }
    private boolean hasOdd (String n) {
        boolean hasOdd = false;
        for(int i = 0; i < n.length(); i++) {
            if(Integer.parseInt(String.valueOf(n.charAt(i))) % 2 != 0) {
                hasOdd = true;
                break;
            }
        }
        return hasOdd;
    }
    public void topNumber (int n) {
        for(int i = 1; i <= n; i++) {
            if(isDivisible(String.valueOf(i)) && hasOdd(String.valueOf(i))) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //double d = Double.parseDouble(scanner.nextLine());
        //int n = Integer.parseInt(scanner.nextLine());
        //String words = scanner.nextLine();
        //String[] nums = words.split(" ");
        //double d = Double.parseDouble(scanner.nextLine());
        //String s = scanner.nextLine();
        //int n = Integer.parseInt(scanner.nextLine());
        //MethodsExercise me = new MethodsExercise();
        
        scanner.close();
    }
}
