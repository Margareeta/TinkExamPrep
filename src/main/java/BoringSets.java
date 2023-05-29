import java.util.*;
import java.util.stream.Collectors;
/*
Набор чисел x1, x2, ... xk назовем "скучным", если возможно удалить из него один элемент так,
чтобы каждое число в данном наборе встречалось одинаковое количество раз.

Дан массив , a2,... an длины n. Найдите максимальное число l(2 ≤ l ≤ n),
что префикс длины l является скучным.
Формат выходных данных

Выведите одно число — максимальное l, что префикс длины l массива a является скучным.

Пример1:
13
1 2 3 1 2 2 3 3 3 1 4 4 5
Вывод: 10

Пример2:
10
1 2 4 2 3 1 3 9 15 23
Вывод: 7

Пример3:
5
1 2 3 4 5
Вывод: 5
 */

public class BoringSets {
    //checking on the list of quantities if the array is boring
    public static boolean isBoringArray(int[] counts) {
        int[] distincts = Arrays.stream(counts).distinct().toArray();
        int counter = 0;
        if (distincts.length == 2
                && ((distincts[0] - distincts[1] == 1 || distincts[1] - distincts[0] == 1)
                || (distincts[0] == 1 || distincts[1] == 1))) {
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == distincts[0]) {
                    counter++;
                }
            }
        }
        if ((counter == 1 || counter == counts.length - 1)
                || counts.length == 1 || distincts.length == 1) {
            return true;
        }
        return false;
    }

    //getting how many of each num I have
    public static int[] getCounters(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int sum = 0;
        List<Integer> counts = new ArrayList<>();
        for (int i : map.values()) {
            counts.add(i);
        }
        int[] res = new int[counts.size()];
        for (int i = 0; i < counts.size(); i++) {
            res[i] = counts.get(i);
        }
        return res;
    }

    //TODO: correct this shit
    public static int getLengthOfBoringArr(int[] arr) {
        int res = 0;
        int[] counters = getCounters(arr);
        while (!isBoringArray(counters)) {
            int[] temp = new int[arr.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
            counters = getCounters(arr);
            getLengthOfBoringArr(counters);
        }
        res = arr.length;
        return res;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = scanner.nextInt();
//        String next = scanner.next();
//        String[] split = next.split(" ");
//        int[] ints = new int[split.length];
//        for (int i = 0; i < split.length; i++) {
//            ints[i] = Integer.parseInt(split[i]);
//        }
        int[] arr = {1, 2, 3, 1, 2, 2, 3, 3, 3, 1, 4, 4, 5};
        int[] anotherArr = {1, 2, 4, 2, 3, 1, 3, 9, 15, 23};
        int[] oneMoreArr = {1, 2, 3, 4, 5};
        System.out.println(getLengthOfBoringArr(arr));
        System.out.println(getLengthOfBoringArr(anotherArr));
        System.out.println(getLengthOfBoringArr(oneMoreArr));

    }
}
