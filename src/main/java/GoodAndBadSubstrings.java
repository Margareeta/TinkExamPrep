import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GoodAndBadSubstrings {
    private static boolean hasGoodSubstring(String s) {
        return s.contains("a")
                && s.contains("b")
                && s.contains("c")
                && s.contains("d");
    }

    private static int calculateMinGoodSubstring(String line) {
        List<Integer> arr = new ArrayList<>();
        int res = 0;
        if(hasGoodSubstring(line)){
        for (int i = 0; i < line.length(); i++) {
            for (int j = i; j < line.length()+ 1; j++) {
                if(hasGoodSubstring(line.substring(i, j))){
                    String substring = line.substring(i, j);
                    arr.add(substring.length());
                }
            }
            res = arr.stream().min(Comparator.comparing(Integer::intValue)).get();
        }

        }else res = -1;

        return  res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String line = scanner.next();

        if(hasGoodSubstring(line)){
            System.out.println(calculateMinGoodSubstring(line));
        }else System.out.println(-1);

    }

}

