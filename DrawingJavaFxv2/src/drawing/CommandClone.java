package drawing;

public class CommandClone extends Command {
	Shape shape;
	public CommandClone(Drawing drawing, Shape shape) {
		super(drawing);
		this.shape = shape;
	}


	@Override
	public void execute() {
		shape = shape.clone();
		drawing.addShape(shape);
	}

}
