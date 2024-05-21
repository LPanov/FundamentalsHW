import java.util.Scanner;

public class BasicSyntaxMoreExercise {
    public static void sortNumbers(){
        Scanner scanner = new Scanner(System.in);
        
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int biggest = 0;
        int medium = 0;
        int smallest = 0;
        if(n1 > n2 && n1 > n3) {
            biggest = n1;
            if(n2 > n3) {
                medium = n2; 
                smallest = n3;
            }
            else {
                medium = n3; 
                smallest = n2; }
        }
        else if(n2 > n1 && n2 > n3) {
            biggest = n2;
            if(n1 > n3) {
                medium = n1; 
                smallest = n3;
            }
            else {
                medium = n3; 
                smallest = n1; }
        }
        else if(n3 > n1 && n3 > n2) {
            biggest = n3;
            if(n1 > n2) {
                medium = n1; 
                smallest = n2;
            }
            else {
                medium = n2; 
                smallest = n1; }
        }
        
        System.out.println(biggest+"\n"+medium+"\n"+smallest);
        scanner.close();
    }
    public String englishNameOfLD(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int lastNum = Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
        String last = "";
        if(lastNum == 0) last = "zero";
        else if(lastNum == 1) last = "one";
        else if(lastNum == 2) last = "two";
        else if(lastNum == 3) last = "three";
        else if(lastNum == 4) last = "four";
        else if(lastNum == 5) last = "five";
        else if(lastNum == 6) last = "six";
        else if(lastNum == 7) last = "seven";
        else if(lastNum == 8) last = "eight";
        else if(lastNum == 9) last = "nine";

        scanner.close();
        return last;
    }
    public double priceGame(String s){
        double price;
        if(s.equals("OutFall 4")) price = 39.99;
        else if(s.equals("CS: OG")) price = 15.99;
        else if(s.equals("Zplinter Zell")) price = 19.99;
        else if(s.equals("Honored 2")) price = 59.99;
        else if(s.equals("RoverWatch")) price = 29.99;
        else if(s.equals("RoverWatch Origins Edition")) price = 39.99;
        else price = 0;
        return price;
    }
    public void gamingStore(){
        Scanner scanner = new Scanner(System.in);
        
        double money = Double.parseDouble(scanner.nextLine());
        double spent = 0;
        double price = 0;
        while(true){
            String s = scanner.nextLine();
            price = priceGame(s);
            if(money >= price && money > 0){
                if(s.equals("Game Time")) {
                    System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, money);
                    break;
                } 
                else if(s.equals("OutFall 4")) {
                    money -= price;
                    spent += price;
                    System.out.println("Bought " + s);
                }
                else if(s.equals("CS: OG")) {
                    money -= price;
                    spent += price;
                    System.out.println("Bought " + s);
                }
                else if(s.equals("Zplinter Zell")) {
                    money -= price;
                    spent += price;
                    System.out.println("Bought " + s);
                }
                else if(s.equals("Honored 2")) {
                    money -= price;
                    spent += price;
                    System.out.println("Bought " + s);
                }
                else if(s.equals("RoverWatch")) {
                    money -= price;
                    spent += price;
                    System.out.println("Bought " + s);
                }
                else if(s.equals("RoverWatch Origins Edition")) {
                    money -= price;
                    spent += price;
                    System.out.println("Bought " + s);
                }
                else System.out.println("Not Found");
            } else if(money == 0){
                System.out.println("Out of money!");
                break;
            }
            else System.out.println("Too Expensive");
        }
        
        scanner.close();
    }
    public void reverseSring(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String reverseS = "";
        for(int i = s.length() - 1; i >= 0; i--){
            reverseS += s.charAt(i);
        }
        System.out.println(reverseS);
        scanner.close(); 
    }
    public void messages(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String word = "";
        int mainDigit = 0;
        int numDigs = 0;
        int offset = 0;
        int index = 0;
        for(int i = 0; i < n; i++){
            String ch = scanner.nextLine();
            mainDigit = Integer.parseInt(String.valueOf(ch.charAt(0)));
            if(mainDigit == 0) word += " ";
            else{
                numDigs = ch.length();
                if(mainDigit == 9 || mainDigit == 8) offset = (mainDigit - 2)*3 + 1;
                else offset = (mainDigit - 2)*3; 
                index = offset + numDigs -1;
                word += (char)(97 + index);
            }
        }
        System.out.println(word);

        scanner.close();
    }
    public static void main(String[] args) {
        BasicSyntaxMoreExercise BSME = new BasicSyntaxMoreExercise();
        BSME.messages();
        
    }
}
