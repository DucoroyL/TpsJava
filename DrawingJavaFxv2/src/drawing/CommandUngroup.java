package drawing;

import java.util.ArrayList;

public class CommandUngroup extends Command {
	protected Group shape;
	public CommandUngroup(Drawing drawing, Group shapes) {
		super(drawing);
		this.shape = shapes;
	}

	@Override
	public void execute() {
		 for (Shape s: shape) {
             drawing.addShape(s);
         }	
		 drawing.removeShape(shape);
		 CommandHistory.getInstanceHistory().addCommand(this);
	}

	@Override
	public void undo() {
	
		drawing.addShape(shape);	
		
	    for (Shape shape : shape) {
          drawing.removeShape(shape);
        }

	}

	@Override
	public void redo() {
		 for (Shape s: shape) {
             drawing.addShape(s);
         }	
		 drawing.removeShape(shape);
	}

	@Override
	public String toString() {
		return "Command<Ungroup>";
	}
}
