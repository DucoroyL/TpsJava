package drawing;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistory{
	private Stack<Command> listRedo = new Stack<Command> ();
	private Stack<Command> listUndo = new Stack<Command> ();
    private ArrayList<DrawingObserver> observers ;

	private CommandHistory() {
		 observers = new ArrayList<>();
	}
	
	private static CommandHistory instanceHistory = null;
	
	public static CommandHistory getInstanceHistory(){
		if (instanceHistory == null){
			instanceHistory = new CommandHistory();
		}
		return instanceHistory;
	}
	
    public void addOberser(DrawingObserver obs) {
        observers.add(obs);
    }
    public void removeObserver(DrawingObserver obs) {
        observers.remove(obs);
    }

    private void notifyObservers() {
        for (DrawingObserver obs: observers)
            obs.update();
    }
	public void addCommand (Command command){
		listUndo.add(command);
		notifyObservers();
	}
	
	public Stack<Command> returnRedo(){
		return listRedo;
	}
	
	public Stack<Command> returnUndo(){
		return listUndo;
	}
	public boolean canDo (){
		return (listRedo.size() > 0);
	}
	
	public boolean canUndo (){
		return (listUndo.size() > 0);
	}
	
	public void undo () throws Exception{
		if (canUndo ()){
			Command command = listUndo.get(listUndo.size()-1);
			command.undo();
			listRedo.add(command);
			listUndo.remove(command);
			notifyObservers();
		}else throw new Exception("Not enougth actions to undo");
	}
	
	public void redo () throws Exception{
		if (canDo ()){
			Command command = listRedo.get(listRedo.size()-1);
			command.redo();
			listUndo.add(command);
			listRedo.remove(command);
			notifyObservers();
		}else throw new Exception("Not enougth actions to undo");
	}
}
