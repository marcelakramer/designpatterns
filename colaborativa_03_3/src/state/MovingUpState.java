package state;

import elevator.Elevator;

public class MovingUpState implements ElevatorState {
    private final Elevator elevator;

    public MovingUpState(Elevator elevator) {
        this.elevator = elevator;
        elevator.closeDoor();
    }

    @Override
    public void move() {
        for (int i = elevator.getCurrentFloor(); i <= elevator.getRequestQueue().get(0); i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int currentFloor = elevator.getCurrentFloor() + 1;
            elevator.setCurrentFloor(currentFloor);

            if (elevator.getRequestQueue().getFirst() == currentFloor) {
                elevator.removeRequest(currentFloor);
                elevator.setState(new StoppedState(elevator));

//                elevator.openDoor();
//                elevator.closeDoor();

            }

            if (elevator.hasArrivedAtDestination()) {

//                elevator.openDoor();
                elevator.setState(new StoppedState(elevator));
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Moving up";
    }
}
