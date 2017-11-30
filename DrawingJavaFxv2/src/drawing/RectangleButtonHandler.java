package drawing;

/**
 * Created by lewandowski on 07/09/2017.
 */
public class RectangleButtonHandler extends ShapeButtonHandler {
	
    public RectangleButtonHandler(Drawing drawing) {
        super(drawing);
    }

    @Override
    protected void createShape() {
    	Command commandRectangle = new CommandRectangle(drawing, origin, destination);
        commandRectangle.execute();
    }
    
}
