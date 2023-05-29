import java.util.Scanner;
/*
Абонентская плата Кости = A рублей в месяц.
Включено = B мегабайт интернет-трафика.
Стоимость 1 мегабайта за лимитом = С рублей
Планирует потратить траффика = D мегабайт
 */

public class MobileExpenses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String[] split = scanner.nextLine().split(" ");
            int [] data = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                data [i] = Integer.parseInt(split[i]);
            }
            if(data[1] >= data[3]){
                System.out.println(data[0]);
            } else {
                System.out.println(data[0] + (data[3] - data[1])*data[2]);
            }
        } else scanner.close();
    }
}
