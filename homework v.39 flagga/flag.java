import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
public class flag extends Application{
	
	public static void main(String args []) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		BorderPane border = new BorderPane();
		
		Scene scene = new Scene(border, 600, 350);
		primaryStage.setScene(scene);
		
		Rectangle top = new Rectangle();
		top.setHeight(116);
		top.setWidth(600);
		top.setFill(Color.WHITE);
		border.setTop(top);
		
		Rectangle mid = new Rectangle();
		mid.setHeight(116);
		mid.setWidth(600);
		mid.setFill(Color.BLUE);
		border.setCenter(mid);
		
		Rectangle bot = new Rectangle();
		bot.setHeight(116);
		bot.setWidth(600);
		bot.setFill(Color.RED);
		border.setBottom(bot);
		
		primaryStage.show();
	}

}
