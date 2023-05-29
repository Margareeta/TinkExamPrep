import java.util.Scanner;

public class PeopleQueue {
    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            } else if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return true;
    }

    private static boolean isSortedReversely(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            } else if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String[] split = nextLine.split(" ");
            int[] ints = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                ints[i] = Integer.parseInt(split[i]);
            }
            if (isSorted(ints) || isSortedReversely(ints)) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
        scanner.close();
    }
}
