package mediator;

public abstract class InternalButton {
    protected final InternalPanel mediator;

    public InternalButton(InternalPanel mediator) {
        this.mediator = mediator;
    }

    public abstract void press();
}