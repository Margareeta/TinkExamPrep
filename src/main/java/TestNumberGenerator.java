import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestNumberGenerator {
    public static long[] getNumArray(int l, int r) {
        long[] res = new long[r - l];
        for (int i = 0; i < res.length; i++) {
            res[i] = r++;
        }
        return res;
    }

    private static long getAllTheSameDigits(long[] arr) {
        return 0;
    }

    public static long calculateGoodNumbers(int l, int r) {
        long[] arr = getNumArray(l, r);
        long res = getAllTheSameDigits(arr);
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        System.out.println(calculateGoodNumbers(nums[0], nums[1]));

    }
}
