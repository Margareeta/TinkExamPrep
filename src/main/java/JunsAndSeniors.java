import java.util.Scanner;

public class JunsAndSeniors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            int[] ints = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                ints[i] = Integer.parseInt(split[i]);
            }
            System.out.println((ints[0]*ints[2]+ ints[1] - 1)/ints[1]);
        }
        scanner.close();
    }
}
