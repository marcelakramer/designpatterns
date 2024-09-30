package mediator;

public class FloorButton extends InternalButton {
    private final int floor;

    public FloorButton(int floor, InternalPanel mediator) {
        super(mediator);
        this.floor = floor;
    }

    @Override
    public void press() {
        System.out.println("Button pressed to go to floor " + floor);
        notifyMediator("press");
    }

    public int getFloor() {
        return floor;
    }
}
