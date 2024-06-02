import java.util.Scanner;

public class MethodsLab {

    public String signOfInteger(int n){
        if (n > 0) return "The number "+n+" is positive.";
        else if (n < 0) return "The number "+n+" is negative.";
        else return "The number 0 is zero.";
    }

    private static void grades (double grade){
        if(grade >= 2 && grade <= 2.99) System.out.println("Fail"); 
        else if(grade >= 3 && grade <= 3.49) System.out.println("Poor"); 
        else if(grade >= 3.5 && grade <= 4.49) System.out.println("Good"); 
        else if(grade >= 4.5 && grade <= 5.49) System.out.println("Very good"); 
        else if(grade >= 5.5 && grade <= 6) System.out.println("Excellent"); 
    }
    public void printTriangle(int n){
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = n; i > 0; i--) {
            for(int j = 1; j < i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public void calculations(String command, int n1, int n2) {
        switch (command) {
            case "add":
                System.out.println(n1 + n2);
                break;
            case "substract":
                System.out.println(n1 - n2);
                break;
            case "multiply":
                System.out.println(n1 * n2);
                break;
            case "divide":
                System.out.println(n1 / n2);
                break;
        
            default:
                break;
        }
    }
    public void orders(String s, double n) {
        switch (s) {
            case "coffee":
                System.out.printf("%.2f", n*1.5);
                break;
            case "water":
                System.out.printf("%.2f", n*1);
                break;
            case "coke":
                System.out.printf("%.2f", n*1.4);
                break;
            case "snacks":
                System.out.printf("%.2f", n*2);
                break;
            default:
                break;
        }
    }
    public int rectangleArea(int w, int h) {
        return w*h;
    }
    public String repeatString(String s, int n) {
        String newS = "";
        for(int i = 0; i < n; i++) {
            newS += s;
        }
        return newS;
    }
    public double power (double num, int pow) {
        return (double) Math.pow(num, pow);
    }
    public int getMax(int n, int n2) {
        if (n > n2) return n;
        return n2;
    }
    public char getMax(char ch, char ch2) {
        if((int) ch > (int) ch2) return ch;
        return ch2;
    }
    public String getMax(String s, String s2) {
        if(s.compareTo(s2) >= 0) return s;
        return s2;
    }
    public void greaterTwoValues(String s) {
        Scanner scanner = new Scanner(System.in);

        if (s.equals("int")) {
            int n = Integer.parseInt(scanner.nextLine());
            int n2 = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(n, n2));
        } else if (s.equals("char")) {
            char n = scanner.next().charAt(0);
            char n2 = scanner.next().charAt(0);
            System.out.println(getMax(n, n2));
        } else if(s.equals("string")){
            String n = scanner.nextLine();
            String n2 = scanner.nextLine();
            System.out.println(getMax(n, n2));
        }
        
        scanner.close();
    }
    public int multEvensOdds (String n) {
        n = n.replaceFirst("-", "");
        int evens = 0;
        int odds = 0;
        for(int i = 0; i < n.length(); i++){

            if(Integer.parseInt(String.valueOf(n.charAt(i))) % 2 == 0) evens += Integer.parseInt(String.valueOf(n.charAt(i)));
            else if (Integer.parseInt(String.valueOf(n.charAt(i))) % 2 != 0) odds += Integer.parseInt(String.valueOf(n.charAt(i)));
        }
        return evens*odds;
    }
    public double mathOps (double n, String s, double n2) {
        double output = 0;
        if (s.equals("/")) output = n/n2;
        else if (s.equals("*")) output = n*n2;
        else if (s.equals("+")) output = n+n2;
        else if (s.equals("-")) output = n-n2;
        return output;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //double d = Double.parseDouble(scanner.nextLine());
        //int n = Integer.parseInt(scanner.nextLine());
        //String words = scanner.nextLine();
        //String[] nums = words.split(" ");
        double d = Double.parseDouble(scanner.nextLine());
        String s = scanner.nextLine();
        double d2 = Double.parseDouble(scanner.nextLine());
        MethodsLab ml = new MethodsLab();
        System.out.printf("%.0f", ml.mathOps(d, s, d2));
        
        scanner.close();
        
    }
}
