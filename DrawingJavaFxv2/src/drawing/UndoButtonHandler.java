package drawing;

import javafx.event.Event;
import javafx.event.EventHandler;

public class UndoButtonHandler implements EventHandler<Event>{
	private Drawing drawing;
	
	public UndoButtonHandler(Drawing drawing) {
		this.drawing = drawing;
	}
	
	public void affichListUndo(){
		int indexTabCommand = CommandHistory.getInstanceHistory().returnUndo().size();
		System.out.println("--- List Undo ---");
		
		for (int i = 0; i < indexTabCommand; i++) {
			if (i != indexTabCommand-1){
				System.out.println(CommandHistory.getInstanceHistory().returnUndo().get(i));
			} else {
				System.out.println("UNDO : " + CommandHistory.getInstanceHistory().returnUndo().get(i));
			}
			
		}

	}
	
	@Override
	public void handle(Event event) {
		this.affichListUndo();
		try {
			CommandHistory.getInstanceHistory().undo();
		} catch (Exception e) {
		 System.out.println(e.toString());
		}
	}
}
