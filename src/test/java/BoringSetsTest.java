import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;


public class BoringSetsTest {

    @Test
    public void shouldCheckIfArrayIsBoring() {
        int[] arr = {5, 5, 5, 4};
        int[] anotherArr = {3, 3, 3, 1};
        int[] oneMoreArr = {4};
        int[] omgAnotherArr = {1, 3, 4, 5};

        Assertions.assertTrue(BoringSets.isBoringArray(arr));
        Assertions.assertTrue(BoringSets.isBoringArray(anotherArr));
        Assertions.assertTrue(BoringSets.isBoringArray(oneMoreArr));
        Assertions.assertFalse(BoringSets.isBoringArray(omgAnotherArr));
    }

    @Test
    public void shouldMakeArrayOfCouners() {
        int[] arr = {1, 2, 3, 1, 2, 2, 3, 3, 3, 1, 4, 4, 5};
        int[] anotherArr = {1, 2, 4, 2, 3, 1, 3, 9, 15, 23};
        int[] oneMoreArr = {1, 2, 3, 4, 5};

        int[] expectedArr = {3, 3, 4, 2, 1};
        int[] expectedAnotherArr = {2, 2, 1, 2, 1, 1, 1};
        int[] expectedOneMoreArray = {1, 1, 1, 1, 1};

        int[] actualArr = BoringSets.getCounters(arr);
        int[] actualAnotherArr = BoringSets.getCounters(anotherArr);
        int[] actualOneMoreArr = BoringSets.getCounters(oneMoreArr);

        Assertions.assertTrue(Arrays.deepEquals(
                Arrays.stream(expectedArr).boxed().toArray(),
                Arrays.stream(actualArr).boxed().toArray()
                ));
        Assertions.assertTrue(Arrays.deepEquals(
                Arrays.stream(expectedAnotherArr).boxed().toArray(),
                Arrays.stream(actualAnotherArr).boxed().toArray()
        ));

        Assertions.assertTrue(Arrays.deepEquals(
                Arrays.stream(expectedOneMoreArray).boxed().toArray(),
                Arrays.stream(actualOneMoreArr).boxed().toArray()
        ));


    }

}