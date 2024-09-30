package mediator;

import elevator.ElevatorControlCenter;

import java.util.HashMap;
import java.util.Map;

public class InternalPanel implements Mediator {
    private final Map<Integer, FloorButton> floorButtons = new HashMap<>();
    private final OpenDoorButton openDoorButton;
    private final CloseDoorButton closeDoorButton;
    private final ElevatorControlCenter controller;

    public InternalPanel(ElevatorControlCenter controller, int totalFloors) {
        this.controller = controller;

        for (int floor = 0; floor < totalFloors; floor++) {
            FloorButton floorButton = new FloorButton(floor, this);
            floorButtons.put(floor, floorButton);
        }

        this.openDoorButton = new OpenDoorButton(this);
        this.closeDoorButton = new CloseDoorButton(this);
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof FloorButton) {
            int floor = ((FloorButton) sender).getFloor();
            if (event.equals("press")) {
                controller.selectFloor(floor);
            }
        } else if (sender instanceof OpenDoorButton) {
            if (event.equals("press")) {
                controller.openDoor();
            }
        } else if (sender instanceof CloseDoorButton) {
            if (event.equals("press")) {
                controller.closeDoor();
            }
        }
    }

    public OpenDoorButton getOpenDoorButton() {
        return openDoorButton;
    }

    public CloseDoorButton getCloseDoorButton() {
        return closeDoorButton;
    }

    public FloorButton getFloorButton(int floor) {
        return floorButtons.get(floor);
    }
}
