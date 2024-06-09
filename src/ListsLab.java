import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ListsLab {
    Scanner scanner = new Scanner(System.in);
    public void listManipulationBasics() {
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end")) break;

            String[] tokens = line.split(" ");
            if(tokens[0].equals("Add")) {
                int added = Integer.parseInt(tokens[1]);
                numbers.add(added);
            } else if (tokens[0].equals("Remove")) {
                numbers.remove(Integer.valueOf(tokens[1]));
            } else if (tokens[0].equals("RemoveAt")) {
                int index = Integer.parseInt(tokens[1]);
                numbers.remove(index);
            } else if (tokens[0].equals("Insert")) {
                int number = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                numbers.add(index, number); 
            }
        }
        for(int nums:numbers){
            System.out.print(nums + " ");
        }
    }
    public void gaussTick () {
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        List<Integer> sums =  new ArrayList<Integer>();
        for(int i = 0 ; i < numbers.size()/2; i++) {
            sums.add(numbers.get(i) + numbers.get(numbers.size()-1 - i));
        }
        if (numbers.size() % 2 != 0) sums.add(numbers.get(numbers.size()/2));
        for (int nums : sums) {
            System.out.print(nums + " ");
        }

     }
     public void mergingList () {
        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        List<Integer> merged =  new ArrayList<Integer>();
        for(int i = 0; i < numbers1.size() + numbers2.size(); i++) {
            if(i < numbers1.size()) merged.add(numbers1.get(i));
            if(i < numbers2.size()) merged.add(numbers2.get(i));

        }
        for (int nums : merged) {
            System.out.print(nums + " ");
        }
     }
     public void listManipulationAdvanced () {
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end")) break;

            String[] tokens = line.split(" ");
            if(tokens[0].equals("Contains")) {
                if (numbers.contains(Integer.parseInt(tokens[1]))) System.out.println("Yes");
                else System.out.println("No such number");
            }
            else if(tokens[0].equals("Print")) {
                for (int nums : numbers) {
                    if(nums % 2 == 0 && tokens[1].equals("even")) System.out.print(nums+" ");
                    else if(nums % 2 != 0 && tokens[1].equals("odd")) System.out.print(nums+" ");
                }
                System.out.println();
            }
            else if(tokens[0].equals("Get") && tokens[1].equals("sum")) {
                int sum = 0;
                for (int nums : numbers) {
                    sum += nums;
                }
                System.out.println(sum);
            }
            else if(tokens[0].equals("Filter")) {
                for (int nums : numbers) {
                    if (tokens[1].equals("<") && nums < Integer.parseInt(tokens[2])) System.out.print(nums+" ");
                    else if (tokens[1].equals(">") && nums > Integer.parseInt(tokens[2])) System.out.print(nums+" ");
                    else if (tokens[1].equals("<=") && nums <= Integer.parseInt(tokens[2])) System.out.print(nums+" ");
                    else if (tokens[1].equals(">=") && nums >= Integer.parseInt(tokens[2])) System.out.print(nums+" ");
                }
                System.out.println();
            }
        }
    }
    public void listOfProducts () {
        int n = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<String>();
        for(int i = 0; i < n; i++) {
            products.add(scanner.nextLine());
        }
        products.sort(Comparator.naturalOrder());
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i+1 + "."+products.get(i));
        }
    }
    public void removeNegativeAndRevers () {
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                                        map(Integer::parseInt).
                                        collect(Collectors.toList());
        numbers.removeIf(n -> n < 0);
        Collections.reverse(numbers);
        if(numbers.isEmpty()) System.out.println("empty");
        else {
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }
    public static void main(String[] args) {
        ListsLab ll = new ListsLab();
        ll.removeNegativeAndRevers();
    }
}
