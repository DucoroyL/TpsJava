package drawing;

import java.util.ArrayList;

public class CommandClear extends Command {
	protected ArrayList<Shape> shapes;
	public CommandClear(Drawing drawing){
		super(drawing);
	}
	@Override
	public void execute() {
		shapes = new ArrayList<Shape>(drawing.getTabShape());
		drawing.clear();
		CommandHistory.getInstanceHistory().addCommand(this);
		
	}
	
	public void undo() {
		for (Shape shape : shapes){
			drawing.addShape(shape);
		}
	}
	
	public void redo() {
		drawing.clear();
	}
	@Override
	public String toString() {
		return "Command<Clear>";
	}
}
