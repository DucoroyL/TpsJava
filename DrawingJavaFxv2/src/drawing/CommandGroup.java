package drawing;


import java.util.ArrayList;



public class CommandGroup extends Command {
	protected Group group;
	protected ArrayList<Shape> shapes;
	
	public CommandGroup(Drawing drawing, ArrayList<Shape> shapes) {
		super(drawing);
		this.shapes = shapes;
	}
	@Override
	public void execute() {
		group = new Group();
		drawing.addShape(group);
		for (Shape shapes : shapes) {
	    	group.addShape(shapes);
	    }
		
	    for (Shape shape : group) {
          drawing.removeShape(shape);
        }
	    shapes.clear();
	    CommandHistory.getInstanceHistory().addCommand(this);
	}
	
	public void undo() {
		for(Shape shapes : group){
			drawing.addShape(shapes);
		}
		drawing.removeShape(group);
	}
	
	public void redo() {
		drawing.addShape(group);	
		for (Shape shapes : shapes) {
	    	group.addShape(shapes);
	    }
		
	    for (Shape shape : group) {
          drawing.removeShape(shape);
        }
	    shapes.clear();
	}
	@Override
	public String toString() {
		return "Command<Group>";
	}
}
