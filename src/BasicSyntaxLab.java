import java.util.Scanner;

public class BasicSyntaxLab{
    public static void studentInformation(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        double g = Double.parseDouble(scanner.nextLine());
        System.out.printf("Name: %s, Age: %d, Grade: %.2f", s, n, g);
        scanner.close();
    }
    public static void passed(){
        Scanner scanner = new Scanner(System.in);
        double g = Double.parseDouble(scanner.nextLine());
        if(g >= 3.00) System.out.printf("Passed!");
        scanner.close();  
    }
    public static void passedOrFailed(){
        Scanner scanner = new Scanner(System.in);
        double g = Double.parseDouble(scanner.nextLine());
        if(g >= 3.00) System.out.printf("Passed!");
        else System.out.println("Failed!");
        scanner.close();
    }
    public static void backIn30Minutes(){
        Scanner scanner = new Scanner(System.in);
        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int hours = 0;
        int mins = 0;

        if( m < 31){
            hours = h;
            mins = m + 30;
            System.out.println(hours+":"+(mins));
        } else {
                hours = (h < 23) ? h + 1 : 0;
                mins = m - 30;
                if(mins < 10) System.out.printf("%d:0%d", (hours), (mins));
                else System.out.println((hours) + ":"+ (mins));
        } 
        scanner.close();
    }
    public static void monthPrinter(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        switch(n){
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Error!");
                break;
        }
        scanner.close();
    }
    public static void foreignLanguages(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        switch (s) {
            case "England":
            case "USA":
                System.out.println("English");
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
                break;
        }
        scanner.close(); 
    }
    public static void thetrePromotions(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        if(s.equals("Weekday")){
            if(n >= 0 && n <= 18) System.out.println("12$");
            else if(n > 18 && n <= 64) System.out.println("18$");
            else if(n > 64 && n <= 122) System.out.println("12$");
            else System.out.println("Error!");
        } else if(s.equals("Weekend")){
            if(n >= 0 && n <= 18) System.out.println("15$");
            else if(n > 18 && n <= 64) System.out.println("20$");
            else if(n > 64 && n <= 122) System.out.println("15$");
            else System.out.println("Error!");
        } else if(s.equals("Holiday")){
            if(n >= 0 && n <= 18) System.out.println("5$");
            else if(n > 18 && n <= 64) System.out.println("12$");
            else if(n > 64 && n <= 122) System.out.println("10$");
            else System.out.println("Error!");
        }
        scanner.close(); 
    }
    public static void divisibleByThree(){
        for(int i = 3; i <= 100; i+=3){
            System.out.println(i);
        }
    }
    public static void sumOfOddNumbers(int n){
        int sum = 0;
        int num = 1;
        for(int i = 1; i <= n; i++){
            sum+=num;
            System.out.println(num);
            num+=2;
        }
        System.out.println("Sum: " + sum);
    }
    public static void multiplicationTable(int n){
        for(int i = 1; i <= 10; i++){
            System.out.printf("%d X %d = %d", n, i, n*i);
        }
    }
    public static void evenNumber(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = Integer.parseInt(scanner.nextLine());
            if(n % 2 != 0) System.out.println("Please write an even number.");
            else {
                System.out.println("The number is: " + Math.abs(n));
                break;
            }
        }
            scanner.close();
    }
    public static void refactorSumOfOddNumbers(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;//sum need to equal to 0, not 1
        for (int i = 0; i < n; i++) {//i less than n, not less or equal
            sum += 2 * i + 1; //add 1
            System.out.println(2 * i + 1);//add ln to print
        }
        System.out.printf("Sum: %d%n", sum);
        scanner.close();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        scanner.close();
    }
}