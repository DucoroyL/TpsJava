package drawing;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ClearButtonHandler implements EventHandler<ActionEvent> {

    Command commandClear;

    public ClearButtonHandler(Command commandClear) {
        this.commandClear = commandClear;
    }
    
    @Override
    public void handle(ActionEvent event) {
	   commandClear.execute();
    }
}
