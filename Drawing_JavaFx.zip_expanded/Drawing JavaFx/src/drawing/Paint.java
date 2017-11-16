package drawing;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * Created by lewandowski on 05/09/2017.
 */
public class Paint extends Application {

    private Drawing drawing;
    private Button clearButton;
    private Button circleButton;
    private Button rectangleButton;

    public static void main(String[] args) {
    	
        launch(Paint.class, args);
    }

    public Drawing getDrawing() {
        return drawing;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Première application JavaFx");
        BorderPane border = new BorderPane();

        VBox middleBox = new VBox();
        drawing = new Drawing();
        TextObservateur StatutBox = new TextObservateur(drawing);
        
        
        drawing.widthProperty().bind(middleBox.widthProperty());
        drawing.heightProperty().bind(middleBox.heightProperty());
        middleBox.getChildren().add(drawing);
        VBox.setVgrow(drawing, Priority.ALWAYS);
        border.setCenter(middleBox);

        border.setTop(createButtonsBox());
       
        border.setBottom(createStatutBox());
        Scene scene = new Scene(border, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public HBox createStatutBox() {
	   	 //Barre statut
	       HBox statut = new HBox();
	       statut.setPadding(new Insets(30,24,30,24));
	       statut.setStyle("-fx-background-color: #336699;");
	       
	       TextObservateur compteurFormes = new TextObservateur(drawing);
	       statut.getChildren().add(compteurFormes);
	   
	       return statut;
	   }
    
    private HBox createButtonsBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        
        clearButton = new Button("Clear");
        clearButton.setOnAction(new ClearButtonHandler(drawing));

        circleButton = new Button("Cercle");
        circleButton.addEventHandler(ActionEvent.ACTION, new CircleButtonHandler(drawing));

        rectangleButton = new Button("Rectangle");
        rectangleButton.addEventHandler(ActionEvent.ACTION, new RectangleButtonHandler(drawing));

        Button grouperButton = new Button("Grouper");
        grouperButton.addEventHandler(ActionEvent.ACTION, new GroupeFormeHandler(drawing));
        
        Button degrouperButton = new Button("Dégrouper");
        //grouperButton.addEventHandler(ActionEvent.ACTION, new GroupeFormeHandler(drawing));
        
        hbox.getChildren().addAll(clearButton, circleButton, rectangleButton, grouperButton, degrouperButton);
        return hbox;
    
	}
}
