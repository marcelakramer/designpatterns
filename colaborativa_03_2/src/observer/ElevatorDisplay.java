package observer;

import java.util.List;

public class ElevatorDisplay implements Observer {
    @Override
    public void update(int currentFloor, String status, List<Integer> queue) {
        System.out.println();
        System.out.println("+-----------------+");
        System.out.print("| ");

        for (Integer floor : queue) {
            System.out.print(floor + " ");
        }
        System.out.println("|");

        System.out.println("+-----------------+");
        System.out.println("| " + status + " [" + currentFloor + "] |");
        System.out.println("+-----------------+");
    }
}

