import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class StairwayLogisticsTest {

    //works
    @Test
    public void souldFindMinIfTheWayIsStraightUp() {
        int[] floors = {1, 4, 9, 16, 25};
        int actual = StairwayLogistics.getMinimumNumbersOfFloorsToWalk(5, 2, floors);
        int expected = 24;
        Assertions.assertEquals(expected, actual);
    }

    //works
    @Test
    public void shouldFindMinIfTheWayIsFirstDown() {
        int[] floors = {1, 2, 3, 6, 8, 25};
        int actual = StairwayLogistics.getMinimumNumbersOfFloorsToWalk(4, 5, floors);
        int expected = 31;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMinIfTheWayIsFirstUp() {
        int[] floors = {1, 2, 3, 6, 8, 20, 25};
        int actual = StairwayLogistics.getMinimumNumbersOfFloorsToWalk(4, 6, floors);
        int expected = 29;
        Assertions.assertEquals(expected, actual);

    }

}