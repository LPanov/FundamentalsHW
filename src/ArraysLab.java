import java.util.Scanner;
import java.util.Arrays;

public class ArraysLab {
    public static void dayOfWeek(){
        Scanner scanner = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int d = Integer.parseInt(scanner.nextLine());
        boolean isValid = false;
    
        for(int i = 0; i < days.length; i++){
            if(i == d-1){
                System.out.println(days[i]);
                isValid = true;
                break;
            }
        }
        if(!isValid) System.out.println("Invalid day!");
        scanner.close(); 
    }
    public static void reverseNumbers(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            int num = Integer.parseInt(scanner.nextLine());
            nums[i] = num;
       } 
       for(int j = nums.length-1; j >= 0; j--){
        System.out.print(nums[j]+" ");
       }
       scanner.close(); 
    }
    public static void sumNumnbers(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0) sum += nums[i];
        } 
        System.out.println(sum);
        scanner.close();
    }
    public static void reverseString(){
        Scanner scanner = new Scanner(System.in);
        Object[] symbols = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(e -> String.valueOf(e))
                    .toArray();
        
        for(int i = symbols.length - 1; i>=0; i--){
            System.out.print(symbols[i]+" ");
       }
       scanner.close();
    }
    public static void substractEvenOdd(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
        int sumEven = 0;
        int sumOdd = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0) sumEven += nums[i];
            else sumOdd += nums[i];
        } 
        System.out.println(sumEven - sumOdd);
        scanner.close();
    }
    public static void equalArrays(){
        Scanner scanner = new Scanner(System.in);
        int[] nums1 = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
        int[] nums2 = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
        int sum = 0;
        int index = 0;
        boolean areIndentical = true;
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] == nums2[i]) sum+=nums1[i];
            else{
                index = i;
                areIndentical = false;
                break;
            }
        } 
        if(!areIndentical) System.out.println("Arrays are not identical. Found difference at "+index+" index.");
        else System.out.println("Arrays are identical. Sum: " + sum);
    scanner.close();
    }
   public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    //String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    //int n = Integer.parseInt(scanner.nextLine());
    /*Object[] symbols = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> String.valueOf(e))
                .toArray();*/
    int[] nums1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
    int[] nums2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
    int sum = 0;
    int index = 0;
    boolean areIndentical = true;
    for(int i = 0; i < nums1.length; i++){
        if(nums1[i] == nums2[i]) sum+=nums1[i];
        else{
            index = i;
            areIndentical = false;
            break;
        }
    } 
    if(!areIndentical) System.out.println("Arrays are not identical. Found difference at "+index+" index.");
    else System.out.println("Arrays are identical. Sum: " + sum);
   scanner.close();
}
}
