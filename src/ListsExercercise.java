import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
//import java.util.stream.*;

public class ListsExercercise {
    public void train(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int max = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            numbers.add(nums[i]);
        }
        while(true){
            String s = scanner.nextLine();
            int num = 0;
            if(s.equals("end")){
                for(int i = 0; i < numbers.size(); i++){
                    System.out.print(numbers.get(i)+" ");
                }
                break;
            } else if(s.startsWith("Add ")){
                /*if(s.length() == 6) num = Integer.parseInt(String.valueOf(s.charAt(s.length() - 2)))*10 + Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
                else if(s.length() == 5) num = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));*/
                num = Integer.parseInt(s.substring(4, s.length()));
                numbers.add(num);
            } else{
                for(int i = 0; i < numbers.size(); i++){
                    if(numbers.get(i) + Integer.parseInt(s) <= max){
                        numbers.set(i, numbers.get(i) + Integer.parseInt(s));
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
    public void changeList(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            numbers.add(nums[i]);
        }
        while(true){
            String s = scanner.nextLine();
            int num = 0;
            int position = 0;
            if(s.equals("end")){
                for(int i = 0; i < numbers.size(); i++){
                    System.out.print(numbers.get(i)+" ");
                }
                break;
            } else if(s.startsWith("Delete ")){
                num = Integer.parseInt(s.substring(7, s.length()));
                for(int i = 0; i< numbers.size(); i++){
                    if(numbers.get(i) == num) numbers.remove(i);
                }
            } else if(s.startsWith("Insert ")){
                s = s.replaceFirst(" ", "");
                num = Integer.parseInt(s.substring(6, s.indexOf(" ")));
                position = Integer.parseInt(s.substring(s.indexOf(" ")+1, s.length()));
                numbers.add(position, num);
            }  
            }
        scanner.close();

    }
    public void houseParty(){
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        ArrayList<String> guests = new ArrayList<String>();

        while(N>0){
            String s = scanner.nextLine();
            s = s.replaceFirst(" ", "");
            if(s.contains("not")){
                if(guests.contains(s.substring(0, s.indexOf("is")))){
                    guests.remove(s.substring(0, s.indexOf("is")));
                } else{
                    System.out.println(s.substring(0, s.indexOf("is")) + " is not in the list!");
                }
            } else {
                if(!guests.contains(s.substring(0, s.indexOf("is")))){
                    guests.add(s.substring(0, s.indexOf("is")));
                } else{
                    System.out.println(s.substring(0, s.indexOf("is")) + " is already in the list!");
                }
            }
            N--;
        }
        for(int i = 0; i < guests.size(); i++){
            System.out.println(guests.get(i));
        }

        scanner.close();
    }
    public void listOperators(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            numbers.add(nums[i]);
        }
        while(true){
            String s = scanner.nextLine();
            try{
                if(s.equals("End")){
                    for(int i = 0; i < numbers.size(); i++){
                        System.out.print(numbers.get(i) + " ");
                    }
                    break;
                } else if(s.startsWith("Add")){
                    numbers.add(Integer.parseInt(s.substring(4, s.length())));
                } else if(s.startsWith("Remove")){
                    numbers.remove(Integer.parseInt(s.substring(7, s.length())));
                } else if(s.startsWith("Shift left")){
                    //s = s.replaceFirst(" ", "");
                    for(int i = 0; i < Integer.parseInt(s.substring(11, s.length())); i++){
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                    }
                } else if(s.startsWith("Shift right")){
                    //s = s.replaceFirst(" ", "");
                    for(int i = 0; i < Integer.parseInt(s.substring(12, s.length())); i++){
                        numbers.add(0 ,numbers.get(numbers.size()-1));
                        numbers.remove(numbers.size()-1);
                    }

                } else if(s.startsWith("Insert")){
                    s = s.replaceFirst(" ", "");
                    numbers.add(Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length())),Integer.parseInt(s.substring(6, s.indexOf(" "))));
                }
            } catch(IndexOutOfBoundsException e){
                System.out.println("Invalid index");
                continue;
            }
        }

        scanner.close();
    }
    public int cSN = 0;
    public ArrayList<Integer> bombNumbers(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            numbers.add(nums[i]);
        }
        int[] specNums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int index = 0;
        
        for(int k = 0; k < numbers.size(); k++){
            if(numbers.get(k) == specNums[0] && numbers.get(k+1) != numbers.get(k)){
                cSN++;
            }
        }
        while(cSN > 0){
        for(int k = 0; k < numbers.size(); k++){
            if(numbers.get(k) == specNums[0]){
                index = k;
            }
        }
        numbers.remove(index);
        for(int j = 0; j < specNums[1]; j++){
            try{
            numbers.remove(index);
            } catch(IndexOutOfBoundsException e){
                continue;
            }
        }
        for(int t = 0; t < specNums[1]; t++){
            try{
            numbers.remove(index-1);
            index--;
            } catch(IndexOutOfBoundsException e){
                continue;
            }
        }   

        cSN--;
    }
        scanner.close();
        return numbers;
    }
    public int sum(ArrayList<Integer> m){
        int sum = 0;
        for(int i = 0; i < m.size(); i++)
            sum += m.get(i);
        return sum;
    }

    public void cardGames(){
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        ArrayList<Integer> hand1 = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            hand1.add(nums[i]);
        }
        int[] nums2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        ArrayList<Integer> hand2 = new ArrayList<Integer>();
        for(int i = 0; i < nums2.length; i++){
            hand2.add(nums2[i]);
        }
        int sum1 = 0;
        int sum2 = 0;
        
        while(!hand1.isEmpty() && !hand2.isEmpty()){
            int j = 0;
            try{
                if(hand1.get(j) > hand2.get(j)){
                    //sum1 += (hand1.get(j) + hand2.get(j));
                    hand1.add(hand1.get(j));
                    hand1.add(hand2.get(j));
                    hand1.remove(0);
                    hand2.remove(0);
                    //System.out.println(hand1 + "\n" + hand2 + "\n" + sum1);
                } else if(hand1.get(j) < hand2.get(j)){
                    //sum2 += (hand1.get(j) + hand2.get(j));
                    hand2.add(hand2.get(j));
                    hand2.add(hand1.get(j));
                    hand2.remove(0);
                    hand1.remove(0);
                } else {
                    hand1.remove(j);
                    hand2.remove(j);
                }
            } catch(IndexOutOfBoundsException e){
                break;
            }
        }
        sum1 = sum(hand1);
        sum2 = sum(hand2);
        //System.out.println(hand1 + "\n" + hand2);
        if(hand1.isEmpty()){
            System.out.println("Second player wins! Sum: " + sum2);
        } else if(hand2.isEmpty()){
            System.out.println("First player wins! Sum: " + sum1);
        }
        scanner.close();
    }
    /*public void appendArrays(){
        Scanner scanner = new Scanner(System.in);
        Stream<String> nums = Arrays.stream(scanner.nextLine().split("|"));
        ArrayList<Integer> numbers1 = new ArrayList<Integer>();
        ArrayList<Object> numbers2 = new ArrayList<Object>();
        ArrayList<Object> numbers3 = new ArrayList<Object>();
        int i =0;
        
        nums.forEach(s -> System.out.print(s)); 
        scanner.close();

    }*/
    public static void main(String[] args){
        //ListsExercercise LE = new ListsExercercise();
        //LE.appendArrays();
        
        
    }
}
