package drawing;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by lewandowski on 07/09/2017.
 */
public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(Point2D _origin, double width, double height) {
        super(_origin);
        this.width = width;
        this.height = height;
    }
    public Rectangle(Rectangle rectangle) {
        super(rectangle.origin);
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setFill(Color.GREENYELLOW);
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(3);
        gc.fillRect(origin.getX(), origin.getY(), width, height);
        gc.strokeRect(origin.getX(), origin.getY(), width, height);
    }

    @Override
    public boolean isOn(Point2D p) {
        return (p.getX() > origin.getX() && p.getX() < origin.getX()+width &&
                p.getY() > origin.getY() && p.getY() < origin.getY()+height);
    }

	@Override
	public Rectangle clone() {
		return new Rectangle(this);
	}
}
