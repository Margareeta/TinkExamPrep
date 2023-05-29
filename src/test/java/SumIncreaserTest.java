import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class SumIncreaserTest {
    @Test
    public void shouldNotIncreaseIfSizeIsOneAndAllNines() {
        int[] arr = {9999};
        int ops = 10;
        int actual = SumIncreaser.getIncreasedSum(arr, ops);
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseAllNumsUnder10() {
        int[] arr = {1, 2, 1, 3, 5};
        int ops = 2;
        int actual = SumIncreaser.getIncreasedSum(arr, ops);
        int expected = 16;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseNumsAbove10() {
        int[] arr = {99, 5, 85};
        int ops = 1;
        int actual = SumIncreaser.getIncreasedSum(arr, ops);
        int expected = 10;
        Assertions.assertEquals(expected, actual);
    }
}