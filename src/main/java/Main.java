import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static int[] getCounters(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : numbers) { //suppose you have the numbers in 'numbers' array
            if (map.containsKey(i)) { //this number is in the map already
                map.put(i, map.get(i) + 1);
            } else{ //we didnt see this number before
                map.put(i, 1);
            }
        }
        //now we loop the map to sum the repeating numbers
        int sum = 0;
        List<Integer> counts = new ArrayList<>();
        for (int i: map.values()) {
            counts.add(i);
        }
        int[] res = new int[counts.size()];
        for (int i = 0; i < counts.size() ; i++) {
            res[i] = counts.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 2, 3, 3, 3, 1, 4, 4, 5};//[3, 3, 4, 2, 1]
        int[] anotherArr = {1, 2, 4, 2, 3, 1, 3, 9, 15, 23};//[2, 2, 1, 2, 1, 1, 1]
        int[] oneMoreArr = {1, 2, 3, 4, 5};//[1,1,1,1,1]

        int[] counters = getCounters(anotherArr);
        for (int i:counters) {
            System.out.print(i + " ");
        }
    }
}
