package drawing;

import javafx.geometry.Point2D;

public class CommandCircle extends Command {
	protected Point2D origin;
	protected Point2D destination;
	Shape shapeClone;
	public CommandCircle(Drawing drawing, Point2D origin, Point2D destination) {
		super(drawing);
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public void execute() {
		shapeClone = new Circle(origin, destination.distance(origin));
		drawing.addShape(shapeClone);
		CommandHistory.getInstanceHistory().addCommand(this);
	}
	
	
	public void undo() {
		drawing.removeShape(shapeClone);
	}

	
	public void redo() {
		drawing.addShape(shapeClone);
	}

	@Override
	public String toString() {
		return "Command<Circle>";
	}

}
