import java.util.Scanner;

public class DataTypesAndVariablesExercise {
    public void integerOperation(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int n4 = Integer.parseInt(scanner.nextLine());

        int output = ((n + n2)/n3)*n4;
        System.out.println(output);

        scanner.close();
    }
    public void sumDigits(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }

        System.out.println(sum);

        scanner.close();
    }
    public void elevator(){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());
        int output = (int) Math.ceil((double)n/p);
        System.out.println(output);

        scanner.close();
    }
    public void sumOfChars(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for(int i = 0; i < n; i++){
            char ch = scanner.next().charAt(0);
            sum += (int) ch;
        }
        System.out.println("The sum equals: "+sum);
        scanner.close();
    }
    public void printASCII(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        for(int i = n; i <= n2; i++){
            System.out.print((char) i + " ");
        }

        scanner.close();
    }
    public void triples(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++){
            char firstCh = (char) ('a' + i);
            for(int j = 0; j < n; j++) {
                char secondCh = (char) ('a' + j);
                for(int k = 0; k < n; k++){
                    char thirdCh = (char) ('a' + k);
                    System.out.printf("%c%c%c%n", firstCh, secondCh, thirdCh);
                }
            }
        }
        scanner.close();
    }
    public void waterOverflow(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int pW = 0;
        for(int i = 0; i < n; i++){
            int qW = Integer.parseInt(scanner.nextLine());
            if(qW <= capacity) {
                capacity -= qW;
                pW += qW;
            }
            else System.out.println("Insufficient capacity!");
        }
        System.out.println(pW);
        scanner.close(); 
    }
    public void beerKegs(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String biggest = "";
        double volume = 0;
        double lastVolume = 0;
        for(int i = 0; i < n; i++){
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            volume = Math.PI * Math.pow(radius, 2) * height;
            if(volume > lastVolume){
                lastVolume = volume;
                biggest = model;
            }
        }
        System.out.println(biggest);
        
        scanner.close();
    }
    public void spiceMustFlow(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int amount = 0;
        while(n >= 100){
            amount += n;
            n -= 10;
            days++;
            if(amount >= 26) amount -= 26;
        }
        if(amount >= 26) amount -= 26;
        System.out.println(days+"\n"+amount);
        scanner.close();
    }
    public void pokeMon(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int count = 0;
        double halfPower = (double)n*0.5;
        while(n >= m){
            n -= m;
            count++;
            if((double) n == halfPower && y != 0){
                n /= y;
            }
        }
        System.out.println(n);
        System.out.println(count);
        scanner.close(); 
    }
    public void snowballs(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long highest = 0;
        int hT = 0;
        int hS = 0;
        int hQ = 0;
        long snowballValue = 0;
        for(int i = 0; i < n; i++){
            int snowballSnow = Integer.parseInt(scanner.nextLine()); 
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            snowballValue = (long) Math.pow((long)(snowballSnow / snowballTime), snowballQuality);
            if(snowballValue > highest){
                highest = snowballValue;
                hT = snowballTime;
                hS = snowballSnow;
                hQ = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", hS, hT, highest, hQ);
        scanner.close();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        //double f = Double.parseDouble(scanner.nextLine());
        //BigDecimal bd = new BigDecimal(scanner.nextLine());
        //int n = Integer.parseInt(scanner.nextLine());
        //char ch = scanner.next().charAt(0);
        //DataTypesAndVariablesExercise d = new DataTypesAndVariablesExercise();
        
        scanner.close();
    }
}
