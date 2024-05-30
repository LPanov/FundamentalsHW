import java.util.Scanner;
import java.util.Arrays;

public class ArraysMoreExercise{
    public Scanner scanner = new Scanner(System.in);
    public void encryptSortPrint(){
        int n = Integer.parseInt(scanner.nextLine());
        int[] encrypted = new int[n];
        for(int i = 0; i < n; i++){
            String words = scanner.nextLine();
            int encryptedWord = 0;
            for(int j = 0; j < words.length(); j++){
                char ch = words.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u' || ch == 'A' ||
                ch == 'E' || ch == 'I' || ch == 'O' ||
                ch == 'U'){
                    encryptedWord += words.length() * (int) words.charAt(j);
                } else{
                    encryptedWord += (int) words.charAt(j) / words.length();
                }
            }
            encrypted[i] = encryptedWord;
        }
        Arrays.sort(encrypted);
        for(int i : encrypted){
            System.out.println(i);
        }
    }
    public void pascalTriangle(){
        int n = Integer.parseInt(scanner.nextLine());
        int[][] triangle = new int[n][n];

        for (int i = 0; i<triangle.length; i++){
            for (int j = 0; j<triangle[i].length; j++){
                try{
                    triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1]; 
                }catch(ArrayIndexOutOfBoundsException e){
                    triangle[i][0] = 1;
                }
            }    
       }

        for (int[] x : triangle) {
            for (int y : x){
                if(y != 0) System.out.print(y + " ");
            }
            System.out.println();
        }
    }
    public int recursiveFibonacci(int n){
        if(n <= 2) return 1;
        else{
            return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
        }
    }
    public void LIS(){
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] lis;
        int[] len = new int[nums.length];
        int[] prev = new int[nums.length];
        int maxLength = 0;
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            len[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i] && len[j] >= len[i]) {
                    len[i] = 1 + len[j];
                    prev[i] = j; 
                }
            }
            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }
        }
        lis = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            lis[i] = nums[lastIndex];
            lastIndex = prev[lastIndex];
        }
        for(int i = lis.length - 1; i >= 0; i--){
            System.out.print(lis[i] + " ");
        }

    }
    public int firstIndexOfOne(String[] nums){
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i].equals("1")) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void kamino(){
        Scanner sc = new Scanner(System.in);
        //int sizeField = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        String forAllZeros = input;
 
        int numberDNAtest = 0;
        int localNumber = 0;
        int bestSum = 0;
        int bestLength = 0;
        int bestNumber = 0;
        int bestIndex = 0;
        //String bestSequence = "";
        String bestInput = "";
        boolean zeros = false;
 
        String localnput = "";
        while (!input.equals("Clone them!")) {
 
            String noChars = input.replaceAll("!+", "");
            String[] noZeros = noChars.split("0");
            numberDNAtest++;
            int localLength = 0;
            String localSequence = "";
            int sum = 0;
 
            for (int j = 0; j < noZeros.length; j++) {
                if (noZeros[j].length() > localLength) {
                    localLength = noZeros[j].length();
                    localNumber = numberDNAtest;
                    localSequence = noZeros[j];
                    localnput = noChars;
                }
                sum += noZeros[j].length();
                if (sum > 0) {
                    zeros = true;
                }
                }
                int localIndex = noChars.indexOf(localSequence);
 
                if (localLength > bestLength) {
                    bestLength = localLength;
                    bestNumber = numberDNAtest;
                    bestInput = localnput;
                    bestSum = sum;
                    bestIndex = localIndex;
 
 
                } else if (localLength == bestLength) {
                    if (localIndex < bestIndex) {
                        bestLength = localLength;
                        bestNumber = numberDNAtest;
                        bestInput = localnput;
                        bestSum = sum;
                        bestIndex = localIndex;
                    } else if (localIndex == bestIndex) {
                        if (bestSum < sum) {
                            bestLength = localLength;
                            bestNumber = numberDNAtest;
                            bestInput = localnput;
                            bestSum = sum;
                            bestIndex = localIndex;
                        }
                    } else {
                        continue;
                    }
                }
 
                localLength = 0;
                localNumber = 0;
                localSequence = "";
                localnput = "";
                sum = 0;

                input = sc.nextLine();
            }
            if (zeros == false) {
                String output1 = forAllZeros.replaceAll("!+","");  //Проверка когато входа е 0!0!0!0!0
                String [] bestAllZero = output1.split("");
 
                System.out.println("Best DNA sample 1" + " with sum: " + 0 + ".");
                for (int i = 0; i < bestAllZero.length; i++) {
                    System.out.print(bestAllZero[i] + " ");
                }
 
            } else {
                String[] output = bestInput.split("");
 
                System.out.println("Best DNA sample " + bestNumber + " with sum: " + bestSum + ".");
                for (int i = 0; i < output.length; i++) {
                    System.out.print(output[i] + " ");
                }
            }
            sc.close();
 
        }
    
    public void ladyBugs(){
        int[] field = new int[Integer.parseInt(scanner.nextLine())];
        int[] indexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] >= 0 && indexes[i] < field.length) {
                field[indexes[i]] = 1;
            }
        }
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            String[] input = command.split(" ");
            int index = Integer.parseInt(input[0]);
            String direction = input[1];
            int flight = Integer.parseInt(input[2]);

            if (index < 0 || index >= field.length || field[index] == 0) {
                continue;
            }
            field[index] = 0;
            int currentFlight = flight;
            if (direction.equals("right")) {
                while (index + currentFlight < field.length && index + currentFlight >= 0) {
                    if (field[index + currentFlight] == 0) {
                        field[index + currentFlight] = 1;
                        break;
                    } else {
                        currentFlight += flight;
                    }
                }
            } else if (direction.equals("left")) {
                while (index - currentFlight >= 0 && index - currentFlight < field.length) {
                    if (field[index - currentFlight] == 0) {
                        field[index - currentFlight] = 1;
                        break;
                    } else {
                        currentFlight += flight;
                    }
                }
            }
        }
        for (int cell : field) {
            System.out.print(cell + " ");
        }
    }
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //int n = Integer.parseInt(scanner.nextLine());
        /*int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();*/
        //String words = scanner.nextLine();
        //String[] nums = words.split(" ");
        
        ArraysMoreExercise ame = new ArraysMoreExercise();
        ame.ladyBugs();

    }
}