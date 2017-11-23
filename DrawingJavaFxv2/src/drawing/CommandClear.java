package drawing;

public class CommandClear extends Command {

	public CommandClear(Drawing drawing){
		super(drawing);
	}
	@Override
	public void execute() {
		drawing.clear();
	}

}
