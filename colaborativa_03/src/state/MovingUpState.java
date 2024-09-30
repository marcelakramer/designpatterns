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
        for (int i = elevator.getCurrentFloor(); i <= elevator.getRequestQueue().getFirst(); i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int currentFloor = elevator.getCurrentFloor() + 1;
            elevator.setCurrentFloor(currentFloor);

            if (elevator.getRequestQueue().contains(currentFloor) && !elevator.getOutDownRequestQueue().contains(currentFloor)) {
                elevator.removeRequest(currentFloor);
                elevator.setState(new StoppedState(elevator));
                elevator.move();
                return;
            }

            if (elevator.hasArrivedAtDestination()) {
                elevator.setState(new StoppedState(elevator));
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Moving up";
    }
}
