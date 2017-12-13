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
		CommandHistory.getInstanceHistory().addCommand(this);
	}

	public void undo() {
		drawing.removeShape(shape);
	}


	
	public void redo() {
		drawing.addShape(shape);
	}


	@Override
	public String toString() {
		return "Command<Clone>";
	}

}
