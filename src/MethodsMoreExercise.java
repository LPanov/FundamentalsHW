import java.util.Arrays;
import java.util.Scanner;

public class MethodsMoreExercise {

    public void dataType(String s, String n) {
        if (s.equals("int")) System.out.println(Integer.parseInt(n) * 2);
        else if (s.equals("real")) System.out.printf("%.2f", Double.parseDouble(n) * 1.5);
        else if (s.equals("string")){
            String surrounded = "$" + n + "$";
            System.out.println(surrounded);
        }
    }

    private double distance (int n1, int n2) {
        return Math.sqrt(Math.pow(n1, 2) + Math.pow(n2, 2));
    }
    public void centerPoint () {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int n4 = Integer.parseInt(scanner.nextLine());

        if (distance(n1, n2) < distance(n3, n4)) System.out.printf("(%d, %d)", n1, n2);
        else System.out.printf("(%d, %d)", n3, n4);
        scanner.close();
    }

    private double length (int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    public void longerLine () {
        Scanner scanner = new Scanner(System.in);
        double[] lengths = new double[2];

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        lengths[0] = length(x1, y1, x2, y2);

        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());
        lengths[1] = length(x3, y3, x4, y4);
        
        if (lengths[0] >= lengths[1]) {
            if (distance(x1, y1) < distance(x2, y2)) System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
            else System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        } else {
            if (distance(x3, y3) < distance(x4, y4)) System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
            else System.out.printf("(%d, %d)(%d, %d)", x4, y4, x3, y3);
        }

        scanner.close();
    }

    private int tribonacci (int n) {
        int first = 1, second = 1, third = first+second;
        if (n < 1) return 0;
        else if (n == 1 || n == 2) return 1;
        else if (n == 3) return 2;
        else {
            int curr = 0;
            for (int i = 3; i < n; i++) {
                curr = first + second + third;
                first = second;
                second = third;
                third = curr;
            }
            return curr;
        }
    }
    public void tribonacciSeq () {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if(n > 0) {
            for(int i = 1; i <= n; i++) {
                System.out.print(tribonacci(i) + " ");
            }
        } else if (n == 0) System.out.println(0);
        scanner.close();
    }

    public void multiplacationSign() {
        int countNeg = 0;
        boolean isZero = false;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if(n < 0) countNeg++;
            if(n == 0) isZero = true;
        }

        if (isZero) System.out.println("zero");
        else if (countNeg %2 != 0) System.out.println("negative");
        else System.out.println("positive");
        
        scanner.close();
    }
    public void arrayManipulator () {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("end")) break;
            if (s.startsWith("exchange")) {
                int pos = Integer.parseInt(s.substring(9, s.length())) + 1;
                if (pos > 0 && pos < nums.length + 1) {
                    int[] LHalf = new int[pos];
                    int[] RHalf = new int[nums.length - pos];
                    for (int i = 0; i < pos; i++) {
                        LHalf[i] = nums[i];
                    }
                    for (int i = 0; i < nums.length - pos; i++) {
                        RHalf[i] = nums[i + pos];
                    }
                    for (int i = 0; i < nums.length - pos; i++) {
                        nums[i] = RHalf[i];
                    }
                    for (int i = 0; i < pos; i++) {
                        nums[i + nums.length - pos] = LHalf[i];
                    }
                } else {
                    System.out.println("Invalid index");
                }
            } 
            else if (s.startsWith("max")) {
                int maxEven = 0;
                int maxOdd = 0;
                int indexEven = 0;
                int indexOdd = 0;
                boolean even = false;
                boolean odd = false;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] % 2 == 0 && nums[i] > maxEven){
                        maxEven = nums[i];
                        indexEven = i;
                        even = true;
                    }
                    else if (nums[i] % 2 != 0 && nums[i] > maxOdd) {
                        maxOdd = nums[i];
                        indexOdd = i;
                        odd = true;
                    }
                }
                if(s.endsWith("even")) System.out.println(indexEven);
                else if (s.endsWith("odd")) System.out.println(indexOdd);
                else if (!even || !odd) System.out.println("No matches");
            }
            else if (s.startsWith("min")) {
                int max = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (max < nums[i]) max = nums[i];
                }
                int minEven = (max % 2 == 0) ? max : max+1;
                int minOdd = (max % 2 != 0) ? max : max+1;
                int indexEven = 0;
                int indexOdd = 0;
                boolean even = false;
                boolean odd = false;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] % 2 == 0 && nums[i] < minEven){
                        minEven = nums[i];
                        indexEven = i;
                        even = true;
                    }
                    else if (nums[i] % 2 != 0 && nums[i] < minOdd) {
                        minOdd = nums[i];
                        indexOdd = i;
                        odd = true;
                    }
                }
                if (!even || !odd) System.out.println("No matches");
                else if(s.endsWith("even")) System.out.println(indexEven);
                else if (s.endsWith("odd")) System.out.println(indexOdd);
                
            }
            else if (s.startsWith("first")) {
                int size = Integer.parseInt(s.substring(6, s.lastIndexOf(" ")));
                if(size > 0 && size < nums.length) {
                    int[] temp = new int[size];
                    if(s.endsWith("even")) {
                        int j = 0;
                        for(int i = 0; i < nums.length; i++) {
                            try{
                                if(nums[i] % 2 == 0) {
                                    temp[j] = nums[i];
                                    j++;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                continue;
                            }
                        }
                        System.out.print("["); 
                        for(int i = 0; i < temp.length; i++){
                            if(temp[i] > 0) System.out.print(temp[i]);
                            if(i != temp.length - 1 && temp[i+1] != 0) System.out.print(", ");
                        }
                        System.out.print("]\n");    
                    }
                    else if(s.endsWith("odd")) {
                        int j = 0;
                        for(int i = 0; i < nums.length; i++) {
                            try{
                                if(nums[i] % 2 != 0) {
                                    temp[j] = nums[i];
                                    j++;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                continue;
                            }
                        }
                        System.out.print("["); 
                        for(int i = 0; i < temp.length; i++){
                            if(temp[i] > 0) System.out.print(temp[i]);
                            if(i != temp.length - 1 && temp[i+1] != 0) System.out.print(", ");
                        }
                        System.out.print("]\n");  
                    }
                } else {
                    System.out.println("Invalid count");
                } 
            }
            else if (s.startsWith("last")) {
                int size = Integer.parseInt(s.substring(5, s.lastIndexOf(" ")));
                int countEven = 0;
                int countOdd = 0;
                for(int i = 0; i < nums.length; i++){
                    if(nums[i] % 2 == 0) countEven++;
                    else countOdd++;
                }
                if(size > 0 && size <= nums.length) {
                    int[] tempEven = new int[countEven];
                    int[] tempOdd = new int[countOdd];
                    if(s.endsWith("even")) {
                        int j = 0;
                        for(int i = 0; i < nums.length; i++) {
                            try{
                                if(nums[i] % 2 == 0) {
                                    tempEven[j] = nums[i];
                                    j++;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                continue;
                            }
                        }
                        System.out.println(Arrays.toString(tempEven));  
                    }
                    else if(s.endsWith("odd")) {
                        int j = 0;
                        for(int i = 0; i < nums.length; i++) {
                            try{
                                if(nums[i] % 2 != 0) {
                                    tempOdd[j] = nums[i];
                                    j++;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                continue;
                            }
                        }
                        System.out.println(Arrays.toString(tempOdd));  
                    }
                } else {
                    System.out.println("Invalid count");
                } 
            }

        }
        System.out.println(Arrays.toString(nums));
        scanner.close(); 
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
        
        MethodsMoreExercise mme = new MethodsMoreExercise();
        mme.arrayManipulator();
        
        scanner.close();
    }
}
