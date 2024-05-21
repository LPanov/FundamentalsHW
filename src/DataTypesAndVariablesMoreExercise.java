import java.util.Scanner;

public class DataTypesAndVariablesMoreExercise{
    public void dataTypeFinder(){
        Scanner scanner = new Scanner(System.in);
     
        while(true){
            String s = scanner.nextLine();
            if(s.equals("END")) break;
            try{
                Integer.parseInt(s);
                System.out.println(s + " is integer type"); 
            } catch (NumberFormatException e)  { 
                try{
                    Double.parseDouble(s);
                    System.out.println(s + " is floating point type"); 
                } catch (NumberFormatException e2){
                       if(s.length() == 1) System.out.println(s + " is character type");
                       else if(s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")) System.out.println(s + " is boolean type");
                       else System.out.println(s + " is string type");
                }
            }
        }
        scanner.close();
    }
    public void fromLeftToRight(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++){
            String nums = scanner.nextLine();
            long sum = 0;
            long num1 = Long.parseLong(nums.substring(0, nums.indexOf(" ")));
            long num2 = Long.parseLong(nums.substring(nums.indexOf(" ")+1, nums.length()));
            if(num1 >= num2){
                for(int j = 0; j < String.valueOf(Math.abs(num1)).length(); j++){
                    sum += Character.getNumericValue(String.valueOf(Math.abs(num1)).charAt(j));
                }
            } else {
                for(int k = 0; k < String.valueOf(Math.abs(num2)).length(); k++){
                    sum += Character.getNumericValue(String.valueOf(Math.abs(num2)).charAt(k));
                }
            }
            System.out.println(sum);
        }
        
        scanner.close();
    }
    public void floatingEquality(){
        Scanner scanner = new Scanner(System.in);
        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());
        double epsilon = 0.000001;
        if(Math.abs(n1 - n2) < epsilon) System.out.println("True");
        else System.out.println("False");
        scanner.close();
    }
    public void refactoringPrimeChecker(){
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= number; i++) {
            boolean isPrime = true;
            for (int denominator = 2; denominator < i; denominator++) {
                if (i % denominator == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %s%n", i, String.valueOf(isPrime).toLowerCase());
        }
        scanner.close();
    }
    public void decryptingMessage(){
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String word = "";
        for(int i = 0; i < n; i++){
            char ch = scanner.next().charAt(0);  
            word += (char)((int)ch+key);
        }
        System.out.println(word);
        scanner.close();
    }
    public void balancedBrackets(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int countOpen = 0;
        int countClose = 0;
        boolean isBalanced = true;
        boolean isOpen = false;
        boolean isConsecutiveOpen = false;
        for(int i = 0; i < n; i++){
            String s = scanner.nextLine();
            if(s.equals("(")) {
                if(!isOpen) {
                    isOpen = true;
                    countOpen++;
                } else{
                    isConsecutiveOpen = true;
                }
            }
            else if(s.equals(")")) {
                if(isOpen || countOpen == 0){
                    countClose++;
                    isOpen = false;
                }
            }
        }
        isBalanced = countClose == countOpen && !isConsecutiveOpen;
        if(isBalanced && !isOpen) System.out.println("BALANCED");
        else System.out.println("UNBALANCED");
        
        scanner.close();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        //double f = Double.parseDouble(scanner.nextLine());
        //BigDecimal bd = new BigDecimal(scanner.nextLine());
        //int n = Integer.parseInt(scanner.nextLine());
        //char ch = scanner.next().charAt(0);
        
        scanner.close();
    }
}