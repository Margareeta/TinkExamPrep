import java.util.Scanner;

//partial solution
public class PieCuts {
    private static long getNumberOfCuts(int numberOfPeople) {
       return Math.round(Math.log(numberOfPeople)/Math.log(2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getNumberOfCuts(scanner.nextInt()));
        scanner.close();
    }
}
