import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MidExam {

    Scanner scanner = new Scanner(System.in);

    public void biscuitFactory() {
        int biscuits = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());
        int biscsForMonth = Integer.parseInt(scanner.nextLine());

        int biscs = 0;

        for (int i = 1; i <= 30; i++) {
            int day = biscuits*count;
            if (i % 3 == 0) {
                day = (int) Math.floor(0.75*day);
            }
            biscs += day;
        }

        int diff = biscsForMonth - biscs;

        System.out.println("You have produced "+biscs+" biscuits for the past month.");

        double percMore = ((double) Math.abs(diff)/ biscsForMonth)*100;
        if(diff < 0) System.out.printf("You produce %.2f percent more biscuits.", percMore);
        else System.out.printf("You produce %.2f percent less biscuits.", Math.abs(percMore));
    }

    public void coffeeLover() {
        List<String> coffees = Arrays.stream(scanner.nextLine().split("\\s+")).
                                        collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            if (s[0].equals("Include")) {
                coffees.add(s[1]);
            }
            else if (s[0].equals("Remove")) {
                if (Integer.parseInt(s[2]) > coffees.size()) {
                    continue;
                } else {
                    if (s[1].equals("first")) {
                        for (int j = 0; j < Integer.parseInt(s[2]); j++){
                            coffees.remove(0);
                        } 
                    }
                    else if (s[1].equals("last")) {
                        for (int j = 0; j < Integer.parseInt(s[2]); j++){
                            coffees.remove(coffees.size()-1);
                        } 
                    }
                }
            }
            else if (s[0].equals("Prefer")) {
                int index1 = Integer.parseInt(s[1]);
                int index2 = Integer.parseInt(s[2]);
                 if (index1 >=0 && index1 < coffees.size() &&
                    index2 >=0 && index2 < coffees.size()) {
                        String temp = coffees.get(index1);
                        coffees.set(index1, coffees.get(index2));
                        coffees.set(index2, temp);
                    }
                    else {
                        continue;
                    }
            }
            else if (s[0].equals("Reverse")) {
                Collections.reverse(coffees);
            }

        }

        System.out.println("Coffees:");
        //System.out.println();
        for (String coffee : coffees) {
            System.out.print(coffee + " ");
        }
    }

    public boolean phoneExist(String s, List<String> phones) {
        for (String phone : phones) {
            if (s.equals(phone)) return true;
        }
        return false;
    }

    public void phoneShop() {
        List<String> phones = Arrays.stream(scanner.nextLine().split(", ")).
                                collect(Collectors.toList());
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("End")) break;
            String[] token = s.split("\\s+");

            if(token[0].equals("Add")) {
                if (phoneExist(token[2], phones)) {
                    continue;
                } else {
                    phones.add(token[2]);
                }
            }
            else if (token[0].equals("Remove")) {
                if (phoneExist(token[2], phones)) {
                    phones.remove(token[2]);
                } else {
                    continue;
                }
            }
            else if (token[0].equals("Bonus")) {
                if (phoneExist(token[3].substring(0, token[3].indexOf(":")), phones)) {
                    phones.add(phones.indexOf(token[3].substring(0, token[3].indexOf(":"))) + 1, token[3].substring(token[3].indexOf(":")+1, token[3].length()));
                } else {
                    continue;
                }
            }
            else if (token[0].equals("Last")) {
                if (phoneExist(token[2], phones)) {
                    phones.add(token[2]);
                    phones.remove(token[2]);
                } else {
                    continue;
                }
            }
        }
        System.out.println(String.join(", ", phones));
        //System.out.println(phones.toString().replaceAll("[\\[\\],]", ""));
    }

    public static void main(String[] args) {
        MidExam me = new MidExam();
        me.biscuitFactory();
    }
    
}
