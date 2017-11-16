package drawing;

import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class GroupeForme extends Shape {

	private ArrayList<Shape> shapes;
	
	public GroupeForme(Point2D origin) {
		super(origin);
		shapes = new ArrayList<Shape>();
	}

	public void setOrigin(double x, double y){
		double xOrigin=0;
		double yOrigin=0;
		
		if(origin!=null){
			xOrigin = x-origin.getX();
			yOrigin = y-origin.getY();	
		}		
		this.origin=new Point2D(x,y);
		if(shapes !=null){
			for (Shape shape : shapes) {
				shape.setOrigin(shape.getOrigin().getX()+xOrigin, shape.getOrigin().getY()+yOrigin);
				System.out.println("Entrée");
			}	
		}
	}
	
	@Override
	public void paint(GraphicsContext gc) {
		for (Shape shape : shapes) {
			shape.paint(gc);
		}
	}

	@Override
	public boolean isOn(Point2D p) {
		for (Shape shape : shapes) {
			if (shape.isOn(p)){
				return true;
			}
		}

		return false;
	}
	
	public void addComponent(Shape component){
		shapes.add(component);
	}
	
	public void removeComponent(Shape component){
		shapes.remove(component);
	}
	
	public Shape getChild(int index){
		return shapes.get(index);
	}
}
