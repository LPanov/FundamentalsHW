import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListsExercercise {

    public Scanner scanner = new Scanner(System.in);

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
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;

            String[] tokens = line.split(" ");
            if(tokens[0].equals("Delete")){
                numbers.removeIf(n -> n == Integer.parseInt(tokens[1]));
            }
            else if (tokens[0].equals("Insert")) {
                numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private boolean inList (String name, List<String> list)  {
        boolean isInList = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) isInList = true;
        }
        return isInList;
    }
    public void houseParty(){
        int N = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<String> ();
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            if (tokens[2].equals("going!")) {
                if (inList(tokens[0], guests)) System.out.println(tokens[0] + " is already in the list!");
                else guests.add(tokens[0]);
            }
            else if (tokens[2].equals("not")) {
                if (inList(tokens[0], guests)) guests.remove(tokens[0]);
                else System.out.println(tokens[0] + " is not in the list!");
            }
        }
        for (String names : guests) {
            System.out.println(names);
        }
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

    public void bombNumbers(){
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        int[] bombNumber = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(e -> Integer.parseInt(e))
                            .toArray();
      
        while (true) {
            int count = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == bombNumber[0]) {
                    count++;
                }
            }
            if(count == 0) break;

            if(bombNumber[1] >= 0) {
                for(int i = 1; i <= bombNumber[1]; i++) {
                    if (numbers.indexOf(bombNumber[0]) - i >= 0) numbers.set(numbers.indexOf(bombNumber[0]) - i, 0);
                    if (numbers.indexOf(bombNumber[0]) + i < numbers.size()) numbers.set(numbers.indexOf(bombNumber[0]) + i, 0);
                }
                numbers.set(numbers.indexOf(bombNumber[0]), 0);
            }
        }
            System.out.println(sum(numbers));
            // System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private int sum(List<Integer> m){
        int sum = 0;
        for(int n : m)
            sum += n;
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
    public void appendArrays () {
        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\|")).
                                        map(String::valueOf).
                                        collect(Collectors.toList());
        List<Integer> digits = new ArrayList<Integer>();
        Collections.reverse(numbers);
        for (String nums : numbers) {
            for (int j = 0; j < nums.length(); j++){
                if (Character.isDigit(nums.charAt(j))) digits.add(Integer.parseInt(String.valueOf(nums.charAt(j))));
            }
        }
        System.out.println(digits.toString().replaceAll("[\\[\\],]", ""));
    }
    public String[] split(String src, int len) {
        String[] result = new String[(int)Math.ceil((double)src.length()/(double)len)];
        for (int i=0; i<result.length; i++)
            result[i] = src.substring(i*len, Math.min(src.length(), (i+1)*len));
        return result;
    }
    public void anonymousThreat () {
        List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        while(true) {
            String s = scanner.nextLine();
            if(s.equals("3:1")) break;

            String[] command = s.split(" ");
            if(command[0].equals("merge")){
                try {
                    int index = Integer.parseInt(command[1]);
                    for (int i = 0; i < Integer.parseInt(command[2]) - index; i++){
                        input.set(index, input.get(index).concat(input.get(index+1)));
                        input.remove(index+1);
                    }
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }
            }
            else if (command[0].equals("divide")) {
                int index = Integer.parseInt(command[1]);
                String word = input.get(index);
                String[] splitted = split(word, word.length()/Integer.parseInt(command[2]));
                for (int i = 0; i < splitted.length; i++) {
                    input.add(splitted[i]);
                }
                input.remove(word);
            }
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }

    private List<Integer> raiseDecrease (List<Integer> input, int index) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) <= input.get(index) && i != index) input.set(i, input.get(i) + input.get(index));
            else if (input.get(i) > input.get(index) && i != index) input.set(i, input.get(i) - input.get(index));
        }
        return input;
    }
    private List<Integer> raiseDecreaseSpecial (List<Integer> input, int value) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) <= value) input.set(i, input.get(i) + value);
            else if (input.get(i) > value) input.set(i, input.get(i) - value);
        }
        return input;
    }
    public void pokemonDontGo () {
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        int sum = 0;
        while (!numbers.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index > numbers.size() - 1) {
                int incDec = numbers.get(numbers.size() - 1);
                sum += incDec;
                numbers.set(numbers.size() - 1, numbers.get(0));
                numbers = raiseDecreaseSpecial(numbers, incDec);
                
            }
            else if (index < 0) {
                int incDec = numbers.get(0);
                sum += incDec;
                numbers.set(0, numbers.get(numbers.size() - 1));
                numbers = raiseDecreaseSpecial(numbers, incDec);
            } else {
                numbers = raiseDecrease(numbers, index);
                //System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
                sum += numbers.get(index);
                numbers.remove(index);
            }
            //System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
        System.out.println(sum);
    }

    public void softuniCoursePlanning () {
        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        while (true) {
            String s = scanner.nextLine();
            if (s.equals("course start")) break;

            String[] commands = s.split("\\:");
            if(commands[0].equals("Add")) {
                if(!input.contains(commands[1])) input.add(commands[1]);
            }
            else if (commands[0].equals("Insert")) {
                int index = Integer.valueOf(commands[2]);
                if(!input.contains(commands[1])) input.add(index, commands[1]);
            }
            else if (commands[0].equals("Remove")) {
                String exercise = commands[1]+"-Exercise";
                if(input.contains(commands[1])) input.remove(commands[1]);
                if(input.contains(exercise)) input.remove(exercise);
            }
            else if (commands[0].equals("Swap")) {
                String exercise1 = commands[1]+"-Exercise";
                String exercise2 = commands[2]+"-Exercise";

                if(input.contains(commands[1]) && input.contains(commands[2])) {
                    String temp = commands[1];
                    int index2 = input.indexOf(commands[2]);
                    input.set(input.indexOf(commands[1]), commands[2]);
                    input.set(index2, temp);
                }
                if(input.contains(exercise1)) {
                    input.remove(input.indexOf(exercise1));
                    input.add(input.indexOf(commands[1]) + 1, exercise1);

                }
                if(input.contains(exercise2)) {
                    input.remove(input.indexOf(exercise2));
                    input.add(input.indexOf(commands[2]) + 1, exercise2);
                }
            }
            else if (commands[0].equals("Exercise")) {
                if(input.contains(commands[1])) {
                    String exercise = commands[1] + "-Exercise";
                    input.add(input.indexOf(commands[1])+1, exercise);
                }
                else {
                    String exercise = commands[1] + "-Exercise";
                    input.add(commands[1]);
                    input.add(exercise);
                }
            } 
            //System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
        }
        int i = 1;
        for (String lesson : input) {
            System.out.println(i+"."+lesson);
            i++;
        }
    }
    public static void main(String[] args){
        ListsExercercise LE = new ListsExercercise();
        LE.softuniCoursePlanning();
        
    }
}
