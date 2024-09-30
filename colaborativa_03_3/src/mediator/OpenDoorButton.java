package mediator;

public class OpenDoorButton extends InternalButton {
    public OpenDoorButton(InternalPanel mediator) {
        super(mediator);
    }

    @Override
    public void press() {
        System.out.println("Button pressed to open the door");
        notifyMediator("press");
    }
}
