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
        int currentFloor = elevator.getCurrentFloor();

        if (!elevator.getRequestQueue().isEmpty()) {
            int targetFloor = elevator.getRequestQueue().getFirst();
            elevator.setState(currentFloor < targetFloor ? new MovingUpState(elevator) : new MovingDownState(elevator));
            elevator.move();
        }
    }

    @Override
    public String toString() {
        return "Stopped";
    }
}
