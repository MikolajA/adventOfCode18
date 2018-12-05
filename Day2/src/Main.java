import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("inputDay2.txt"));

        List<String> list = new ArrayList<>();

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }

        System.out.println(partOne(list));

        partTwo(list);


    }

    private static Integer partOne(List<String> list) {

        Set<String> duuble = new HashSet<>();
        Set<String> triple = new HashSet<>();
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                int finalJ = j;
                int finalI = i;
                long count = list.get(i).chars().filter(ch -> ch == list.get(finalI).charAt(finalJ)).count();
                if (count == 2) {
                    duuble.add(list.get(i));
                } else if (count == 3) {
                    triple.add(list.get(i));
                }
            }
        }
        result = duuble.size() * triple.size();
        return result;
    }

    private static void partTwo(List<String> list) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                String s1 = list.get(i);
                String s2 = list.get(j);
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < s1.length(); k++) {
                    if (s1.charAt(k) == s2.charAt(k)) {
                        sb.append(s1.charAt(k));
                    }
                }
                result.add(sb.toString());
            }
        }
        result.stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);
    }
}

