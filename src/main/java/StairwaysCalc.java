import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StairwaysCalc {
    private static int getNumberOfStairways(
            int numberOfWorkers,
            int timeOfDeparture,
            int[] listOfStairs,
            int numberOfDepartingWorker
    ) {
        if (timeOfDeparture >= numberOfDepartingWorker) {
            return listOfStairs.length - 1;
        } else return listOfStairs[numberOfDepartingWorker - 1] + listOfStairs[listOfStairs.length - 1] - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] floorsAndTime = new int[2];
        int[] floors = new int[floorsAndTime[0]];
        int[] numberOfWorker = new int[1];
        List data = new ArrayList<String>();

        if (scanner.hasNext()) {
            String[] split = scanner.nextLine().split(" ");
            for (int i = 0; i < split.length; i++) {
                data.add(split[i]);
            }
        }
        scanner.close();
        for (int i = 2; i < data.size() - 1; i++) {
            floors[i] = (int) data.get(i);
        }
        numberOfWorker[0] = (int) data.get(data.size() - 1);

        System.out.println(getNumberOfStairways(floors.length, floorsAndTime[1], floors, numberOfWorker[0]));
    }
}
