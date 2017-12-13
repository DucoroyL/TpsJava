package drawing;

import javafx.geometry.Point2D;

public class CommandRectangle extends Command {
	protected Point2D origin;
	protected Point2D destination;
	protected Shape shape;
	public CommandRectangle(Drawing drawing, Point2D origin, Point2D destination) {
		super(drawing);
		this.origin = origin;
		this.destination = destination;
	}
	
	@Override
	public void execute() {
	        double x = Math.min(origin.getX(),destination.getX());
	        double y = Math.min(origin.getY(),destination.getY());
	        double width = Math.abs(destination.getX()-origin.getX());
	        double height = Math.abs(destination.getY()-origin.getY());
	        shape = new Rectangle(new Point2D(x, y), width, height);
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
		return "Command<Rectangle>";
	}
}
