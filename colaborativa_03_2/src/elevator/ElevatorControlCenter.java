package elevator;

import observer.ElevatorDisplay;

public class ElevatorControlCenter {
    private final Elevator elevator;

    public ElevatorControlCenter(Elevator elevator) {
        this.elevator = elevator;
        ElevatorDisplay panel = new ElevatorDisplay();
        elevator.addObserver(panel);
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
}
