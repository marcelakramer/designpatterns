package state;

import elevator.Elevator;

public class MovingDownState implements ElevatorState {
    private final Elevator elevator;

    public MovingDownState(Elevator elevator) {
        this.elevator = elevator;
        elevator.closeDoor();
    }

    @Override
    public void move() {
        for (int i = elevator.getCurrentFloor(); i <= elevator.getTotalOfFloors(); i--) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int currentFloor = elevator.getCurrentFloor() - 1;
            elevator.setCurrentFloor(currentFloor);

            if (elevator.getRequestQueue().contains(currentFloor)) {
                elevator.openDoor();
                elevator.closeDoor();
                elevator.removeRequest(currentFloor);
            }

            if (elevator.hasArrivedAtDestination()) {
                elevator.setState(new StoppedState(elevator));
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Moving down";
    }
}
