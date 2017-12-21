package drawing;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 05/09/2017.
 */
public class DrawingMouseEventHandler implements EventHandler<MouseEvent> {

    private Drawing drawing;

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;
    
    private double finSceneX;
    private double finSceneY;
    private boolean testMove = false;
    private double newTranslateX;
    private double newTranslateY;
    private Command commandMove;
    
    private Shape currentShape;

    public DrawingMouseEventHandler(Drawing drawing) {
        this.drawing = drawing;
    }
    
    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();

            for (Shape s : drawing) {
                if (s.isOn(new Point2D(event.getX(), event.getY()))) {
                    currentShape = s;
                }
            }
            if (currentShape != null) {
                testMove = true;
            	orgTranslateX = currentShape.getOrigin().getX();
                orgTranslateY = currentShape.getOrigin().getY();
            }
        }
       
        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
        	double finSceneX = event.getSceneX();
        	double finSceneY = event.getSceneY();
            double offsetX = finSceneX - orgSceneX;
            double offsetY = finSceneY - orgSceneY;
            newTranslateX = orgTranslateX + offsetX;
            newTranslateY = orgTranslateY + offsetY;

            if (currentShape != null) {
            	currentShape.setOrigin(newTranslateX, newTranslateY);	
            	drawing.repaint();
            }
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            if (testMove){
            	commandMove = new CommandMove(drawing, currentShape, orgTranslateX, orgTranslateY, newTranslateX, newTranslateY);
            }
            testMove = false;
        	
            currentShape = null;
        }
    }
}
