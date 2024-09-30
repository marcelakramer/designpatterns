package state;

import elevator.Elevator;

public class StoppedState implements ElevatorState {
    private final Elevator elevator;

    public StoppedState(Elevator elevator) {
        this.elevator = elevator;
        elevator.openDoor();
    }

    @Override
    public void move() {
        while (!elevator.hasArrivedAtDestination()) {
            int currentFloor = elevator.getCurrentFloor();

            if (!elevator.getRequestQueue().isEmpty()) {
                int targetFloor = elevator.getRequestQueue().get(0);
                elevator.setState(currentFloor < targetFloor ? new MovingUpState(elevator) : new MovingDownState(elevator));
            } else {
                return;
            }

            elevator.move(); // Start moving based on the current state
        }
    }

    @Override
    public String toString() {
        return "Stopped";
    }
}
