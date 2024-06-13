import java.util.*;
import java.util.stream.Collectors;
import  java.util.ArrayList;

public class ListsMoreExercise {
    Scanner scanner = new Scanner(System.in);

    public void messaging() {
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).
                toList();
        String s = scanner.nextLine();
        List<Integer> sums = new ArrayList<>();
        for (int nums : numbers) {
            int sum = 0;
            for (int j = 0; j < String.valueOf(nums).length(); j++) {
                sum += Character.getNumericValue(String.valueOf(nums).charAt(j));
            }
            sums.add(sum);
        }
        String output = "";
        for (int sum : sums) {
            if (sum < s.length() && sum >= 0) {
                char ch = s.charAt(sum);
                output += ch;
            } else if (sum > s.length() - 1) {
                sum -= s.length();
                output += s.charAt(sum);
            }
            s = s.replaceFirst(String.valueOf(s.charAt(sum)), "");
        }
        //System.out.println(sums.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(output);
    }

    public void carRace() {
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Double::parseDouble).
                collect(Collectors.toList());
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i < numbers.size() / 2; i++) {
            if (numbers.get(i) > 0) sum1 += numbers.get(i);
            else if (numbers.get(i) == 0) sum1 = sum1 * 0.8;
        }
        for (int i = numbers.size() - 1; i > numbers.size() / 2; i--) {
            if (numbers.get(i) > 0) sum2 += numbers.get(i);
            else if (numbers.get(i) == 0) sum2 = sum2 * 0.8;
        }
        if (sum1 < sum2) System.out.printf("The winner is left with total time: %.1f", sum1);
        else System.out.printf("The winner is right with total time: %.1f", sum2);
    }

    public void takeSkipRope() {
        String s = scanner.nextLine();
        List<Character> chars = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> take = new ArrayList<>();
        List<Integer> skip = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) numbers.add(Character.getNumericValue(s.charAt(i)));
            else chars.add(s.charAt(i));
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) take.add(numbers.get(i));
            else skip.add(numbers.get(i));
        }

        String output = "";
        int index = 0;

        for (int i = 0; i < take.size(); i++) {
            try {
                for (int j = 1; j <= take.get(i); j++) {
                    output += chars.get(index);
                    index++;
                }
                index += skip.get(i);
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }

        System.out.println(output);

    }


    public void mixedUpLists() {
        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).
                toList();
        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).
                toList();
        List<Integer> output = new ArrayList<>();

        int smallerSize = Math.min(numbers1.size(), numbers2.size());
        boolean isBigger = numbers1.size() > numbers2.size();
        int j = numbers2.size() - 1;
        for (int i = 0; i < smallerSize; i++) {
            output.add(numbers1.get(i));
            output.add(numbers2.get(j));
            j--;
        }
        int range1, range2;
        if (isBigger) {
            range1 = Math.min(numbers1.get(numbers1.size() - 2), numbers1.get(numbers1.size() - 1));
            range2 = Math.max(numbers1.get(numbers1.size() - 1), numbers1.get(numbers1.size() - 2));
        } else {
            range1 = Math.min(numbers2.get(0), numbers2.get(1));
            range2 = Math.max(numbers2.get(0), numbers2.get(1));
        }

        //System.out.println(output.toString().replaceAll("[\\[\\],]", ""));
        Collections.sort(output);
        for (int o : output) {
            if (o > range1 && o < range2) {
                System.out.print(o + " ");
            }
        }
    }

    public void drumSet() {
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drums = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        List<Integer> originalDrums = new ArrayList<>(drums);

        while (savings > 0) {
            String s = scanner.nextLine();
            if (s.equals("Hit it again, Gabsy!")) break;

            int pwr = Integer.parseInt(s);
            for (int i = 0; i < drums.size(); i++) {
                int priceDrum = originalDrums.get(i) * 3;
                drums.set(i, drums.get(i) - pwr);
                if (drums.get(i) <= 0 ) {
                    if (priceDrum < savings){
                        drums.set(i, originalDrums.get(i));
                        savings -= priceDrum;
                    } else {
                        if(i == 0) {
                            //int temp = drums.get(i);
                            drums.set(0, drums.get(i+1) - pwr);
                            drums.remove(1);
                            originalDrums.remove(0);

                        } else {
                            drums.remove(i);
                            originalDrums.remove(i);
                        }
                    }
                }
                
            }
            //System.out.println(savings);
            //System.out.println(drums.toString().replaceAll("[\\[\\],]", ""));

        }
        System.out.println(drums.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }


    public static void main(String[] args) {
        ListsMoreExercise lme = new ListsMoreExercise();
        lme.drumSet();
    }
}
