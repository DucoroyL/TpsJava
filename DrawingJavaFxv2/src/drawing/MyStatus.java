package drawing;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MyStatus extends HBox implements DrawingObserver {

    Drawing drawing;
    Label label;
    

    public MyStatus(Drawing drawing) {
        this.drawing = drawing;
        drawing.addDrawingOberser(this);
        label = new Label(drawing.nbShapes() + " shape(s) ");
        this.getChildren().addAll(label);
    }

    @Override
    public void update() {
        this.label.setText(drawing.nbShapes() + " shape(s)");
    }
}
