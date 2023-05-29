import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//partial solution
public class StairwayLogistics {
    public static int getMinimumNumbersOfFloorsToWalk(
            int timeOfDeparture,
            int numberOfTheFloorOfDeparting,
            int[] floors) {
        int res = 0;
        int topFloor = floors[floors.length - 1];
        int middleOfTheBuilding = (topFloor - 1) / 2;
        int start = floors[numberOfTheFloorOfDeparting - 1];
        if (timeOfDeparture >= numberOfTheFloorOfDeparting || timeOfDeparture >= middleOfTheBuilding) {
            res = topFloor - 1;
        } else if (timeOfDeparture < numberOfTheFloorOfDeparting && start < middleOfTheBuilding) {
            res = start - floors[0] + topFloor - 1;
        } else if (timeOfDeparture < numberOfTheFloorOfDeparting && start >= middleOfTheBuilding) {
            res = (topFloor - start) + topFloor - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] floorsAndTime = new int[2];
        int numberOfWorker = 0;
        int floors[] = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            try {
                String line = reader.readLine();
                if (line.contains(" ")) {
                    String[] split = line.split(" ");
                    if (split.length == 2) {
                        for (int j = 0; j < split.length; j++) {
                            floorsAndTime[j] = Integer.parseInt(split[j]);
                        }
                    } else {
                        floors = new int[split.length];
                        for (int j = 0; j < floors.length; j++) {
                            floors[j] = Integer.parseInt(split[j]);
                        }
                    }
                } else {
                    numberOfWorker = Integer.parseInt(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(getMinimumNumbersOfFloorsToWalk(floorsAndTime[1], numberOfWorker, floors));
    }
}
