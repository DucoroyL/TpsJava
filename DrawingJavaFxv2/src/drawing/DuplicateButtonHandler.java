package drawing;

import javafx.geometry.Point2D;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DuplicateButtonHandler implements EventHandler<Event> {
	Drawing drawing;
	Shape cloneShape;
	
	
	public DuplicateButtonHandler(Drawing drawing){
		this.drawing = drawing;
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
	                    if ( shape.isOn(new Point2D(((MouseEvent) event).getX(), ((MouseEvent) event).getY()))){
	                    	cloneShape = shape.clone();
	                    	drawing.addShape(cloneShape);
	                    	break;
	                    } 
	                }
				 drawing.removeEventFilter(MouseEvent.ANY, this);
			 }
		 }
	}

}
