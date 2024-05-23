import java.util.Scanner;
import java.util.Arrays;

public class ArraysExercise{
    public Scanner scanner = new Scanner(System.in);
    public void train(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] wagons = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            int wagon = Integer.parseInt(scanner.nextLine());
            wagons[i] = wagon;
            sum += wagon;
        }
        for(int j = 0; j < wagons.length; j++){
            System.out.print(wagons[j] + " ");
        }
        System.out.println();
        System.out.println(sum);
        scanner.close();
    }
    public void commonElements(){
        Scanner scanner = new Scanner(System.in);
        Object[] symbols = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(e -> String.valueOf(e))
                    .toArray();
        Object[] symbols2 = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(e -> String.valueOf(e))
                    .toArray();
        String common = "";
        for(int i = 0; i < symbols2.length; i++){
            for(int j = 0; j < symbols.length; j++){
                if(symbols2[i].equals(symbols[j])) {
                    common += symbols2[i];
                    common += " ";
                }
            }
        }
        System.out.println(common);

        scanner.close();
    }
    public void zigZagArrays(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] line1 = new int[n];
        int[] line2 = new int[n];
        for(int i = 0; i < n; i++){
            int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
            if(i % 2 != 0){
                line1[i] = nums[0];
                line2[i] = nums[1];
            } else{
                line1[i] = nums[1];
                line2[i] = nums[0];
            }
        }
        for(int j = 0; j < n; j++){
            System.out.print(line2[j] + " ");
        }
        System.out.println();
        for(int j = 0; j < n; j++){
            System.out.print(line1[j] + " ");
        }
        scanner.close();
    }
    public void arraysRotation(int n, String words){
        String[] nums = words.split(" ");
        for (int j = 0; j < n; j++)
        {
            String last = nums[0];
            for (int i = 0; i < nums.length - 1; i++)
            {
                nums[i] = nums[i + 1];
            }
            nums[nums.length - 1] = last;
        }
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public void topIntegers(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        String topNums = "";
        for(int i = 0; i < nums.length; i++){
            boolean isBigger = false;
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j]) isBigger = true;
                else if(nums[i] < nums[j]){
                    isBigger = false;
                    break;
                }
            }
            if(isBigger){
                topNums += String.valueOf(nums[i]);
                topNums += " ";
            }
        }
        topNums += String.valueOf(nums[nums.length-1]);
        System.out.println(topNums);
        scanner.close();
    }
    public void equalSums(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        String index = "";

        for(int i = 0; i < nums.length; i++){
            int sumRight = 0;
            int sumLeft = 0;
            for(int j = i+1; j < nums.length; j++){
                sumRight += nums[j];
            }
            for(int j = i - 1; j >= 0; j--){
                sumLeft += nums[j];
            }
            //System.out.println(sumLeft + "\n" + sumRight);
            if(sumLeft == sumRight) index = String.valueOf(i);
        }
        if(index.isEmpty()) System.out.println("no");
        else System.out.println(index);

        scanner.close();
    }
    public void condenseArrayToNum(){
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sum = 0;
        while(nums.length > 1){
            int[] condensed = new int[nums.length - 1];
            for(int i = 0; i < condensed.length; i++){
                condensed[i] = nums[i] + nums[i+1];
            }
            nums = condensed;
            sum = condensed[0];
        }
        if(nums.length == 1) System.out.println(nums[0]);
        else System.out.println(sum);
    }
    public void magicSum(){
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                sum = nums[i] + nums[j];
                if(sum == n) System.out.println(nums[i] + " " + nums[j]);
            } 
        }
    }
    public void arrayModifier(){
        long[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToLong(e -> Long.parseLong(e))
                .toArray();
        while(true){
            String s = scanner.nextLine();
            long temp = 0;
            if (s.equals("end")) break;
            else if (s.startsWith("swap")) {
                s = s.replaceFirst(" ", "");
                if(Integer.parseInt(s.substring(s.indexOf("p") + 1, s.indexOf(" "))) >= 0 && Integer.parseInt(s.substring(s.indexOf("p") + 1, s.indexOf(" "))) < nums.length && Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length())) >= 0 && Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length())) < nums.length) {
                    temp = nums[Integer.parseInt(s.substring(s.indexOf("p") + 1, s.indexOf(" ")))];
                    nums[Integer.parseInt(s.substring(s.indexOf("p") + 1, s.indexOf(" ")))] = nums[Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length()))];
                    nums[Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length()))] = temp;
                }
            }
            else if (s.startsWith("multiply")) {
                s = s.replaceFirst(" ", "");
                if(Integer.parseInt(s.substring(s.indexOf("y") + 1, s.indexOf(" "))) >= 0 && Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length())) >= 0) {
                    temp = nums[Integer.parseInt(s.substring(s.indexOf("y") + 1, s.indexOf(" ")))] * nums[Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length()))];
                    nums[Integer.parseInt(s.substring(s.indexOf("y") + 1, s.indexOf(" ")))] = temp;
                }
            }
            else if (s.equals("decrease")){
                for(int i = 0; i < nums.length; i++){
                    nums[i] = nums[i] - 1;
                }
            }
        }
        System.out.println(Arrays.toString(nums).replace("[", "").replace("]", ""));

    }
    public void theLift(){
        int n = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean hasEmpty = false;
        for(int i = 0; i < wagons.length; i++){
            int people = 0;
            if (wagons[i] <= 4){
                if (n >= 4) {
                    people = 4 - wagons[i];
                    wagons[i] += people;
                    n -= people;
                } else if (n < 4 && n > 0){
                    if(n + wagons[i] <= 4) {
                        wagons[i] += n;
                        n -= n;
                    } else if ( n > wagons[i]){
                        people = n - wagons[i];
                        wagons[i] += people;
                        n -= people;
                    } else if( n < wagons[i]){
                        wagons[i] += n;
                        n -= n;
                    }
                }
            }
            if(wagons[i] < 4) hasEmpty = true;
        }
        if(hasEmpty) System.out.println("The lift has empty spots!");
        else if (n > 0) { System.out.println("There isn't enough space! "+n+" people in a queue!");}
        for(int i = 0; i < wagons.length; i++){
            System.out.print(wagons[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        scanner.close();
    }

}