import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
public class JavaFXbutton extends Application{
	
	public static void main(String args []) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button("click");
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
