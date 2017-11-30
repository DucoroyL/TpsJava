package drawing;

import java.util.ArrayList;

public class CommandUngroup extends Command {
	protected ArrayList<Shape> shapes;
	public CommandUngroup(Drawing drawing, ArrayList<Shape> shapes) {
		super(drawing);
		this.shapes = shapes;
	}

	@Override
	public void execute() {
		 for (Shape s: (Group)shapes.) {
             drawing.addShape(s);
         }	
		 for (Shape s: shapes) {
			  drawing.removeShape(s);
         }
         break;
	}
}
