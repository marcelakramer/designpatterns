import elevator.*;
import mediator.InternalPanel;
import observer.ElevatorDisplay;

public class Main {
    public static void main(String[] args) {
        int totalOfFloors = 10;
        Elevator elevator = Elevator.getInstance(totalOfFloors);
        ElevatorDisplay elevatorDisplay = new ElevatorDisplay();
        ElevatorControlCenter controlCenter = new ElevatorControlCenter(elevator);
        controlCenter.addObserver(elevatorDisplay);

        InternalPanel internalPanel = new InternalPanel(controlCenter, totalOfFloors);

        // Create call buttons for floors 0 to totalOfFloors-1
        for (int i = 0; i < totalOfFloors; i++) {
            new CallUpButton(i, controlCenter);
            new CallDownButton(i, controlCenter);
        }

        // Simulate button presses
        CallUpButton buttonFloor3 = new CallUpButton(3, controlCenter);
        buttonFloor3.callElevator(); // Call elevator up from floor 3
        internalPanel.getFloorButton(2).press();

        CallDownButton buttonFloor5 = new CallDownButton(5, controlCenter);
        buttonFloor5.callElevator(); // Call elevator down from floor 5
        internalPanel.getFloorButton(1).press();

        controlCenter.move(); // Move elevator based on requests
    }
}
