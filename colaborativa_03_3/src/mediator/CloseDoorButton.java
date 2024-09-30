package mediator;

public class CloseDoorButton extends InternalButton {
    public CloseDoorButton(InternalPanel mediator) {
        super(mediator);
    }

    @Override
    public void press() {
        System.out.println("Button pressed to close the door");
        notifyMediator("press");
    }
}