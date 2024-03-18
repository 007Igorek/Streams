import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> newList = new ArrayList<>();

        for (int x: intList) {
            if (x > 0 && x % 2 == 0)
                newList.add(x);
        }

        Collections.sort(newList);

        for(int x: newList) {
            System.out.println(x);
        }
    }
}
