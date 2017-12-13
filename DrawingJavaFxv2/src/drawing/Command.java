package drawing;

public abstract class Command {
	protected Drawing drawing;
	
	public Command(Drawing drawing){
		this.drawing = drawing;
	}

	public abstract void execute();
	public abstract void undo();
	public abstract void redo();
	
	
	public abstract String toString() ;
}
