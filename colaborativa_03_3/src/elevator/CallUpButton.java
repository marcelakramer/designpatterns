package elevator;

public class CallUpButton {
    private final int floor;
    private final ElevatorControlCenter controller;

    public CallUpButton(int floor, ElevatorControlCenter controller) {
        this.floor = floor;
        this.controller = controller;
    }

    public void callElevator() {
        System.out.println("Calling the elevator up to floor: " + floor);
        controller.selectFloor(floor, true); // true indicates an up request
    }
}
