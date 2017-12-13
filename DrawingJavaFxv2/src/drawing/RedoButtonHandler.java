package drawing;

import javafx.event.Event;
import javafx.event.EventHandler;

public class RedoButtonHandler implements EventHandler<Event> {
	private Drawing drawing;
	
	public RedoButtonHandler(Drawing drawing) {
		this.drawing = drawing;
	}
	
	public void affichListRedo(){
		int indexTabCommand = CommandHistory.getInstanceHistory().returnRedo().size();
		System.out.println("--- List Redo ---");
		
		for (int i = 0; i < indexTabCommand; i++) {
			if (i != indexTabCommand-1){
				System.out.println(CommandHistory.getInstanceHistory().returnRedo().get(i));
			} else {
				System.out.println("REDO : " + CommandHistory.getInstanceHistory().returnRedo().get(i));
			}
			
		}

	}
	@Override
	public void handle(Event event) {
		this.affichListRedo();
		try {
			CommandHistory.getInstanceHistory().redo();
		} catch (Exception e) {
		 System.out.println(e.toString());
		}
		
	}

}
