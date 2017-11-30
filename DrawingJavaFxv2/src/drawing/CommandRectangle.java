package drawing;

import javafx.geometry.Point2D;

public class CommandRectangle extends Command {
	protected Point2D origin;
	protected Point2D destination;
	
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
	        drawing.addShape(new Rectangle(new Point2D(x, y), width, height));
	    }
}
