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
        int targetFloor =  elevator.getRequestQueue().getFirst();
        if (currentFloor < targetFloor) {
            elevator.setState(new MovingUpState(elevator));
        } else if (currentFloor > targetFloor) {
            elevator.setState(new MovingDownState(elevator));
        } else {
            return;
        }
        elevator.move();
    }

    @Override
    public String toString() {
        return "Stopped";
    }
}
