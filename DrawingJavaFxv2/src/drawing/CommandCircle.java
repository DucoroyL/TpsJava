package drawing;

import javafx.geometry.Point2D;

public class CommandCircle extends Command {
	protected Point2D origin;
	protected Point2D destination;
	
	public CommandCircle(Drawing drawing, Point2D origin, Point2D destination) {
		super(drawing);
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public void execute() {
		drawing.addShape(new Circle(origin, destination.distance(origin)));
	}

}
