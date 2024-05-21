import java.util.Scanner;

public class BasicSyntaxExercise {
    public static void ages(int n) {
        if(n >= 0 && n <= 2) System.out.println("baby");
        else if(n > 2 && n <= 13) System.out.println("child");
        else if(n > 13 && n <= 19) System.out.println("teenager");
        else if(n > 19 && n <= 65) System.out.println("adult");
        else if(n > 65) System.out.println("elder");
    }
    public static void division(int n){
        if(n % 10 == 0) System.out.println("The number is divisible by 10");
        else if(n % 7 == 0) System.out.println("The number is divisible by 7");
        else if(n % 6 == 0) System.out.println("The number is divisible by 6");
        else if(n % 3 == 0) System.out.println("The number is divisible by 3");
        else if(n % 2 == 0) System.out.println("The number is divisible by 2");
        else System.out.println("Not divisible");
    }
    public static void vacation(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        
        if(type.equals("Students")){
            if(day.equals("Friday")) price = 8.45 * n;
            else if(day.equals("Saturday")) price = 9.8 * n;
            else if(day.equals("Sunday")) price = 10.46 * n;
            price = (n < 30) ? price : price*0.85;
        } else if(type.equals("Business")){
            if(day.equals("Friday")) price = (n < 100) ? 10.9 * n : 10.9 * (n - 10);
            else if(day.equals("Saturday")) price = (n < 100) ? 15.6 * n : 15.6 * (n-10);
            else if(day.equals("Sunday")) price = (n < 100) ? 16 * n : 16 * (n-10);
        } else if(type.equals("Regular")){
            if(day.equals("Friday")) price = 15 * n;
            else if(day.equals("Saturday")) price = 20 * n;
            else if(day.equals("Sunday")) price = 22.5 * n;
            price = (n >= 10 && n <= 20) ? price*0.95 : price;
        } 
        System.out.printf("Total price: %.2f", price);
        scanner.close();
    }
    public static void printAndSum(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for(int i = n; i <= m; i++){
            sum += i;
            System.out.print(i+" ");
        }
        System.out.println("\nSum: " + sum);
        scanner.close();
    }
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String revs = "";
        for(int i = s.length() - 1; i >= 0; i--){
            revs += s.charAt(i);
        }
        int trials = 0;
        while(true){
            trials++;
            String input = scanner.nextLine();
            if(input.equals(revs)){
                System.out.printf("User %s logged in.\n", s);
                break;
            } else if(!input.equals(revs) && trials <= 3) System.out.printf("Incorrect password. Try again.\n");
            else if(!input.equals(revs) && trials > 3) {
                System.out.printf("User %s blocked!", s);
                break;
            }
        }
        scanner.close();
    }
    public static void strongNumber(String s){
        int factorial = 1;
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 1; j <= Integer.parseInt(String.valueOf(s.charAt(i))); j++){
                factorial = factorial*j;
            }
            sum += factorial;
            factorial = 1;
        }
        if(Integer.valueOf(s) == sum) System.out.println("yes");
        else System.out.println("no");
    }
    public static void vendingMachine(){
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        boolean isEnd = false;

        while(true){
            if(isEnd) break;
            String s = scanner.nextLine();
            if(s.equals("Start")){
                String product = "";
                while(true){
                    product = scanner.nextLine();
                    if (product.equals("End")){
                        isEnd = true;
                        break;
                    } else if(product.equals("Nuts") && sum >= 2){
                        sum -= 2;
                        System.out.println("Purchased " + product);
                    } else if(product.equals("Nuts") && sum < 2){
                        System.out.println("Sorry, not enough money");
                    } else if(product.equals("Water") && sum >= 0.7){
                        sum -= 0.7;
                        System.out.println("Purchased " + product);
                    } else if(product.equals("Water") && sum < 0.7){
                        System.out.println("Sorry, not enough money");
                    }  else if(product.equals("Crisps") && sum >= 1.5){
                        sum -= 1.5;
                        System.out.println("Purchased " + product);
                    } else if(product.equals("Crisps") && sum < 1.5){
                        System.out.println("Sorry, not enough money");
                    } else if(product.equals("Soda") && sum >= 0.8){
                        sum -= 0.8;
                        System.out.println("Purchased " + product);
                    } else if(product.equals("Soda") && sum < 0.8){
                        System.out.println("Sorry, not enough money");
                    } else if(product.equals("Coke") && sum >= 1){
                        sum -= 1;
                        System.out.println("Purchased " + product);
                    } else if(product.equals("Coke") && sum < 1){
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Invalid product");
                    }
                }  
            } else if(Double.parseDouble(s) == 0.1 || Double.parseDouble(s) == 0.2 ||
                    Double.parseDouble(s) == 0.5 || Double.parseDouble(s) == 1 || 
                    Double.parseDouble(s) == 2){
                sum += Double.parseDouble(s);
            } else {
                System.out.printf("Cannot accept %.2f\n", Double.parseDouble(s));
            }   
        }
        System.out.printf("Change: %.2f", sum);
        scanner.close();
    }
    public static void triangleOfNumbers(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void orders(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double total = 0;
        double orderPrice = 0;

        for(int i = 0; i < n; i++){
            double price = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capCount = Integer.parseInt(scanner.nextLine());
            orderPrice = (days*capCount)*price;
            System.out.printf("The price for the coffee is: $%.2f\n", orderPrice);
            total += orderPrice;
        }
        System.out.printf("Total: $%.2f\n", total);
        
        scanner.close();
    }
    public static void padawanExpenses() {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        double prLightSabers = Double.parseDouble(scanner.nextLine());
        double prRobes = Double.parseDouble(scanner.nextLine());
        double prBelts = Double.parseDouble(scanner.nextLine());
        int countBelts = (n <= 6) ? n : n - (int) Math.round(n/6);
        double price = prLightSabers*Math.ceil(n*1.1) + prRobes*n + prBelts*countBelts;

        if(money >= price){
            System.out.printf("The money is enough - it would cost %.2flv.", price);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", price - money);
        }
        scanner.close();
    }
    public static void rageExpenses(){
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        double expenses = 0;
        int cThs = 0;
        int cTm = 0;
        int cTk = 0;
        int cTd = 0;
        for(int i = 1; i <= lostGames; i++){
            if(i%12 == 0){
                cThs ++;
                cTm++;
                cTk++;
                cTd ++;
            } else if(i%6 == 0) {
                cThs ++;
                cTm++;
                cTk++;
            } 
            else if(i%3 == 0) cTm++;
            else if(i%2 == 0) cThs++;
        }
        expenses = headsetPrice*cThs + mousePrice*cTm + keyboardPrice*cTk + displayPrice*cTd;
        System.out.printf("Rage expenses: %.2f lv.", expenses);

        scanner.close();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        //double f = Double.parseDouble(scanner.nextLine());
        //int n = Integer.parseInt(scanner.nextLine());
        //BasicSyntaxExercise.printAndSum();
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        double expenses = 0;
        int cThs = 0;
        int cTm = 0;
        int cTk = 0;
        int cTd = 0;
        for(int i = 1; i <= lostGames; i++){
            if(i%12 == 0){
                cThs ++;
                cTm++;
                cTk++;
                cTd ++;
            } else if(i%6 == 0) {
                cThs ++;
                cTm++;
                cTk++;
            } 
            else if(i%3 == 0) cTm++;
            else if(i%2 == 0) cThs++;
        }
        expenses = headsetPrice*cThs + mousePrice*cTm + keyboardPrice*cTk + displayPrice*cTd;
        System.out.printf("Rage expenses: %.2f lv.", expenses);


        scanner.close();
    }
}
