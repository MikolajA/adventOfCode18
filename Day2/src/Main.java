import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("inputDay2.txt"));

        List<String> list = new ArrayList<>();

        while (scanner.hasNext()){
            list.add(scanner.next());
        }

        System.out.println(partOne(list));
    }

    private static Integer partOne(List<String> list){

        Set<String> duuble = new HashSet<>();
        Set<String> triple = new HashSet<>();
        int result = 0;

        for(int i =0; i<list.size(); i++){
            for(int j=0; j<list.get(i).length(); j++){
                int finalJ = j;
                int finalI = i;
                long count = list.get(i).chars().filter(ch -> ch == list.get(finalI).charAt(finalJ)).count();
                if(count == 2){
                    duuble.add(list.get(i));
                } else if (count == 3){
                    triple.add(list.get(i));
                }
            }
        } result = duuble.size()*triple.size();
        return result;
    }
}
