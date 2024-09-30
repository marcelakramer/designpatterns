package mediator;

public abstract class InternalButton extends Component {
    public InternalButton(InternalPanel mediator) {
        super(mediator);
    }

    public abstract void press();
}