import java.util.Scanner;
import java.math.BigDecimal;

public class DataTypesAndVariablesLab {
    public double convertMetersToKilometers(int n){
        double km = (double) n / 1000;
        return km;
    }
    public double poundsToDollars(double n){
        double pounds = n * 1.36;
        return pounds;
    }
    public BigDecimal exactSumOfRealNumbers(int n){
        Scanner scanner = new Scanner(System.in);
        BigDecimal sum  = new BigDecimal( "0" );
        for(int i = 0; i < n; i++){
            BigDecimal f = new BigDecimal(scanner.nextLine());
            sum = sum.add(f);
        }
        scanner.close();
        return sum;
    }
    public String townInfo(String n, BigDecimal p, int a){
        return "Town "+n+" has population of "+p+" and area "+a+" square km.";
    }
    public String concatNames(String n1, String n2, String del){
        return n1+del+n2;
    }
    public String charsToString(){
        Scanner scanner = new Scanner(System.in);
        String word = "";
        for(int i = 0; i < 3; i++){
            String ch = scanner.nextLine();
            word += ch;
        }
        scanner.close();
        return word;
    }
    public String reversedChars(){
        Scanner scanner = new Scanner(System.in);
        String word = "";
        for(int i = 0; i < 3; i++){
            String ch = scanner.nextLine();
            word += ch;
        }
        String revWord = "";
        for(int j = word.length(); j >= 0; j--){
            revWord += word.charAt(j);
            revWord += " ";
        }
        scanner.close();
        return revWord;
    }
    public String lowerOrUpper(char ch){
        if(Character.isUpperCase(ch)) return "upper-case";
        else return "lower-case";
    }
    public String centuriesToMinutes(int n){
        double days = n * 36524.22;
        double hours = days*24;
        double minutes = days*24*60;
        return n+" centuries = "+n*100+" years = "+Math.round(days)+" days = "+Math.round(hours)+" hours = "+Math.round(minutes)+" minutes";
    }
    public void specialNumber(int n){
        for(int i = 1; i <= n; i ++){
            String TF = "False";
            int sum = 0;
            for(int j = 0;j < String.valueOf(i).length(); j++){
                sum += Integer.parseInt(String.valueOf(String.valueOf(i).charAt(j)));
            }
            if(sum == 5 || sum == 7 || sum == 11) TF = "True";
            System.out.println(i + " -> " + TF);
        }
    }
    public void refactorVolumeOfPyramid(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Length: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        double hight = Double.parseDouble(scanner.nextLine());
        double V = (length * width * hight) / 3;
        System.out.printf("Pyramid Volume: %.2f", V);

        scanner.close();
    }
    public void refactorSpecialNumbers(){
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        boolean isSpecialNum = false;
        for (int i = 1; i <= count; i++) {
            int num = i;
            while (num > 0) {

                sum += num % 10;
                num = num / 10;
            }
            isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);
            System.out.printf("%d -> %s\n", i, String.valueOf(isSpecialNum).substring(0, 1).toUpperCase() + String.valueOf(isSpecialNum).substring( 1));
            sum = 0;
        }

        scanner.close();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        //double f = Double.parseDouble(scanner.nextLine());
        //BigDecimal bd = new BigDecimal(scanner.nextLine());
        //int n = Integer.parseInt(scanner.nextLine());
        //char ch = scanner.next().charAt(0);
        //DataTypesAndVariablesLab DTAVL = new DataTypesAndVariablesLab();
        
        scanner.close();
    }
}
