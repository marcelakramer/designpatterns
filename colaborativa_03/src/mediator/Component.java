package mediator;

public abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public void notifyMediator(String event) {
        mediator.notify(this, event);
    }
}
