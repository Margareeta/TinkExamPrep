import java.util.*;

public class Cat {
    String name;

    private static Cat renameCat(Cat cat) {
        System.out.print(cat.name);
        cat = new Cat();
        cat.name = "Mia";
        return cat;


    }
    public final Integer doNothingForNow(boolean needSum, int... numbers) {
        return null;
    }
    public static void main(String[] args) {
        Map<Integer, Integer> relations = new HashMap<>();
        relations.put(1, 2);
        relations.put(3, 4);
        relations.forEach((k, v) -> relations.put(v, k));
}}
