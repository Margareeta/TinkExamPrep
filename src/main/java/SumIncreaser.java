import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//partial solution
public class SumIncreaser {

    private static boolean areAllOneDigit(int[] arr) {
        return Arrays.stream(arr).allMatch(i -> i < 10 && i > 0);
    }

    private static boolean allDigitsAreNine(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .allMatch(s -> s.matches("9+"));
    }

    private static int getNumberFromStrings(String[] split) {
        String numString = "";
        for (String s : split) {
            numString += s;
        }
        return Integer.parseInt(numString);
    }

    private static int getIncreasedNumber(int num) {
        String numString = String.valueOf(num);
        int res = 0;
        if (numString.matches("9+")) {
            res = num;
        }
        String[] split = numString.split("");
        split[0] = "9";
        res = getNumberFromStrings(split);
        if (numString.contains("9")) {
            for (int i = 0; i < split.length; i++) {
                if (!split[i + 1].equals("9")) {
                    split[i + 1] = "9";
                }
                break;
            }
            res = getNumberFromStrings(split);
        }

        return res;
    }

    public static int getInitialSum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public static int getIncreasedSum(int[] arr, int numberOfOps) {
        int increasedSum = 0;
        int initialSum = getInitialSum(arr);
        int res = 0;
        int temp = 0;

        if (areAllOneDigit(arr)) {
            arr = Arrays.stream(arr).sorted().toArray();
            for (int i = 0; i < numberOfOps; i++) {
                arr[i] = 9;
            }
            increasedSum = Arrays.stream(arr).sum();
            res = increasedSum - initialSum;
        }

        if (arr.length == 1) {
            if (String.valueOf(arr[0]).matches("9+")) {
                res = 0;
            } else {
                for (int i = 0; i < numberOfOps; i++) {
                    temp = getIncreasedNumber(arr[0]);
                }
                increasedSum = temp;
                res = increasedSum - initialSum;
            }
        } else {
            int sortedArr[] = Arrays.stream(arr).sorted().toArray();
            if (areAllOneDigit(sortedArr)) {
                for (int i = 0; i < numberOfOps; i++) {
                    arr[i] = 9;
                }
                increasedSum = Arrays.stream(arr).sum();
                res = increasedSum - initialSum;
            } else {//think about it
                arr = Arrays.stream(sortedArr)
                        .filter(i -> !String.valueOf(i).matches("9+"))
                        .toArray();
                int nines = Arrays.stream(Arrays.stream(sortedArr)
                        .filter(i -> String.valueOf(i).matches("9+"))
                        .toArray()).sum();
                for (int i = arr.length - 1; i >= numberOfOps; i--) {
                    arr[i] = getIncreasedNumber(arr[i]);
                }
                increasedSum = Arrays.stream(arr).sum() + nines;
                res = increasedSum - initialSum;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = null;
        int[] numbersAndOperations = null;
        for (int i = 0; i < 2; i++) {
            String line = reader.readLine();
            String[] split = line.split(" ");
            if (split.length == 2) {
                numbersAndOperations = new int[2];
                for (int j = 0; j < split.length; j++) {
                    numbersAndOperations[j] = Integer.parseInt(split[j]);
                }
            }else{
                nums = new int[split.length];
                for (int j = 0; j < nums.length; j++) {
                    nums[j] = Integer.parseInt(split[j]);
                }
            }
        }
        System.out.println(getIncreasedSum(nums, numbersAndOperations[1]));
    }
}
