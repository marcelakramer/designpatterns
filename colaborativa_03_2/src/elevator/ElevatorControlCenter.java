package elevator;

import observer.ElevatorDisplay;

public class ElevatorControlCenter {
    private final Elevator elevator;

    public ElevatorControlCenter(Elevator elevator) {
        this.elevator = elevator;
    }

    public void selectFloor(int floor) {
        elevator.selectFloor(floor);
    }

    public void move() {
        elevator.move();
    }

    public void openDoor() {
        elevator.openDoor();
    }

    public void closeDoor() {
        elevator.closeDoor();
    }

    public void addDisplay(ElevatorDisplay elevatorDisplay) {
        this.elevator.addObserver(elevatorDisplay)
    }
}
