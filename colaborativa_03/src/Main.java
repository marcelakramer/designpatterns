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

        CallUpButton buttonFloor3 = new CallUpButton(3, controlCenter);
        buttonFloor3.callElevator();
        internalPanel.getFloorButton(5).press();

        CallDownButton buttonFloor2 = new CallDownButton(2, controlCenter);
        buttonFloor2.callElevator();
        internalPanel.getFloorButton(1).press();

        controlCenter.move();
    }
}
