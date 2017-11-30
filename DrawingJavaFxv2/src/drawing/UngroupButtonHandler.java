package drawing;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

public class UngroupButtonHandler implements EventHandler<Event> {

    private Drawing drawing;
    protected ArrayList<Shape> shapes;

    public UngroupButtonHandler(Drawing drawing) {
        this.drawing = drawing;
        shapes = new ArrayList<>();
    }

    @Override
    public void handle(Event event) {
        if (event instanceof ActionEvent) {
            drawing.addEventFilter(MouseEvent.ANY, this);
        }
        if (event instanceof MouseEvent) {
            event.consume();
            if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                for (Shape shape : drawing) {
                    if (shape.isOn(new Point2D(((MouseEvent) event).getX(), ((MouseEvent) event).getY()))
                            && shape instanceof Group) {
                    	shapes.add(shape);
                        for (Shape s: (Group)shape) {
                            drawing.addShape(s);
                        }
                        drawing.removeShape(shape);
                        break;
                    }
                }
                drawing.removeEventFilter(MouseEvent.ANY, this);

            }
        }
    }
}
