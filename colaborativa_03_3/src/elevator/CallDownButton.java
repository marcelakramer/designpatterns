package elevator;

public class CallDownButton {
    private final int floor;
    private final ElevatorControlCenter controller;

    public CallDownButton(int floor, ElevatorControlCenter controller) {
        this.floor = floor;
        this.controller = controller;
    }

    public void callElevator() {
        System.out.println("Calling the elevator down to floor: " + floor);
        controller.selectFloor(floor, false); // false indicates a down request
    }
}
