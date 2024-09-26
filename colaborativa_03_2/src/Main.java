import elevator.Elevator;
import elevator.ElevatorControlCenter;
import elevator.ExternalCallButton;
import mediator.InternalPanel;
import observer.ElevatorDisplay;

public class Main {
    public static void main(String[] args) {
        int totalOfFloors = 10;
        Elevator elevator = Elevator.getInstance(totalOfFloors);
        ElevatorDisplay display =  new ElevatorDisplay();
        ElevatorControlCenter controlCenter = new ElevatorControlCenter(elevator);
        controlCenter.addDisplay(display);

        ExternalCallButton buttonFloor3 = new ExternalCallButton(3, controlCenter);
        ExternalCallButton buttonFloor5 = new ExternalCallButton(5, controlCenter);

        InternalPanel internalPanel = new InternalPanel(controlCenter, totalOfFloors);

        buttonFloor3.callElevator();

        internalPanel.getFloorButton(5).press();

        buttonFloor5.callElevator();

        internalPanel.getFloorButton(1).press();

        controlCenter.move();
    }
}
