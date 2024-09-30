package elevator;

import observer.Observer;

public class ElevatorControlCenter {
    private final Elevator elevator;

    public ElevatorControlCenter(Elevator elevator) {
        this.elevator = elevator;
    }

    public void selectFloor(int floor, boolean goingUp) {
        elevator.selectFloor(floor, goingUp);
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

    public void addObserver(Observer observer) {
        this.elevator.addObserver(observer);
    }
}
