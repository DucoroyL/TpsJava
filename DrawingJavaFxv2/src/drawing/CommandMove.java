package drawing;

public class CommandMove extends Command {
	private Shape shape;
	private double orgX;
	private double orgY;
	private double finX;
	private double finY;

	public CommandMove(Drawing drawing, Shape shape, double x, double y, double finX, double finY) {
		super(drawing);
		this.shape = shape;
		this.orgX = x;
		this.orgY = y;
		this.finX = finX;
		this.finY = finY;
		CommandHistory.getInstanceHistory().addCommand(this);
	}

	@Override
	public void execute() {	
		shape.setOrigin(finX, finY);	
	}

	
	public void undo() {
		shape.setOrigin(orgX, orgY);	
		drawing.repaint();
	}

	
	public void redo() {
     	execute();
		drawing.repaint();
	}

	@Override
	public String toString() {
		return "Command<Move>";
	}

}
