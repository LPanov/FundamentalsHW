import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MidExamPrep {
    public Scanner scanner = new Scanner(System.in);
    public void ComputerStore() {
        double sum = 0;
        while(true) {
            String s = scanner.nextLine();
            if (s.equals("special")) {
                if(sum > 0){
                    System.out.println("Congratulations you've just bought a new computer!");
                    System.out.printf("Price without taxes: %.2f$\n", sum);
                    System.out.printf("Taxes: %.2f$\n", sum*0.2);
                    System.out.println("-----------");
                    System.out.printf("Total price: %.2f$", (sum+sum*0.2)*0.9);
                    break;
                }
                else {
                    System.out.println("Invalid order!");
                    break;
                }
                
            }
            else if (s.equals("regular")) {
                if(sum > 0){
                    System.out.println("Congratulations you've just bought a new computer!");
                    System.out.printf("Price without taxes: %.2f$\n", sum);
                    System.out.printf("Taxes: %.2f$\n", sum*0.2);
                    System.out.println("-----------");
                    System.out.printf("Total price: %.2f$", (sum+sum*0.2));
                    break;
                }
                else {
                    System.out.println("Invalid order!");
                    break;
                }
            }
            double prices = Double.parseDouble(s);
            if (prices <= 0) System.out.println("Invalid price!");
            else {
                sum += prices;
            }
        }
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
    public void MemoryGame() {
        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(String::valueOf).
                collect(Collectors.toList());
        
        int moves = 0;
        while(true) {
            String s = scanner.nextLine();
            if (s.equals("end")) {
                if (numbers.isEmpty()) {
                    System.out.println("You have won in "+moves+" turns!");
                    break;
                }
                else {
                    System.out.println("Sorry you lose :(");
                    System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
                    break;
                }
            }
            
            String[] indexes = s.split(" ");
            int index1 = Integer.parseInt(indexes[0]);
            int index2 = Integer.parseInt(indexes[1]);
            if (!numbers.isEmpty()) {
                if (index1 == index2 || 
                    (index1 < 0 || index2 < 0) || 
                    (index1 >= numbers.size() || index2 >= numbers.size())) {
                        System.out.println("Invalid input! Adding additional elements to the board");
                        String added = "-"+String.valueOf(moves+1)+"a";
                        numbers.add(numbers.size()/2, added);
                        numbers.add(numbers.size()/2, added);
                    }
                else if (numbers.get(index1).equals(numbers.get(index2))) {
                    System.out.println("Congrats! You have found matching elements - "+numbers.get(index1)+"!");
                    numbers.set(index1, "");
                    numbers.set(index2, "");
                    numbers.remove("");
                    numbers.remove("");
                }
                else if (!numbers.get(index1).equals(numbers.get(index2))) {
                    System.out.println("Try again!");
                }
                //System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
                moves++;
            }
            else continue;
        }
        //System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
    public static void main(String[] args) {
        MidExamPrep mep = new MidExamPrep();
        mep.MemoryGame();
    }
}
