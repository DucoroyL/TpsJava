package drawing;

import java.util.Iterator;



import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

public class GroupeFormeHandler implements EventHandler<Event> {
	 private Drawing drawing;
	 protected GroupeForme groupeForme;
	 protected TextObservateur nbShapes;

	public GroupeFormeHandler(Drawing drawing) {
		this.drawing=drawing;
		nbShapes = new TextObservateur(this.drawing);
	}

	@Override
	public void handle(Event event) {
		groupeForme=new GroupeForme(new javafx.geometry.Point2D(0, 0));
		if(drawing.nbShapes() !=0){
			for (Shape shape : drawing) {
				groupeForme.addComponent(shape);
			}
			drawing.clear();
			drawing.addShape(groupeForme);
		}
	}
}
