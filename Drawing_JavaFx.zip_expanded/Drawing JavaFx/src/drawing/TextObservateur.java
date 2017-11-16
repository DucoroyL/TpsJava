package drawing;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TextObservateur extends Text implements Observateur {

	Drawing draw;
	public TextObservateur(Drawing D){
		this.draw=D;
		draw.ajouterObservateur(this);
		this.setText(draw.nbShapes() + " shape(s)");
	}
	@Override
	public void actualiser(Observable o) {
		this.setText(draw.nbShapes() + " shape(s)");
	}

	
}
