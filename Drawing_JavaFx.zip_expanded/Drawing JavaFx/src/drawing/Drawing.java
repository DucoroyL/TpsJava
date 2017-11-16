package drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lewandowski on 05/09/2017.
 */
public class Drawing extends Canvas implements Iterable<Shape>, Observable{

    DrawingMouseEventHandler handler;
    GraphicsContext gc;
    @SuppressWarnings("unused")
	private ArrayList<Observateur> tabObservateur;

    private ArrayList<Shape> shapes;
    int nbShapes;

    public Drawing() {
        super();
        shapes = new ArrayList<>();
        nbShapes=0;
        gc = getGraphicsContext2D();
        handler = new DrawingMouseEventHandler(this);
        tabObservateur= new ArrayList();
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, handler);
        this.addEventHandler(MouseEvent.MOUSE_RELEASED, handler);
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        notifierObservateurs();
        repaint();
    }

    public void clear() {
        shapes.clear();
        notifierObservateurs();
        repaint();
    }

    public void repaint() {
        gc.clearRect(0,0,getWidth(), getHeight());
        for (Shape s: shapes) {
            s.paint(gc);
        }
    }
    
    public int nbShapes(){
    	return shapes.size();
    }

    @Override
    public boolean isResizable() {
        return true;
    }

	@Override
	public void ajouterObservateur(Observateur o) {
		tabObservateur.add(o);
	}

	@Override
	public void supprimerObservateur(Observateur o) {
		tabObservateur.remove(o);
	}

	@Override
	public void notifierObservateurs() {
		for (int i = 0; i < tabObservateur.size(); i++) {
			tabObservateur.get(i).actualiser(this);
			System.out.println(tabObservateur.get(i));
		}
	}
}
