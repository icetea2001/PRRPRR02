import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;

public class JavaFXbutton extends Application {

	TextField tf = new TextField();
	String nummer = "";
	String nmrOrdning = "";
	ArrayList<String> talOrdning = new ArrayList<String>();
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		tf.setPrefWidth(135);
		tf.setEditable(false);

		Button bc = new Button("clear");
		bc.setPrefSize(45, 10);
		knappEvent(bc);

		HBox top2 = new HBox();
		top2.getChildren().addAll(tf, bc);

		Button[] buttons1 = { 
				new Button("1"),
				new Button("2"), 
				new Button("3") };
		for (int i = 0; i < buttons1.length; i++) {
			buttons1[i].setPrefSize(45, 35);
			knappEvent(buttons1[i]);
		}

		HBox top = new HBox();
		top.getChildren().addAll(buttons1);

		Button[] buttons2 = { 
				new Button("4"), 
				new Button("5"), 
				new Button("6"), };
		for (int i = 0; i < buttons2.length; i++) {
			buttons2[i].setPrefSize(45, 35);
			knappEvent(buttons2[i]);
		}

		HBox mid = new HBox();
		mid.getChildren().addAll(buttons2);

		Button[] buttons3 = { 
				new Button("7"), 
				new Button("8"), 
				new Button("9"), };
		for (int i = 0; i < buttons3.length; i++) {
			buttons3[i].setPrefSize(45, 35);
			knappEvent(buttons3[i]);
		}

		HBox bot = new HBox();
		bot.getChildren().addAll(buttons3);

		Button[] buttons4 = { 
				new Button(","),
				new Button("0"), 
				new Button("="), };
		for (int i = 0; i < buttons4.length; i++) {
			buttons4[i].setPrefSize(45, 35);
			knappEvent(buttons4[i]);
		}

		HBox bot2 = new HBox();
		bot2.getChildren().addAll(buttons4);

		Button[] buttons5 = { 
				new Button("x"), 
				new Button("+"), 
				new Button("-"), 
				new Button("/"),
				new Button("del")};
		for (int i = 0; i < buttons5.length; i++) {
			buttons5[i].setPrefSize(45, 35);
			knappEvent(buttons5[i]);
		}
		
		VBox sidh = new VBox();
		sidh.getChildren().addAll(buttons5);

		BorderPane bp = new BorderPane();
		VBox container = new VBox(top, mid, bot, bot2);
		bp.setRight(sidh);
		bp.setCenter(container);
		bp.setTop(top2);

		Scene scene = new Scene(bp, 180, 250);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void knappEvent(Button knp) {
		if (Character.isDigit(knp.getText().charAt(0))) {
			knp.setOnAction(event -> {
				nummer += knp.getText();
				nmrOrdning += knp.getText();
				tf.setText(nmrOrdning);
			});
		} 
		else if (knp.getText().equals(",")) {
			knp.setOnAction(event -> {
				boolean kma = false;
				for (int i = 0; i < nummer.length(); i++) {
					if(nummer.charAt(i) == ',') {
						kma = true;
					}
				}
				if(!kma) {
					nummer += knp.getText();
					nmrOrdning += knp.getText();
					tf.setText(nmrOrdning);
				}
			});
		}
		else if(knp.getText().equals("clear")) {
			knp.setOnAction(event -> {
				nummer = "";
				nmrOrdning = "";
				talOrdning.clear();
				tf.setText(nmrOrdning);
			});
		}
		else if(knp.getText().equals("del")) {
				knp.setOnAction(event -> {
					delete();
				});
		}
				
		else if(knp.getText().equals("+") || 
				knp.getText().equals("-") || 
				knp.getText().equals("x") || 
				knp.getText().equals("/")) {
			knp.setOnAction(event -> {
				talOrdning.add(nummer.replace(',', '.'));
				talOrdning.add(knp.getText());
				nummer = ("");
				nmrOrdning += (" " + knp.getText() + " ");
				tf.setText(nmrOrdning);
			});
		}
		else if(knp.getText().equals("=")) {
			knp.setOnAction(event -> {
				talOrdning.add(nummer.replace(',', '.'));
				nummer = "";
				double sum = Double.parseDouble(talOrdning.get(0));
				for (int i = 0; i < talOrdning.size(); i++) {
					if(isNummer(talOrdning.get(i)) && i != 0) {
						sum = calc(sum, Double.parseDouble(talOrdning.get(i)), talOrdning.get(i - 1));
					}
				}
				talOrdning.clear();
				nummer = Double.toString(sum).replace('.', ',');
				nmrOrdning = Double.toString(sum).replace('.', ',');
				tf.setText(nmrOrdning);
			});
		}
	}
	
	public boolean isNummer(String s) {
		try {
			double d = Double.parseDouble(s);
		}
		catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}
	
	public double calc(double num1, double num2 , String rknst) {
		if(rknst.equals("+")) {
			return num1 + num2;
		}
		else if(rknst.equals("-")) {
			return num1 - num2;
		}
		else if(rknst.equals("x")) {
			return num1 * num2;
		}
		else if(rknst.equals("/")) {
			return num1 / num2;
		}
		return 0;
	}
	
	public void delete() {
		if(nummer.equals("")) {
			
		}else {
			nummer = nummer.substring(0, nummer.length() - 1);
			nmrOrdning = nmrOrdning.substring(0, nmrOrdning.length() -1);
			tf.setText(nmrOrdning);
		}
		
	}

}
