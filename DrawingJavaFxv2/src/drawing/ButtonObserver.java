package drawing;

import javafx.scene.control.Button;

public class ButtonObserver extends Button implements DrawingObserver {
	public ButtonObserver(String name){
		super(name);
		CommandHistory.getInstanceHistory().addOberser(this);
		this.setDisable(true);
	}
	@Override
	public void update() {
		if(CommandHistory.getInstanceHistory().returnUndo().size() > 0){
			if (this.getText() == "Undo"){
				this.setDisable(false);
			}
		} else {
				if (this.getText() == "Undo"){
					this.setDisable(true);					
				}
		}
		if(CommandHistory.getInstanceHistory().returnRedo().size() > 0){
			if (this.getText() == "Redo"){
				this.setDisable(false);
			}
		}
		else{
			if (this.getText() == "Redo"){
				this.setDisable(true);
			}
			
		}
	}
}
