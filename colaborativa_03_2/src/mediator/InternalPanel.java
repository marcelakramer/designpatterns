package mediator;

import elevator.ElevatorControlCenter;

import java.util.HashMap;
import java.util.Map;

public class InternalPanel {
    private final Map<Integer, InternalButton> floorButtons = new HashMap<>();
    private final InternalButton openDoorButton;
    private final InternalButton closeDoorButton;
    private final ElevatorControlCenter controller;

    public InternalPanel(ElevatorControlCenter controller, int totalFloors) {
        this.controller = controller;

        for (int floor = 0; floor < totalFloors; floor++) {
            floorButtons.put(floor, new FloorButton(floor, this));
        }

        openDoorButton = new OpenDoorButton(this);
        closeDoorButton = new CloseDoorButton(this);
    }

    public void pressFloorButton(int floor) {
        if (floorButtons.containsKey(floor)) {
            controller.selectFloor(floor);
        } else {
            System.out.println("Button for floor " + floor + " not found.");
        }
    }

    public void pressOpenDoorButton() {
        controller.openDoor();
    }

    public void pressCloseDoorButton() {
        controller.closeDoor();
    }

    public InternalButton getFloorButton(int floor) {
        return floorButtons.get(floor);
    }

    public InternalButton getOpenDoorButton() {
        return openDoorButton;
    }

    public InternalButton getCloseDoorButton() {
        return closeDoorButton;
    }
}

