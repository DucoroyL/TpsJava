package drawing;

/**
 * Created by lewandowski on 07/09/2017.
 */
public class CircleButtonHandler extends ShapeButtonHandler {
    public CircleButtonHandler(Drawing drawing) {
        super(drawing);
    }

    @Override
    protected void createShape() {
       Command commandCircle = new CommandCircle(drawing, origin, destination);
       commandCircle.execute();
    }
}
