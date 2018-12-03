import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("inputDay1.txt"));

        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        System.out.println(partOne(list));

        System.out.println(partTwo(list));

    }

    private static int partOne(List<Integer> list) {

        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    private static int partTwo(List<Integer> list) {

        Set<Integer> duplicates = new HashSet<>();
        int sum = 0;
        int whileBreak = 0;

        while (whileBreak == 0) {
            for (Integer i : list) {
                sum += i;
                if (duplicates.contains(sum)) {
                    whileBreak = 1;
                    break;
                } else {
                    duplicates.add(sum);
                }
            }
        }
        return sum;
    }
}
